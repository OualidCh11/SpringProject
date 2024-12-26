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

import aitelbhiri.gestionrh.model.Conge;
import aitelbhiri.gestionrh.service.CongeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/conges")
public class CongeController {

    private final CongeService congeService;

    public CongeController(CongeService congeService) {
        this.congeService = congeService;
    }

    @GetMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public List<Conge> getAllConges() {
        return congeService.getAllConges();
    }

    @GetMapping("/{id}")
    public Conge getCongeById(@PathVariable int id) {
        return congeService.getCongeById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public Conge addConge(@RequestBody Conge conge) {
        return congeService.addConge(conge);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public Conge updateConge(@PathVariable int id, @RequestBody Conge conge) {
        return congeService.updateConge(id, conge);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public void deleteConge(@PathVariable int id) {
        congeService.deleteConge(id);
    }
    
    @GetMapping("/employe/{employeeId}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public List<Conge> getCongesForEmployee(@PathVariable int employeeId) {
        return congeService.getCongesByEmployeeId(employeeId);
    }
    
    @GetMapping("/count")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public long countConges() {
        return congeService.countConges();
    }
    
}
