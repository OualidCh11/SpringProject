package Invincibles.gestionrh.controller;

import java.util.List;

import Invincibles.gestionrh.model.GestionnaireRH;
import Invincibles.gestionrh.service.GestionnaireRHService;
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

@CrossOrigin("*")
@RestController
@RequestMapping("/gestionnairesrh")
public class GestionnaireRHController {

    private final GestionnaireRHService gestionnaireRHService;

    public GestionnaireRHController(GestionnaireRHService gestionnaireRHService) {
        this.gestionnaireRHService = gestionnaireRHService;
    }

    // Endpoint pour récupérer tous les gestionnaires RH
    @GetMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public List<GestionnaireRH> getAllGestionnairesRH() {
        return gestionnaireRHService.getAllGestionnairesRH();
    }

    // Endpoint pour récupérer un gestionnaire RH par son ID
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<GestionnaireRH> getGestionnaireRHById(@PathVariable int id) {
        GestionnaireRH gestionnaireRH = gestionnaireRHService.getGestionnaireRHById(id);
        if (gestionnaireRH != null) {
            return ResponseEntity.ok(gestionnaireRH);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour créer un nouveau gestionnaire RH
    @PostMapping
    public ResponseEntity<GestionnaireRH> createGestionnaireRH(@RequestBody GestionnaireRH gestionnaireRH) {
        GestionnaireRH newGestionnaireRH = gestionnaireRHService.addGestionnaireRH(gestionnaireRH);
        return ResponseEntity.status(HttpStatus.CREATED).body(newGestionnaireRH);
    }

    // Endpoint pour mettre à jour les détails d'un gestionnaire RH
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<GestionnaireRH> updateGestionnaireRH(@PathVariable int id, @RequestBody GestionnaireRH gestionnaireRH) {
        GestionnaireRH updatedGestionnaireRH = gestionnaireRHService.updateGestionnaireRH(id, gestionnaireRH);
        if (updatedGestionnaireRH != null) {
            return ResponseEntity.ok(updatedGestionnaireRH);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour supprimer un gestionnaire RH
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Void> deleteGestionnaireRH(@PathVariable int id) {
        gestionnaireRHService.deleteGestionnaireRH(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/count")
    public long countGestionnairesrh() {
        return gestionnaireRHService.countGestionnairesrh();
    }

}
