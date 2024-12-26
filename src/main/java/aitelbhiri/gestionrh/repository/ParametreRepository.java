package aitelbhiri.gestionrh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aitelbhiri.gestionrh.model.Parametre;

public interface ParametreRepository extends JpaRepository<Parametre, Integer> {
	
    @Query("SELECT p FROM Parametre p WHERE p.id = :id")
    Parametre getParametreById(@Param("id") int id);

    @Query("SELECT p FROM Parametre p")
    List<Parametre> getAllParametres();

    // Ajoutez ici d'autres méthodes spécifiques si nécessaire

}
