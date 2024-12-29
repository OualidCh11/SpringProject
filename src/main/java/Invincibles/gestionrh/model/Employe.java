package Invincibles.gestionrh.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Employe")
public class Employe {
	
	/* Début de la déclaration des attributs*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, name = "username", length = 30)
	private String username;
	
	@Column(unique = true, nullable = true, name = "matricule", length = 30)
	private String matricule;
	
	@Column(nullable = true, name = "nom", length = 30)
	private String nom;
	
	@Column(nullable = true, name = "prenom", length = 30)
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true, name="datenaissance")
	private Date datenaissance;
	
	@Column(nullable = true, name = "ville", length = 30)
	private String ville;
	
	@Column(unique = true, nullable = true, name = "cin", length = 30)
	private String cin;
	
	@Column(unique = true, nullable = false, name = "email", length = 60)
	private String email;
	
	@Column(nullable = false, name = "password", length = 100)
	private String password;
	
	@Column(unique = false, nullable = true, name = "age")
	private int age;
	
	@Column(unique = true, nullable = true, name = "numerotelephone", length = 80)
	private String numerotelephone;
	
	@Column(nullable = true, name = "sexe", length = 60)
	private String sexe;
	
	@Column(unique = false, nullable = true, name = "totalAllocatedDays")
    private int totalAllocatedDays; // Total allocated leave days for this employee


	
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(  name = "user_roles", 
	        joinColumns = @JoinColumn(name = "id_employe"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Role> roles = new HashSet<>();
	
	/* Fin de la declaration des attributs*/
	
	/* Début Relation avec d'autres classes*/

	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Reclamation> reclamations;
	
	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Conge> conges;
	
	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Absence> absences;
	
	@OneToOne(mappedBy = "employe", cascade = CascadeType.ALL)
    private Prime prime;
	
	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Payment> payments;
	
	@ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
	
	@ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;
	

	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Salaire> salaires;
	
	
	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Repos> repos;
	
	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Demission> demissions;
	
	/* Fin Relation avec d'autres classes*/
	

	/* Debut des getters et setters*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}


	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNumerotelephone() {
		return numerotelephone;
	}

	public void setNumerotelephone(String numerotelephone) {
		this.numerotelephone = numerotelephone;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public int getTotalAllocatedDays() {
		return totalAllocatedDays;
	}

	public void setTotalAllocatedDays(int totalAllocatedDays) {
		this.totalAllocatedDays = totalAllocatedDays;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public List<Conge> getConges() {
		return conges;
	}

	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}

	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	public Prime getPrime() {
		return prime;
	}

	public void setPrime(Prime prime) {
		this.prime = prime;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	/* Fin des getters et setters*/
	
	/* Debut du constructeur*/

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public List<Salaire> getSalaires() {
		return salaires;
	}

	public void setSalaires(List<Salaire> salaires) {
		this.salaires = salaires;
	}


	public List<Repos> getRepos() {
		return repos;
	}

	public void setRepos(List<Repos> repos) {
		this.repos = repos;
	}

	public List<Demission> getDemissions() {
		return demissions;
	}

	public void setDemissions(List<Demission> demissions) {
		this.demissions = demissions;
	}

	public Employe(String username, String email, String password) {
	    this.username = username;
	    this.email = email;
	    this.password = password;
	}
	
	public Employe(int id, String username, String matricule,  String nom, String prenom, Date datenaissance,
            String ville, String cin, String email, String password, int age,
            String numerotelephone, String sexe, int totalAllocatedDays, Departement departement, Post post) {
		 this.id = id;
		 this.username = username;
		 this.matricule = matricule;
		 this.nom = nom;
		 this.prenom = prenom;
		 this.datenaissance = datenaissance;
		 this.ville = ville;
		 this.cin = cin;
		 this.email = email;
		 this.password = password;
		 this.age = age;
		 this.numerotelephone = numerotelephone;
		 this.sexe = sexe;
		 this.totalAllocatedDays = totalAllocatedDays;
		 this.departement = departement;
		 this.post = post;
	}

	
	 public Employe() {
	        // Empty constructor (required by JPA)
	    }
	/* Fin du constructeur*/
	 
}
