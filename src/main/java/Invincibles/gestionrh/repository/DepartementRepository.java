package Invincibles.gestionrh.repository;

import Invincibles.gestionrh.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    // Requête personnalisée pour récupérer un département par son nom
    @Query("SELECT d FROM Departement d WHERE d.nom_departement = :nom")
    Departement findDepartementByNom(@Param("nom") String nom);

    @Query("Select d from Departement d where d.id_departement=:id")
	Departement getDepartement(@Param("id") int id);

	@Query("Select d from Departement d ")
	List<Departement> getAllDepartements();
	
    long count();
	
    // Vous pouvez ajouter d'autres requêtes personnalisées ici si nécessaire
}
