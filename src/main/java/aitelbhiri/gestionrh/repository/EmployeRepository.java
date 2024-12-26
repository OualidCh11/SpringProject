package aitelbhiri.gestionrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aitelbhiri.gestionrh.model.Employe;

import java.util.List;
import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    @Query("SELECT e FROM Employe e WHERE e.id = :id")
    Employe getEmployeById(@Param("id") int id);

    @Query("SELECT e FROM Employe e")
    List<Employe> getAllEmployes();
    
    @Query("SELECT e FROM Employe e WHERE e.email = :email")
    Employe findEmployeByEmail(String email);
    
    Boolean existsByEmail(String email);
    
    Boolean existsByUsername(String username);
    
    Optional<Employe> findByUsername(String username);
    
    long count();
}
