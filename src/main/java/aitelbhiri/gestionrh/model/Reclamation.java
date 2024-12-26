package aitelbhiri.gestionrh.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Reclamation")
public class Reclamation {

	/* Début de la déclaration des attributs*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_reclamation;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name="date_reclamation")
	private Date date_reclamation;
	
	@Column(nullable = false, name = "sujet" , length = 30)
	private String sujet;
	
	@Column(nullable = false, name = "description" , length = 600)
	private String description;
	
	@Column(nullable = false, name="status", length = 600)
	private String status;
	/* Fin de la déclaration des attributs*/
	
	/* Début Relation avec d'autres classes*/
	@ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

	/* Fin Relation avec d'autres classes*/
	
	/* Debut des getters et setters*/
	public int getId_reclamation() {
		return id_reclamation;
	}

	public void setId_reclamation(int id_reclamation) {
		this.id_reclamation = id_reclamation;
	}

	public Date getDate_reclamation() {
		return date_reclamation;
	}

	public void setDate_reclamation(Date date_reclamation) {
		this.date_reclamation = date_reclamation;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Reclamation(int id_reclamation, Date date_reclamation, String sujet, String description, String status,
			Employe employe) {
		super();
		this.id_reclamation = id_reclamation;
		this.date_reclamation = date_reclamation;
		this.sujet = sujet;
		this.description = description;
		this.status = status;
		this.employe = employe;
	}
	

    public Reclamation() {
        // Empty constructor (required by JPA)
    }
	
	
	
}
