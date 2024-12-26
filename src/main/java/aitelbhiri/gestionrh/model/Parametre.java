package aitelbhiri.gestionrh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Parametre")
public class Parametre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=true, name="nom_entreprise", length = 60)
	private String nom_entreprise;
	
	@Column(nullable=true, name="contact_person", length = 60)
	private String contact_person;
	
	@Column(nullable=true, name="adresse", length = 60)
	private String adresse;
	
	@Column(nullable=true, name="pays", length = 60)
	private String pays;
	
	@Column(nullable=true, name="ville", length = 60)
	private String ville;
	
	@Column(nullable=true, name="region", length = 60)
	private String region;
	
	@Column(nullable=true, name="postalcode", length = 60)
	private String postalcode;
	
	@Column(nullable=true, name="email", length = 60)
	private String email;
	
	@Column(nullable=true, name="numtelephone_entreprise", length = 60)
	private String numtelephone_entreprise;
	
	@Column(nullable=true, name="fax", length = 60)
	private String fax;
	
	@Column(nullable=true, name="websiteurl", length = 60)
	private String websiteurl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_entreprise() {
		return nom_entreprise;
	}

	public void setNom_entreprise(String nom_entreprise) {
		this.nom_entreprise = nom_entreprise;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumtelephone_entreprise() {
		return numtelephone_entreprise;
	}

	public void setNumtelephone_entreprise(String numtelephone_entreprise) {
		this.numtelephone_entreprise = numtelephone_entreprise;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsiteurl() {
		return websiteurl;
	}

	public void setWebsiteurl(String websiteurl) {
		this.websiteurl = websiteurl;
	}

	public Parametre(int id, String nom_entreprise, String contact_person, String adresse, String pays, String ville,
			String region, String postalcode, String email, String numtelephone_entreprise, String fax,
			String websiteurl) {
		super();
		this.id = id;
		this.nom_entreprise = nom_entreprise;
		this.contact_person = contact_person;
		this.adresse = adresse;
		this.pays = pays;
		this.ville = ville;
		this.region = region;
		this.postalcode = postalcode;
		this.email = email;
		this.numtelephone_entreprise = numtelephone_entreprise;
		this.fax = fax;
		this.websiteurl = websiteurl;
	}
	
	public Parametre() {
		
	}
	
}
