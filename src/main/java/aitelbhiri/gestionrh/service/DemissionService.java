package aitelbhiri.gestionrh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import aitelbhiri.gestionrh.model.Demission;
import aitelbhiri.gestionrh.repository.DemissionRepository;

@Service
public class DemissionService {

    private final DemissionRepository demissionRepository;

    public DemissionService(DemissionRepository demissionRepository) {
        this.demissionRepository = demissionRepository;
    }

    public List<Demission> getAllDemissions() {
        return demissionRepository.findAll();
    }

    public Demission getDemissionById(int id) {
        return demissionRepository.findById(id).orElse(null);
    }

    public Demission addDemission(Demission demission) {
        return demissionRepository.save(demission);
    }

    public Demission updateDemission(int id, Demission updatedDemission) {
    	Demission existingDemission = getDemissionById(id);

        // Mise à jour des attributs de la vacance existante avec les attributs de la vacance mise à jour
        existingDemission.setRaison(updatedDemission.getRaison());
        existingDemission.setDate_avis_demission(updatedDemission.getDate_avis_demission());
        existingDemission.setDate_démission(updatedDemission.getDate_démission());
        // Vous pouvez mettre à jour d'autres attributs selon vos besoins

        return demissionRepository.save(existingDemission);
    }

    public void deleteDemission(int id) {
    	Demission existingDemission = getDemissionById(id);
    	demissionRepository.delete(existingDemission);
    }
    
    public long countDemissions() {
        return demissionRepository.count();
    }
}
