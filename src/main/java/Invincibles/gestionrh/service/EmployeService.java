package Invincibles.gestionrh.service;

import java.util.List;


import Invincibles.gestionrh.repository.EmployeRepository;
import org.springframework.stereotype.Service;

import Invincibles.gestionrh.model.Employe;

@Service
public class EmployeService {

    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    // Méthode pour ajouter un nouvel employé
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    // Méthode pour récupérer un employé par son ID
    public Employe getEmployeById(int id) {
        return employeRepository.findById(id).orElse(null);
    }

    // Méthode pour récupérer tous les employés
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    // Méthode pour mettre à jour les informations d'un employé
    public Employe updateEmploye(int id, Employe updatedEmploye) {
        Employe existingEmploye = employeRepository.findById(id).orElse(null);
        if (existingEmploye != null) {
            // Mettez à jour les attributs de existingEmploye avec les attributs de updatedEmploye
            existingEmploye.setMatricule(updatedEmploye.getMatricule());
            existingEmploye.setUsername(updatedEmploye.getUsername());
            existingEmploye.setNom(updatedEmploye.getNom());
            existingEmploye.setPrenom(updatedEmploye.getPrenom());
            existingEmploye.setDatenaissance(updatedEmploye.getDatenaissance());
            existingEmploye.setVille(updatedEmploye.getVille());
            existingEmploye.setCin(updatedEmploye.getCin());
            existingEmploye.setEmail(updatedEmploye.getEmail());
            existingEmploye.setPassword(updatedEmploye.getPassword());
            existingEmploye.setAge(updatedEmploye.getAge());
            existingEmploye.setNumerotelephone(updatedEmploye.getNumerotelephone());
            existingEmploye.setSexe(updatedEmploye.getSexe());
            existingEmploye.setDepartement(updatedEmploye.getDepartement());
            existingEmploye.setPost(updatedEmploye.getPost());
            existingEmploye.setRoles(updatedEmploye.getRoles());

            return employeRepository.save(existingEmploye);
        }
        return null;
    }

    // Méthode pour supprimer un employé par son ID
    public void deleteEmploye(int id) {
        employeRepository.deleteById(id);
    }
    
    public long countEmployes() {
        return employeRepository.count();
    }
    

    
    

}

