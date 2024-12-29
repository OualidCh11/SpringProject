package Invincibles.gestionrh.service;

import Invincibles.gestionrh.model.Repos;
import Invincibles.gestionrh.repository.EmployeRepository;
import Invincibles.gestionrh.repository.ReposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Invincibles.gestionrh.model.Employe;

@Service
public class ReposService {

    @Autowired
    private ReposRepository reposRepository;

    @Autowired
    private EmployeRepository employeRepository;

    // Create a new congé
    public Repos createRepos(Repos repos) {
        try {
            Employe employee = employeRepository.findById(repos.getEmploye().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Employee not found."));

            int daysRequested = calculateDaysRequested(repos.getDatedebut_repos(), repos.getDatefin_repos());
            int remainingDays = calculateRemainingDays(employee, repos);

            if (daysRequested <= remainingDays) {
                repos.setDaysConsumed(0);
                remainingDays -= daysRequested;
                employee.setTotalAllocatedDays(remainingDays);

                employeRepository.save(employee);
                repos.setRemainingDays(remainingDays);

                return reposRepository.save(repos);
            } else {
                throw new IllegalArgumentException("Not enough remaining congé days.");
            }
        } catch (IllegalArgumentException e) {
            throw e; // Re-throw the exception for higher-level handling
        } catch (Exception ex) {
            throw new RuntimeException("Failed to create congé.", ex);
        }
    }

    public List<Repos> getAllRepos() {
        return reposRepository.findAll();
    }

    public Repos getReposById(int id) {
        return reposRepository.findById(id).orElse(null);
    }

    public Repos updateRepos(int id, Repos updatedRepos) {
        try {
            Repos existingRepos = reposRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Congé not found."));

            existingRepos.setDatedebut_repos(updatedRepos.getDatedebut_repos());
            existingRepos.setDatefin_repos(updatedRepos.getDatefin_repos());
            existingRepos.setStatus_repos(updatedRepos.getStatus_repos());

            Employe employee = employeRepository.findById(existingRepos.getEmploye().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Employee not found."));

            // Calculate the actual days requested based on updated start and end dates
            int daysRequested = calculateDaysRequested(updatedRepos.getDatedebut_repos(),
                    updatedRepos.getDatefin_repos());

            // Calculate the actual days consumed by subtracting days requested from remaining days
            int actualDaysConsumed = existingRepos.getDaysRequested() - daysRequested;

            existingRepos.setDaysRequested(daysRequested);

            int remainingDays = calculateRemainingDays(employee, existingRepos);
            existingRepos.setRemainingDays(remainingDays);

            // Update daysConsumed with the actual days consumed
            existingRepos.setDaysConsumed(actualDaysConsumed);

            return reposRepository.save(existingRepos);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception ex) {
            throw new RuntimeException("Failed to update congé.", ex);
        }
    }


    public void deleteRepos(int id) {
        Repos repos = reposRepository.findById(id).orElse(null);

        if (repos != null) {
            Employe employee = employeRepository.findById(repos.getEmploye().getId()).orElse(null);

            if (employee != null) {
                // Calculate the days requested for the deleted leave request
                int daysRequested = repos.getDaysRequested();

                // Reset the employee's total allocated days by adding back the days requested
                int newTotalAllocatedDays = employee.getTotalAllocatedDays() + daysRequested;
                employee.setTotalAllocatedDays(newTotalAllocatedDays);

                // Save the updated employee
                employeRepository.save(employee);
            }

            // Delete the leave request
            reposRepository.deleteById(id);
        }
    }


    public List<Repos> getReposByEmployeeId(int employeeId) {
        return reposRepository.findByEmployeId(employeeId);
    }

    private int calculateDaysRequested(Date startDate, Date endDate) {
        long timeDifference = endDate.getTime() - startDate.getTime();
        int daysRequested = (int) TimeUnit.DAYS.convert(timeDifference, TimeUnit.MILLISECONDS) + 1;
        return daysRequested;
    }

    private int calculateRemainingDays(Employe employee, Repos repos) {
        int totalAllocatedDays = employee.getTotalAllocatedDays();
        int daysConsumed = repos.getDaysConsumed();
        int remainingDays = totalAllocatedDays - daysConsumed;
        return remainingDays;
    }
    
    public long countRepos() {
        return reposRepository.count();
    }
}
