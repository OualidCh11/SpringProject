package Invincibles.gestionrh.controller;

import Invincibles.gestionrh.model.Demission;
import Invincibles.gestionrh.service.DemissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/demissions")
public class DemissionController {

    private final DemissionService demissionService;

    public DemissionController(DemissionService demissionService) {
        this.demissionService = demissionService;
    }	
    
    @GetMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public ResponseEntity<List<Demission>> getAllDemissions() {
        List<Demission> demissions = demissionService.getAllDemissions();
        return new ResponseEntity<>(demissions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public ResponseEntity<Demission> getDemissionById(@PathVariable int id) {
    	Demission demission = demissionService.getDemissionById(id);
        if (demission != null) {
            return new ResponseEntity<>(demission, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Demission> addDemission(@RequestBody Demission demission) {
    	Demission newDemission = demissionService.addDemission(demission);
        return new ResponseEntity<>(newDemission, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Demission> updateDemission(@PathVariable int id, @RequestBody Demission updatedDemission) {
    	Demission updated = demissionService.updateDemission(id, updatedDemission);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Void> deleteDemission(@PathVariable int id) {
        demissionService.deleteDemission(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/count")
    public long countDemissions() {
        return demissionService.countDemissions();
    }
}
