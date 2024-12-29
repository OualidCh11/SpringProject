package Invincibles.gestionrh.service;

import java.util.List;

import Invincibles.gestionrh.model.Parametre;
import org.springframework.stereotype.Service;

import Invincibles.gestionrh.repository.ParametreRepository;

@Service
public class ParametreService {
	
    private final ParametreRepository parametreRepository;

    public ParametreService(ParametreRepository parametreRepository) {
        this.parametreRepository = parametreRepository;
    }

    public List<Parametre> getAllParametres() {
        return parametreRepository.findAll();
    }

    public Parametre getParametreById(int id) {
        return parametreRepository.findById(id).orElse(null);
    }

    public Parametre addParametre(Parametre parametre) {
        return parametreRepository.save(parametre);
    }

    public Parametre updateParametre(int id, Parametre updatedParametre) {
    	Parametre existingparametre = getParametreById(id);

        // Mise à jour des attributs de la vacance existante avec les attributs de la vacance mise à jour
        existingparametre.setNom_entreprise(updatedParametre.getNom_entreprise());
        existingparametre.setContact_person(updatedParametre.getContact_person());
        existingparametre.setAdresse(updatedParametre.getAdresse());
        existingparametre.setPays(updatedParametre.getPays());
        
        existingparametre.setVille(updatedParametre.getVille());
        existingparametre.setRegion(updatedParametre.getRegion());
        existingparametre.setPostalcode(updatedParametre.getPostalcode());
        
        existingparametre.setEmail(updatedParametre.getEmail());
        existingparametre.setNumtelephone_entreprise(updatedParametre.getNumtelephone_entreprise());
        existingparametre.setFax(updatedParametre.getFax());
        existingparametre.setWebsiteurl(updatedParametre.getWebsiteurl());
        // Vous pouvez mettre à jour d'autres attributs selon vos besoins

        return parametreRepository.save(existingparametre);
    }

}
