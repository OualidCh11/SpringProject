package aitelbhiri.gestionrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aitelbhiri.gestionrh.model.SalaireConfig;

import java.util.List;

public interface SalaireConfigRepository extends JpaRepository<SalaireConfig, Integer> {

    @Query("SELECT s FROM SalaireConfig s WHERE s.id = :id")
    SalaireConfig getSalaireConfigById(@Param("id") int id);

    @Query("SELECT s FROM SalaireConfig s")
    List<SalaireConfig> getAllSalairesConfig();

    @Query("SELECT sc FROM SalaireConfig sc ORDER BY sc.id_salaireconfig ASC")
    SalaireConfig findFirst();

    // Ajoutez ici d'autres méthodes spécifiques si nécessaire

}
