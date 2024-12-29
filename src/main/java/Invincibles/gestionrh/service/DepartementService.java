package Invincibles.gestionrh.service;

import java.util.List;

import Invincibles.gestionrh.model.Departement;
import org.springframework.stereotype.Service;

import Invincibles.gestionrh.repository.DepartementRepository;

@Service
public class DepartementService {

    private final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }
    
    
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Departement getDepartementById(int id) {

        return departementRepository.findById(id).orElse(null);

    }

    public Departement addDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public Departement updateDepartement(int id, Departement updatedDepartement) {
        Departement existingDepartement = getDepartementById(id);

        // Mise à jour des attributs du département existant avec les attributs du département mis à jour
        existingDepartement.setNom_departement(updatedDepartement.getNom_departement());
        existingDepartement.setDescription(updatedDepartement.getDescription());
        // Vous pouvez mettre à jour d'autres attributs selon vos besoins

        return departementRepository.save(existingDepartement);
    }

    public void deleteDepartement(int id) {
        Departement existingDepartement = getDepartementById(id);
        departementRepository.delete(existingDepartement);
    }
    
    public long countDepartements() {
        return departementRepository.count();
    }
    

}
