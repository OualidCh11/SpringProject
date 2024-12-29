package Invincibles.gestionrh.service;

import java.util.List;

import Invincibles.gestionrh.model.Reclamation;
import org.springframework.stereotype.Service;

import Invincibles.gestionrh.repository.ReclamationRepository;

@Service
public class ReclamationService {

    private final ReclamationRepository reclamationRepository;

    public ReclamationService(ReclamationRepository reclamationRepository) {
        this.reclamationRepository = reclamationRepository;
    }

    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    public Reclamation getReclamationById(int id) {
        return reclamationRepository.findById(id).orElse(null);
    }

    public Reclamation addReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    public Reclamation updateReclamation(int id, Reclamation updatedReclamation) {
        Reclamation existingReclamation = getReclamationById(id);

        // Mise à jour des attributs de la réclamation existante avec les attributs de la réclamation mise à jour
        existingReclamation.setDate_reclamation(updatedReclamation.getDate_reclamation());
        existingReclamation.setSujet(updatedReclamation.getSujet());
        existingReclamation.setDescription(updatedReclamation.getDescription());
        existingReclamation.setStatus(updatedReclamation.getStatus());
        // Vous pouvez mettre à jour d'autres attributs selon vos besoins

        return reclamationRepository.save(existingReclamation);
    }

    public void deleteReclamation(int id) {
        Reclamation existingReclamation = getReclamationById(id);
        reclamationRepository.delete(existingReclamation);
    }
    
    public List<Reclamation> getReclamationsByEmployeeId(int employeeId) {
        return reclamationRepository.findByEmployeId(employeeId);
    }
    
    public long countReclamations() {
        return reclamationRepository.count();
    }


}
