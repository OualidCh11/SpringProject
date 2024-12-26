package aitelbhiri.gestionrh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import aitelbhiri.gestionrh.model.Conge;
import aitelbhiri.gestionrh.repository.CongeRepository;

@Service
public class CongeService {

    private final CongeRepository congeRepository;

    public CongeService(CongeRepository congeRepository) {
        this.congeRepository = congeRepository;
    }

    public List<Conge> getAllConges() {
        return congeRepository.findAll();
    }

    public Conge getCongeById(int id) {
    	
        return congeRepository.findById(id).orElse(null);
        
    }

    public Conge addConge(Conge conge) {
        return congeRepository.save(conge);
    }

    public Conge updateConge(int id, Conge updatedConge) {
        Conge existingConge = getCongeById(id);

        // Mise à jour des attributs du congé existant avec les attributs du congé mis à jour
        existingConge.setDatedebut_conge(updatedConge.getDatedebut_conge());
        existingConge.setDatefin_conge(updatedConge.getDatefin_conge());
        existingConge.setType_conge(updatedConge.getType_conge());
        existingConge.setNbrjour_conge(updatedConge.getNbrjour_conge());
        existingConge.setStatus_conge(updatedConge.getStatus_conge());
        existingConge.setReason_conge(updatedConge.getReason_conge());
        existingConge.setEmploye(updatedConge.getEmploye());
        // Vous pouvez mettre à jour d'autres attributs selon vos besoins

        return congeRepository.save(existingConge);
    }

    public void deleteConge(int id) {
        Conge existingConge = getCongeById(id);
        congeRepository.delete(existingConge);
    }
    
    public List<Conge> getCongesByEmployeeId(int employeeId) {
        return congeRepository.findByEmployeId(employeeId);
    }
    
    public long countConges() {
        return congeRepository.count();
    }
}
