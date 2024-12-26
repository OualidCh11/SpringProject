package aitelbhiri.gestionrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aitelbhiri.gestionrh.model.Reclamation;

import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {

    @Query("SELECT r FROM Reclamation r WHERE r.id = :id")
    Reclamation getReclamationById(@Param("id") int id);

    @Query("SELECT r FROM Reclamation r")
    List<Reclamation> getAllReclamations();

    @Query("SELECT r FROM Reclamation r WHERE r.employe.id = :employeeId")
    List<Reclamation> findByEmployeId(@Param("employeeId") int employeeId);
    
    long count();

    // Ajoutez ici d'autres méthodes spécifiques si nécessaire

}
