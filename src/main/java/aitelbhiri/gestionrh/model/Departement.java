package aitelbhiri.gestionrh.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Departement")
public class Departement {

	/* Début de la déclaration des attributs*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_departement;
	
	@Column(nullable = false, name = "nom_departement", length = 30)
	private String nom_departement;
	
	@Column(name = "description", length = 200)
	private String description;
	
	/* Fin de la déclaration des attributs*/
	
	/* Début Relation avec d'autres classes*/
	
	@OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Employe> employes;
	
	/* Fin Relation avec d'autres classes*/

	/* Debut des getters et setters*/
	public int getId_departement() {
		return id_departement;
	}

	public void setId_departement(int id_departement) {
		this.id_departement = id_departement;
	}

	public String getNom_departement() {
		return nom_departement;
	}

	public void setNom_departement(String nom_departement) {
		this.nom_departement = nom_departement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	/* Fin des getters et setters*/

	public Departement(int id_departement, String nom_departement, String description, List<Employe> employes) {
		super();
		this.id_departement = id_departement;
		this.nom_departement = nom_departement;
		this.description = description;
		this.employes = employes;
	}
	

    public Departement() {
        // Empty constructor (required by JPA)
    }
	
	

 
}
