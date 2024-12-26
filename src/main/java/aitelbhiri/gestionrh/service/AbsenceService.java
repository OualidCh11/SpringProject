package aitelbhiri.gestionrh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import aitelbhiri.gestionrh.model.Absence;
import aitelbhiri.gestionrh.repository.AbsenceRepository;
@Service
public class AbsenceService {

    private final AbsenceRepository absenceRepository;

    public AbsenceService(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    public Absence getAbsenceById(int id) {
        return absenceRepository.findById(id).orElse(null);
    }

    public Absence addAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    public Absence updateAbsence(int id, Absence updatedAbsence) {
        Absence existingAbsence = getAbsenceById(id);

        // Mise à jour des attributs de l'absence existante avec les attributs de l'absence mise à jour
        existingAbsence.setDate_absence(updatedAbsence.getDate_absence());
        existingAbsence.setTypeabsence(updatedAbsence.getTypeabsence());
        existingAbsence.setEmploye(updatedAbsence.getEmploye());
        // Vous pouvez mettre à jour d'autres attributs selon vos besoins

        return absenceRepository.save(existingAbsence);
    }

    public void deleteAbsence(int id) {
        Absence existingAbsence = getAbsenceById(id);
        absenceRepository.delete(existingAbsence);
    }
}
