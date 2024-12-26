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
@Table(name = "Absence")
public class Absence {
	
	/* Début de la déclaration des attributs*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name="date_absence")
	private Date date_absence;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "typeabsence" , length = 30)
	private String typeabsence;
	
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

	public Date getDate_absence() {
		return date_absence;
	}

	public void setDate_absence(Date date_absence) {
		this.date_absence = date_absence;
	}

	public String getTypeabsence() {
		return typeabsence;
	}

	public void setTypeabsence(String typeabsence) {
		this.typeabsence = typeabsence;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	/* Fin des getters et setters*/

	public Absence(int id, Date date_absence, String typeabsence, Employe employe) {
		super();
		this.id = id;
		this.date_absence = date_absence;
		this.typeabsence = typeabsence;
		this.employe = employe;
	}
	

    public Absence() {
        // Empty constructor (required by JPA)
    }

	

}
