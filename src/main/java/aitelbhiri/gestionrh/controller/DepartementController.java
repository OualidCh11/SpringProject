package aitelbhiri.gestionrh.controller;

import java.util.List;

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

import aitelbhiri.gestionrh.model.Departement;
import aitelbhiri.gestionrh.service.DepartementService;
@CrossOrigin("*")
@RestController
@RequestMapping("/departements")
public class DepartementController {

    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public List<Departement> getAllDepartements() {
        return departementService.getAllDepartements();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public Departement getDepartementById(@PathVariable int id) {
        return departementService.getDepartementById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public Departement addDepartement(@RequestBody Departement departement) {
        return departementService.addDepartement(departement);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public Departement updateDepartement(@PathVariable int id, @RequestBody Departement departement) {
        return departementService.updateDepartement(id, departement);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public void deleteDepartement(@PathVariable int id) {
        departementService.deleteDepartement(id);
    }
    
    @GetMapping("/count")
    public long countDepartements() {
        return departementService.countDepartements();
    }

}
