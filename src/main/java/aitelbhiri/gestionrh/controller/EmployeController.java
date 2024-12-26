package aitelbhiri.gestionrh.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aitelbhiri.gestionrh.model.Employe;

import aitelbhiri.gestionrh.service.EmployeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/employes")
public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }
    
    
    // Endpoint pour récupérer tous les employés
    @GetMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    // Endpoint pour récupérer un employé par son ID
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public ResponseEntity<Employe> getEmployeById(@PathVariable int id) {
        Employe employe = employeService.getEmployeById(id);
        if (employe != null) {
            return ResponseEntity.ok(employe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour créer un nouvel employé
    @PostMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        Employe newEmploye = employeService.addEmploye(employe);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmploye);
    }

    // Endpoint pour mettre à jour les détails d'un employé
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Employe> updateEmploye(@PathVariable int id, @RequestBody Employe employe) {
        System.out.println("Received ID: " + id);
        System.out.println("Received Employe: " + employe);
        
        Employe updatedEmploye = employeService.updateEmploye(id, employe);
        
        if (updatedEmploye != null) {
            return ResponseEntity.ok(updatedEmploye);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour supprimer un employé
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Void> deleteEmploye(@PathVariable int id) {
    	employeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/count")
    public long countEmployes() {
        return employeService.countEmployes();
    }
    

}
