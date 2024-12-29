package Invincibles.gestionrh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Invincibles.gestionrh.model.Repos;

public interface ReposRepository  extends JpaRepository<Repos, Integer>{
	
    @Query("SELECT r FROM Repos r WHERE r.id = :id")
    Repos getRepos(@Param("id") int id);

    @Query("SELECT r FROM Repos r")
    List<Repos> getRepos();
    
    @Query("SELECT r FROM Repos r WHERE r.employe.id = :employeeId")
    List<Repos> findByEmployeId(@Param("employeeId") int employeeId);
    
    long count();

}
