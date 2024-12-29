package Invincibles.gestionrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Invincibles.gestionrh.model.Vacance;

import java.util.List;

public interface VacanceRepository extends JpaRepository<Vacance, Integer> {

    @Query("SELECT v FROM Vacance v WHERE v.id = :id")
    Vacance getVacanceById(@Param("id") int id);

    @Query("SELECT v FROM Vacance v")
    List<Vacance> getAllVacances();
    
    long count();

    // Ajoutez ici d'autres méthodes spécifiques si nécessaire

}
