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
@Table(name = "Salaire")
public class Salaire {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_salaire;
    
	@Column(nullable = false, name = "nombreJourOuvre")
    private double nombreJourOuvre;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name="date_joindre")
	private Date date_joindre;
	
	@Column(nullable = false, name = "salaireBaseMensuel")
    private double salaireBaseMensuel;
	
	@Column(nullable = false, name = "primeAnciennete")
    private double primeAnciennete;
	
	@Column(nullable = false, name = "cotisationCNSS")
    private double cotisationCNSS;
	
	@Column(nullable = false, name = "indemnitePerteEmploi")
    private double indemnitePerteEmploi;
	
	@Column(nullable = false, name = "cotisationAMO")
    private double cotisationAMO;
	
	@Column(nullable = false, name = "assuranceMaladieMutuelle")
    private double assuranceMaladieMutuelle;
	
	@Column(nullable = false, name = "cotisationCIMR")
    private double cotisationCIMR;
	
	@Column(nullable = false, name = "totalSalaire")
    private double totalSalaire;

	
	@ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

    // Constructors, getters, setters, and other methods.

	public int getId_salaire() {
		return id_salaire;
	}

	public void setId_salaire(int id_salaire) {
		this.id_salaire = id_salaire;
	}
	
	public double getNombreJourOuvre() {
		return nombreJourOuvre;
	}

	public void setNombreJourOuvre(double nombreJourOuvre) {
		this.nombreJourOuvre = nombreJourOuvre;
	}

	public Date getDate_joindre() {
		return date_joindre;
	}

	public void setDate_joindre(Date date_joindre) {
		this.date_joindre = date_joindre;
	}

	public double getSalaireBaseMensuel() {
		return salaireBaseMensuel;
	}

	public void setSalaireBaseMensuel(double salaireBaseMensuel) {
		this.salaireBaseMensuel = salaireBaseMensuel;
	}

	public double getPrimeAnciennete() {
		return primeAnciennete;
	}

	public void setPrimeAnciennete(double primeAnciennete) {
		this.primeAnciennete = primeAnciennete;
	}

	public double getCotisationCNSS() {
		return cotisationCNSS;
	}

	public void setCotisationCNSS(double cotisationCNSS) {
		this.cotisationCNSS = cotisationCNSS;
	}

	public double getIndemnitePerteEmploi() {
		return indemnitePerteEmploi;
	}

	public void setIndemnitePerteEmploi(double indemnitePerteEmploi) {
		this.indemnitePerteEmploi = indemnitePerteEmploi;
	}

	public double getCotisationAMO() {
		return cotisationAMO;
	}

	public void setCotisationAMO(double cotisationAMO) {
		this.cotisationAMO = cotisationAMO;
	}

	public double getAssuranceMaladieMutuelle() {
		return assuranceMaladieMutuelle;
	}

	public void setAssuranceMaladieMutuelle(double assuranceMaladieMutuelle) {
		this.assuranceMaladieMutuelle = assuranceMaladieMutuelle;
	}

	public double getCotisationCIMR() {
		return cotisationCIMR;
	}

	public void setCotisationCIMR(double cotisationCIMR) {
		this.cotisationCIMR = cotisationCIMR;
	}

    public double getTotalSalaire() {
        return totalSalaire;
    }

    public void setTotalSalaire(double totalSalaire) {
        this.totalSalaire = totalSalaire;
    }
    
    
    
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Salaire(int id_salaire, double nombreJourOuvre, Date date_joindre, double salaireBaseMensuel, double primeAnciennete,
			double cotisationCNSS, double indemnitePerteEmploi, double cotisationAMO, double assuranceMaladieMutuelle,
			double cotisationCIMR,double totalSalaire, Employe employe) {
		super();
		this.id_salaire = id_salaire;
		this.nombreJourOuvre = nombreJourOuvre;
		this.date_joindre = date_joindre;
		this.salaireBaseMensuel = salaireBaseMensuel;
		this.primeAnciennete = primeAnciennete;
		this.cotisationCNSS = cotisationCNSS;
		this.indemnitePerteEmploi = indemnitePerteEmploi;
		this.cotisationAMO = cotisationAMO;
		this.assuranceMaladieMutuelle = assuranceMaladieMutuelle;
		this.cotisationCIMR = cotisationCIMR;
		this.totalSalaire = totalSalaire;
		this.employe = employe;
	}

	public Salaire () {
		
	}



}