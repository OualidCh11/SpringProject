package aitelbhiri.gestionrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aitelbhiri.gestionrh.model.Absence;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {

    @Query("SELECT a FROM Absence a WHERE a.id = :id")
    Absence getAbsence(@Param("id") int id);

    @Query("SELECT a FROM Absence a")
    List<Absence> getAbsences();

    // Vous pouvez ajouter d'autres requêtes spécifiques si nécessaire
}
