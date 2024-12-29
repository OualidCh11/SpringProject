package Invincibles.gestionrh.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Prime")
public class Prime {

	/* Début de la déclaration des attributs*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, name = "montant_prime")
	private double montant_prime;
	
	@Column(nullable = false, name = "motif")
	private String motif;
	
	/* Fin de la déclaration des attributs*/

	/* Début Relation avec d'autres classes*/
	
	@OneToOne
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

	public double getMontant_prime() {
		return montant_prime;
	}

	public void setMontant_prime(double montant_prime) {
		this.montant_prime = montant_prime;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	/* Fin des getters et setters*/

	public Prime(int id, double montant_prime, String motif, Employe employe) {
		super();
		this.id = id;
		this.montant_prime = montant_prime;
		this.motif = motif;
		this.employe = employe;
	}
	

    public Prime() {
    	
    }

	
	
}
