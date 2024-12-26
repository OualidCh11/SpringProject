package aitelbhiri.gestionrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aitelbhiri.gestionrh.model.GestionnaireRH;

import java.util.List;

public interface GestionnaireRHRepository extends JpaRepository<GestionnaireRH, Integer> {

    @Query("SELECT g FROM GestionnaireRH g WHERE g.id = :id")
    GestionnaireRH getGestionnaireRHById(@Param("id") int id);

    @Query("SELECT g FROM GestionnaireRH g")
    List<GestionnaireRH> getAllGestionnairesRH();
    
    @Query("SELECT g FROM GestionnaireRH g WHERE g.email = :email")
    GestionnaireRH findGestionnaireRHByEmail(String email);
    
    long count();
}
