package Invincibles.gestionrh.repository;

import Invincibles.gestionrh.model.Prime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrimeRepository extends JpaRepository<Prime, Integer> {

    @Query("SELECT p FROM Prime p WHERE p.id = :id")
    Prime getPrimeById(@Param("id") int id);

    @Query("SELECT p FROM Prime p")
    List<Prime> getAllPrimes();

    // Ajoutez ici d'autres méthodes spécifiques si nécessaire

}
