package aitelbhiri.gestionrh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import aitelbhiri.gestionrh.model.GestionnaireRH;
import aitelbhiri.gestionrh.repository.GestionnaireRHRepository;

@Service
public class GestionnaireRHService {

    private final GestionnaireRHRepository gestionnaireRHRepository;

    public GestionnaireRHService(GestionnaireRHRepository gestionnaireRHRepository) {
        this.gestionnaireRHRepository = gestionnaireRHRepository;
    }

    // Méthode pour ajouter un nouveau gestionnaire RH
    public GestionnaireRH addGestionnaireRH(GestionnaireRH gestionnaireRH) {
        return gestionnaireRHRepository.save(gestionnaireRH);
    }

    // Méthode pour récupérer un gestionnaire RH par son ID
    public GestionnaireRH getGestionnaireRHById(int id) {
        return gestionnaireRHRepository.findById(id).orElse(null);
    }

    // Méthode pour récupérer tous les gestionnaires RH
    public List<GestionnaireRH> getAllGestionnairesRH() {
        return gestionnaireRHRepository.findAll();
    }

    // Méthode pour mettre à jour les informations d'un gestionnaire RH
    public GestionnaireRH updateGestionnaireRH(int id, GestionnaireRH updatedGestionnaireRH) {
        GestionnaireRH existingGestionnaireRH = gestionnaireRHRepository.findById(id).orElse(null);
        if (existingGestionnaireRH != null) {
            // Mettez à jour les attributs de existingGestionnaireRH avec les attributs de updatedGestionnaireRH
            existingGestionnaireRH.setMatricule(updatedGestionnaireRH.getMatricule());
            existingGestionnaireRH.setUsername(updatedGestionnaireRH.getUsername());
            existingGestionnaireRH.setNom(updatedGestionnaireRH.getNom());
            existingGestionnaireRH.setPrenom(updatedGestionnaireRH.getPrenom());
            existingGestionnaireRH.setDatenaissance(updatedGestionnaireRH.getDatenaissance());
            existingGestionnaireRH.setVille(updatedGestionnaireRH.getVille());
            existingGestionnaireRH.setCin(updatedGestionnaireRH.getCin());
            existingGestionnaireRH.setEmail(updatedGestionnaireRH.getEmail());
            existingGestionnaireRH.setPassword(updatedGestionnaireRH.getPassword());
            existingGestionnaireRH.setAge(updatedGestionnaireRH.getAge());
            existingGestionnaireRH.setNumerotelephone(updatedGestionnaireRH.getNumerotelephone());
            existingGestionnaireRH.setSexe(updatedGestionnaireRH.getSexe());

            return gestionnaireRHRepository.save(existingGestionnaireRH);
        }
        return null;
    }

    // Méthode pour supprimer un gestionnaire RH par son ID
    public void deleteGestionnaireRH(int id) {
        gestionnaireRHRepository.deleteById(id);
    }
    
    public long countGestionnairesrh() {
        return gestionnaireRHRepository.count();
    }
    

    // Autres méthodes pour gérer les opérations spécifiques aux gestionnaires RH
}
