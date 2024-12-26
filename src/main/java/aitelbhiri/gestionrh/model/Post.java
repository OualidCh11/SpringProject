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
@Table(name = "Post")
public class Post {
	
	/* Début de la déclaration des attributs*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_post;
	
	@Column(nullable = false, name = "nom_post", length = 30)
	private String nom_post;
	
	@Column(name = "description_post", length = 200)
	private String description_post;
	
	/* Fin de la déclaration des attributs*/
	
	/* Début Relation avec d'autres classes*/
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Employe> employes;
	
	/* Fin Relation avec d'autres classes*/
	
	/* Debut des getters et setters*/
	public int getId_post() {
		return id_post;
	}

	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

	public String getNom_post() {
		return nom_post;
	}

	public void setNom_post(String nom_post) {
		this.nom_post = nom_post;
	}

	public String getDescription_post() {
		return description_post;
	}

	public void setDescription_post(String description_post) {
		this.description_post = description_post;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	/* Fin des getters et setters*/

	public Post(int id_post, String nom_post, String description_post, List<Employe> employes) {
		super();
		this.id_post = id_post;
		this.nom_post = nom_post;
		this.description_post = description_post;
		this.employes = employes;
	}
	

    public Post() {
        // Empty constructor (required by JPA)
    }
	
	



}
