package Invincibles.gestionrh.controller;

import Invincibles.gestionrh.model.SalaireConfig;
import Invincibles.gestionrh.service.SalaireConfigService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/salairesconfig")
public class SalaireConfigController {

    private final SalaireConfigService salaireconfigService;

    public SalaireConfigController(SalaireConfigService salaireconfigService) {
        this.salaireconfigService = salaireconfigService;
    }	
    
    @GetMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public ResponseEntity<List<SalaireConfig>> getAllSalairesConfig() {
        List<SalaireConfig> salairesconfig = salaireconfigService.getAllSalairesConfig();
        return new ResponseEntity<>(salairesconfig, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public ResponseEntity<SalaireConfig> getVacanceById(@PathVariable int id) {
    	SalaireConfig salaireconfig = salaireconfigService.getSalaireConfigById(id);
        if (salaireconfig != null) {
            return new ResponseEntity<>(salaireconfig, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<SalaireConfig> addSalaireConfig(@RequestBody SalaireConfig salaireconfig) {
    	SalaireConfig newSalaireConfig = salaireconfigService.addSalaireConfig(salaireconfig);
        return new ResponseEntity<>(newSalaireConfig, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<SalaireConfig> updateSalaireConfig(@PathVariable int id, @RequestBody SalaireConfig updatedSalaireConfig) {
    	SalaireConfig updated = salaireconfigService.updateSalaireConfig(id, updatedSalaireConfig);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Void> deleteSalaireConfig(@PathVariable int id) {
        salaireconfigService.deleteSalaireConfig(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
