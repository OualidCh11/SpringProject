package Invincibles.gestionrh.controller;

import java.util.List;

import Invincibles.gestionrh.model.Absence;
import Invincibles.gestionrh.service.AbsenceService;
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
@RequestMapping("/absences")
public class AbsenceController {

    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping
    public List<Absence> getAllAbsences() {
        return absenceService.getAllAbsences();
    }

    @GetMapping("/{id}")
    public Absence getAbsenceById(@PathVariable int id) {
        return absenceService.getAbsenceById(id);
    }

    @PostMapping
    public Absence addAbsence(@RequestBody Absence absence) {
        return absenceService.addAbsence(absence);
    }

    @PutMapping("/{id}")
    public Absence updateAbsence(@PathVariable int id, @RequestBody Absence absence) {
        return absenceService.updateAbsence(id, absence);
    }

    @DeleteMapping("/{id}")
    public void deleteAbsence(@PathVariable int id) {
        absenceService.deleteAbsence(id);
    }
}
