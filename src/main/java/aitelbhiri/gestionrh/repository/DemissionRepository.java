package aitelbhiri.gestionrh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aitelbhiri.gestionrh.model.Demission;

public interface DemissionRepository extends JpaRepository<Demission, Integer> {


    @Query("SELECT d FROM Demission d WHERE d.id = :id")
    Demission getDemissionById(@Param("id") int id);

    @Query("SELECT d FROM Demission d")
    List<Demission> getAllDemissions();
    
    long count();
}
