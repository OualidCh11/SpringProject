package aitelbhiri.gestionrh.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SalaireConfig")
public class SalaireConfig {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_salaireconfig;
	
	@Column(nullable = false, name = "primeAnciennetepourcentage")
    private double primeAnciennetepourcentage;
	
	@Column(nullable = false, name = "cotisationCNSSpourcentage")
    private double cotisationCNSSpourcentage;
	
	@Column(nullable = false, name = "indemnitePerteEmploipourcentage")
    private double indemnitePerteEmploipourcentage;
	
	@Column(nullable = false, name = "cotisationAMOpourcentage")
    private double cotisationAMOpourcentage;
	
	@Column(nullable = false, name = "assuranceMaladieMutuellepourcentage")
    private double assuranceMaladieMutuellepourcentage;
	
	@Column(nullable = false, name = "cotisationCIMRpourcentage")
    private double cotisationCIMRpourcentage;
	
	public int getId_salaireconfig() {
		return id_salaireconfig;
	}

	public void setId_salaireconfig(int id_salaireconfig) {
		this.id_salaireconfig = id_salaireconfig;
	}

	public double getPrimeAnciennetepourcentage() {
		return primeAnciennetepourcentage;
	}

	public void setPrimeAnciennetepourcentage(double primeAnciennetepourcentage) {
		this.primeAnciennetepourcentage = primeAnciennetepourcentage;
	}

	public double getCotisationCNSSpourcentage() {
		return cotisationCNSSpourcentage;
	}

	public void setCotisationCNSSpourcentage(double cotisationCNSSpourcentage) {
		this.cotisationCNSSpourcentage = cotisationCNSSpourcentage;
	}

	public double getIndemnitePerteEmploipourcentage() {
		return indemnitePerteEmploipourcentage;
	}

	public void setIndemnitePerteEmploipourcentage(double indemnitePerteEmploipourcentage) {
		this.indemnitePerteEmploipourcentage = indemnitePerteEmploipourcentage;
	}

	public double getCotisationAMOpourcentage() {
		return cotisationAMOpourcentage;
	}

	public void setCotisationAMOpourcentage(double cotisationAMOpourcentage) {
		this.cotisationAMOpourcentage = cotisationAMOpourcentage;
	}

	public double getAssuranceMaladieMutuellepourcentage() {
		return assuranceMaladieMutuellepourcentage;
	}

	public void setAssuranceMaladieMutuellepourcentage(double assuranceMaladieMutuellepourcentage) {
		this.assuranceMaladieMutuellepourcentage = assuranceMaladieMutuellepourcentage;
	}

	public double getCotisationCIMRpourcentage() {
		return cotisationCIMRpourcentage;
	}

	public void setCotisationCIMRpourcentage(double cotisationCIMRpourcentage) {
		this.cotisationCIMRpourcentage = cotisationCIMRpourcentage;
	}


	public SalaireConfig(int id_salaireconfig, double primeAnciennetepourcentage, double cotisationCNSSpourcentage,
			double indemnitePerteEmploipourcentage, double cotisationAMOpourcentage,
			double assuranceMaladieMutuellepourcentage, double cotisationCIMRpourcentage) {
		super();
		this.id_salaireconfig = id_salaireconfig;
		this.primeAnciennetepourcentage = primeAnciennetepourcentage;
		this.cotisationCNSSpourcentage = cotisationCNSSpourcentage;
		this.indemnitePerteEmploipourcentage = indemnitePerteEmploipourcentage;
		this.cotisationAMOpourcentage = cotisationAMOpourcentage;
		this.assuranceMaladieMutuellepourcentage = assuranceMaladieMutuellepourcentage;
		this.cotisationCIMRpourcentage = cotisationCIMRpourcentage;
	}

	public SalaireConfig () {
		
	}



}