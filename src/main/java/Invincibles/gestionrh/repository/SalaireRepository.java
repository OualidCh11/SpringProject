package Invincibles.gestionrh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Invincibles.gestionrh.model.Salaire;

public interface SalaireRepository extends JpaRepository<Salaire, Integer> {
	
    @Query("Select s from Salaire s where s.id_salaire=:id")
    Salaire getSalaireById(@Param("id") int id);
    
	@Query("Select s from Salaire s ")
	List<Salaire> getAllSalaires();
	
    @Query("SELECT s FROM Salaire s WHERE s.employe.id = :employeeId")
    List<Salaire> findByEmployeId(@Param("employeeId") int employeeId);
    
}
