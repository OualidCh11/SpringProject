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
@Table(name = "Conge")
public class Conge {

	/* Début de la déclaration des attributs*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true,name="datedebut_conge")
	private Date datedebut_conge;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true,name="datefin_conge")
	private Date datefin_conge;
	
	@Column(nullable=true,name="type_conge" , length = 30)
	private String type_conge;
	
	@Column(nullable=true,name="nbrjour_conge")
	private int nbrjour_conge;
	
	@Column(nullable=false,name="status_conge", length = 30)
	private String status_conge;
	
	@Column(nullable=true,name="reason_conge", length = 30)
	private String reason_conge;
	
	
	/* Fin de la déclaration des attributs*/
	
	/* Début Relation avec d'autres classes*/
	
	@ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;
	
	/* Fin Relation avec d'autres classes*/

	/* Debut des getters et setters*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatedebut_conge() {
		return datedebut_conge;
	}

	public void setDatedebut_conge(Date datedebut_conge) {
		this.datedebut_conge = datedebut_conge;
	}

	public Date getDatefin_conge() {
		return datefin_conge;
	}

	public void setDatefin_conge(Date datefin_conge) {
		this.datefin_conge = datefin_conge;
	}

	public String getType_conge() {
		return type_conge;
	}

	public void setType_conge(String type_conge) {
		this.type_conge = type_conge;
	}

	public int getNbrjour_conge() {
		return nbrjour_conge;
	}

	public void setNbrjour_conge(int nbrjour_conge) {
		this.nbrjour_conge = nbrjour_conge;
	}

	public String getStatus_conge() {
		return status_conge;
	}

	public void setStatus_conge(String status_conge) {
		this.status_conge = status_conge;
	}

	public String getReason_conge() {
		return reason_conge;
	}

	public void setReason_conge(String reason_conge) {
		this.reason_conge = reason_conge;
	}
	
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	

	public Conge(int id, Date datedebut_conge, Date datefin_conge, String type_conge, int nbrjour_conge,
			String status_conge, String reason_conge, Employe employe) {
		super();
		this.id = id;
		this.datedebut_conge = datedebut_conge;
		this.datefin_conge = datefin_conge;
		this.type_conge = type_conge;
		this.nbrjour_conge = nbrjour_conge;
		this.status_conge = status_conge;
		this.reason_conge = reason_conge;
		this.employe = employe;
	}
	

    public Conge() {
        // Empty constructor (required by JPA)
    }
    
}
