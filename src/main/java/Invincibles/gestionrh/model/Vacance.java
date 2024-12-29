package Invincibles.gestionrh.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Vacance")
public class Vacance {

	/* Début de la déclaration des attributs*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_vacance;
	
	@Column(nullable = false, name = "nom_vacance", length = 30)
	private String nom_vacance;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name="datedebut_vacance")
	private Date datedebut_vacance;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name="datefin_vacance")
	private Date datefin_vacance;
	
	@Column(nullable = false, name = "nbrjour_vacance")
	private int nbrjour_vacance;
	
	
	/* Fin de la déclaration des attributs*/
	
	/* Début Relation avec d'autres classes*/
	

	/* Fin Relation avec d'autres classes*/

	/* Debut des getters et setters*/

	public int getId_vacance() {
		return id_vacance;
	}

	public void setId_vacance(int id_vacance) {
		this.id_vacance = id_vacance;
	}

	public String getNom_vacance() {
		return nom_vacance;
	}

	public void setNom_vacance(String nom_vacance) {
		this.nom_vacance = nom_vacance;
	}

	public Date getDatedebut_vacance() {
		return datedebut_vacance;
	}

	public void setDatedebut_vacance(Date datedebut_vacance) {
		this.datedebut_vacance = datedebut_vacance;
	}

	public Date getDatefin_vacance() {
		return datefin_vacance;
	}

	public void setDatefin_vacance(Date datefin_vacance) {
		this.datefin_vacance = datefin_vacance;
	}

	public int getNbrjour_vacance() {
		return nbrjour_vacance;
	}

	public void setNbrjour_vacance(int nbrjour_vacance) {
		this.nbrjour_vacance = nbrjour_vacance;
	}



	
	/* Fin des getters et setters*/

	public Vacance(int id_vacance, String nom_vacance, Date datedebut_vacance, Date datefin_vacance,
			int nbrjour_vacance, Employe employe) {
		super();
		this.id_vacance = id_vacance;
		this.nom_vacance = nom_vacance;
		this.datedebut_vacance = datedebut_vacance;
		this.datefin_vacance = datefin_vacance;
		this.nbrjour_vacance = nbrjour_vacance;
		
	}
	

    public Vacance() {
        // Empty constructor (required by JPA)
    }

	

	
	
}
