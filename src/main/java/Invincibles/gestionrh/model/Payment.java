package Invincibles.gestionrh.model;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Payment")
public class Payment {

	/* Début de la déclaration des attributs*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_payment;
	
	@Column(nullable = false, name = "mois", length = 30)
	private String mois;
	
	@Column(nullable = false, name = "montant_payment")
	private double montant_payment;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name="date_payment")
	private Date date_payment;
	
	@Column(nullable = false, name="status")
	private boolean status;
	
	/* Fin de la déclaration des attributs*/
	
	/* Début Relation avec d'autres classes*/
	
	@OneToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;
	
	/* Fin Relation avec d'autres classes*/

	/* Debut des getters et setters*/

	public int getId_payment() {
		return id_payment;
	}

	public void setId_payment(int id_payment) {
		this.id_payment = id_payment;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public double getMontant_payment() {
		return montant_payment;
	}

	public void setMontant_payment(double montant_payment) {
		this.montant_payment = montant_payment;
	}

	public Date getDate_payment() {
		return date_payment;
	}

	public void setDate_payment(Date date_payment) {
		this.date_payment = date_payment;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	/* Fin des getters et setters*/

	public Payment(int id_payment, String mois, double montant_payment, Date date_payment, boolean status,
			Employe employe) {
		super();
		this.id_payment = id_payment;
		this.mois = mois;
		this.montant_payment = montant_payment;
		this.date_payment = date_payment;
		this.status = status;
		this.employe = employe;
	}
	

    public Payment() {
        // Empty constructor (required by JPA)
    }


		
}
