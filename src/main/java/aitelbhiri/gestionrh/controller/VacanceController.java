package aitelbhiri.gestionrh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import aitelbhiri.gestionrh.model.Vacance;
import aitelbhiri.gestionrh.service.VacanceService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/vacances")
public class VacanceController {

    private final VacanceService vacanceService;

    public VacanceController(VacanceService vacanceService) {
        this.vacanceService = vacanceService;
    }	
    
    @GetMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public ResponseEntity<List<Vacance>> getAllVacances() {
        List<Vacance> vacances = vacanceService.getAllVacances();
        return new ResponseEntity<>(vacances, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public ResponseEntity<Vacance> getVacanceById(@PathVariable int id) {
        Vacance vacance = vacanceService.getVacanceById(id);
        if (vacance != null) {
            return new ResponseEntity<>(vacance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Vacance> addVacance(@RequestBody Vacance vacance) {
        Vacance newVacance = vacanceService.addVacance(vacance);
        return new ResponseEntity<>(newVacance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Vacance> updateVacance(@PathVariable int id, @RequestBody Vacance updatedVacance) {
        Vacance updated = vacanceService.updateVacance(id, updatedVacance);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Void> deleteVacance(@PathVariable int id) {
        vacanceService.deleteVacance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/count")
    public long countVacances() {
        return vacanceService.countVacances();
    }

}
