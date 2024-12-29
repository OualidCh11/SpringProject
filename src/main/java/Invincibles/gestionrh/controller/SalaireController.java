package Invincibles.gestionrh.controller;

import java.util.List;

import Invincibles.gestionrh.model.Salaire;
import Invincibles.gestionrh.service.SalaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/salaires")
public class SalaireController {

    
    private final SalaireService salaireService;

    public SalaireController(SalaireService salaireService) {
        this.salaireService = salaireService;
    }
    
    @GetMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public List<Salaire> getAllSalaires() {
        return salaireService.getAllSalaires();
    }


    @PostMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public Salaire calculateSalaire(@RequestBody Salaire salaire) {
        Salaire calculatedSalaire = salaireService.calculateSalaire(salaire);
        return salaireService.saveSalaire(calculatedSalaire);
    }
    
    // Endpoint pour mettre à jour les détails d'un employé
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Salaire> updateSalaire(@PathVariable int id, @RequestBody Salaire salaire) {
        
    	Salaire updatedSalaire = salaireService.updateSalaire(id, salaire);
        
        if (updatedSalaire != null) {
            return ResponseEntity.ok(updatedSalaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Endpoint pour supprimer un employé
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Void> deleteSalaire(@PathVariable int id) {
    	salaireService.deleteSalaire(id);
        return ResponseEntity.noContent().build();
    }
    


}
