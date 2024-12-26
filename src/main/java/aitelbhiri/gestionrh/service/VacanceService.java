package aitelbhiri.gestionrh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import aitelbhiri.gestionrh.model.Vacance;
import aitelbhiri.gestionrh.repository.VacanceRepository;

@Service
public class VacanceService {

    private final VacanceRepository vacanceRepository;

    public VacanceService(VacanceRepository vacanceRepository) {
        this.vacanceRepository = vacanceRepository;
    }

    public List<Vacance> getAllVacances() {
        return vacanceRepository.findAll();
    }

    public Vacance getVacanceById(int id) {
        return vacanceRepository.findById(id).orElse(null);
    }

    public Vacance addVacance(Vacance vacance) {
        return vacanceRepository.save(vacance);
    }

    public Vacance updateVacance(int id, Vacance updatedVacance) {
        Vacance existingVacance = getVacanceById(id);

        // Mise à jour des attributs de la vacance existante avec les attributs de la vacance mise à jour
        existingVacance.setNom_vacance(updatedVacance.getNom_vacance());
        existingVacance.setDatedebut_vacance(updatedVacance.getDatedebut_vacance());
        existingVacance.setDatefin_vacance(updatedVacance.getDatefin_vacance());
        existingVacance.setNbrjour_vacance(updatedVacance.getNbrjour_vacance());
        // Vous pouvez mettre à jour d'autres attributs selon vos besoins

        return vacanceRepository.save(existingVacance);
    }

    public void deleteVacance(int id) {
        Vacance existingVacance = getVacanceById(id);
        vacanceRepository.delete(existingVacance);
    }
    
    public long countVacances() {
        return vacanceRepository.count();
    }

}
