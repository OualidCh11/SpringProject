package aitelbhiri.gestionrh.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aitelbhiri.gestionrh.model.Parametre;
import aitelbhiri.gestionrh.service.ParametreService;

@CrossOrigin("*")
@RestController
@RequestMapping("/parametres")
public class ParametreController {


    private final ParametreService parametreService;

    public ParametreController(ParametreService parametreService) {
        this.parametreService = parametreService;
    }	
    
    @GetMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public ResponseEntity<List<Parametre>> getAllParametres() {
        List<Parametre> parametres = parametreService.getAllParametres();
        return new ResponseEntity<>(parametres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public ResponseEntity<Parametre> getParametreById(@PathVariable int id) {
    	Parametre parametre = parametreService.getParametreById(id);
        if (parametre != null) {
            return new ResponseEntity<>(parametre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Parametre> addParametre(@RequestBody Parametre parametre) {
    	Parametre newParametre = parametreService.addParametre(parametre);
        return new ResponseEntity<>(newParametre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public ResponseEntity<Parametre> updateParametre(@PathVariable int id, @RequestBody Parametre updatedParametre) {
    	Parametre updated = parametreService.updateParametre(id, updatedParametre);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
