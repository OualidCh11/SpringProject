package Invincibles.gestionrh.model;

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
@Table(name = "Demission")
public class Demission {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_demission;
    
	@Column(nullable = false, name = "raison", length = 30)
	private String raison;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name="date_avis_demission")
	private Date date_avis_demission;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name="date_démission")
	private Date date_démission;
	
	
	@ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

	public int getId_demission() {
		return id_demission;
	}

	public void setId_demission(int id_demission) {
		this.id_demission = id_demission;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public Date getDate_avis_demission() {
		return date_avis_demission;
	}

	public void setDate_avis_demission(Date date_avis_demission) {
		this.date_avis_demission = date_avis_demission;
	}

	public Date getDate_démission() {
		return date_démission;
	}

	public void setDate_démission(Date date_démission) {
		this.date_démission = date_démission;
	}


	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Demission(int id_demission, String raison, Date date_avis_demission, Date date_démission, Employe employe) {
		super();
		this.id_demission = id_demission;
		this.raison = raison;
		this.date_avis_demission = date_avis_demission;
		this.date_démission = date_démission;
		this.employe = employe;
	}

	public Demission() {
		
	}
}
