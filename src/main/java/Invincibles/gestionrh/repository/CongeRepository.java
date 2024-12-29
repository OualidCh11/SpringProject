package Invincibles.gestionrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Invincibles.gestionrh.model.Conge;

import java.util.List;

public interface CongeRepository extends JpaRepository<Conge, Integer> {

    @Query("SELECT c FROM Conge c WHERE c.id = :id")
    Conge getConge(@Param("id") int id);

    @Query("SELECT c FROM Conge c")
    List<Conge> getConges();
    
    @Query("SELECT c FROM Conge c WHERE c.employe.id = :employeeId")
    List<Conge> findByEmployeId(@Param("employeeId") int employeeId);
    
    long count();

    // Vous pouvez ajouter d'autres requêtes spécifiques si nécessaire
}
