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
@Table(name = "Repos")
public class Repos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true,name="datedebut_repos")
	private Date datedebut_repos;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true,name="datefin_repos")
	private Date datefin_repos;
	
	@Column(nullable=true,name="daysRequested")
	private int daysRequested;
	
	@Column(nullable=true,name="daysConsumed")
	private int daysConsumed;
	
	@Column(nullable=true,name="remainingDays")
	private int remainingDays;

	
	@Column(nullable=false,name="status_repos", length = 30)
	private String status_repos;
	
	
	@ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatedebut_repos() {
		return datedebut_repos;
	}

	public void setDatedebut_repos(Date datedebut_repos) {
		this.datedebut_repos = datedebut_repos;
	}

	public Date getDatefin_repos() {
		return datefin_repos;
	}

	public void setDatefin_repos(Date datefin_repos) {
		this.datefin_repos = datefin_repos;
	}

	public int getDaysRequested() {
		return daysRequested;
	}

	public void setDaysRequested(int daysRequested) {
		this.daysRequested = daysRequested;
	}

	public int getDaysConsumed() {
		return daysConsumed;
	}

	public void setDaysConsumed(int daysConsumed) {
		this.daysConsumed = daysConsumed;
	}

	public String getStatus_repos() {
		return status_repos;
	}

	public void setStatus_repos(String status_repos) {
		this.status_repos = status_repos;
	}

	
	public int getRemainingDays() {
		return remainingDays;
	}

	public void setRemainingDays(int remainingDays) {
		this.remainingDays = remainingDays;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Repos(int id, Date datedebut_repos, Date datefin_repos, int daysRequested, int daysConsumed,
			String status_repos, int remainingDays, Employe employe) {
		super();
		this.id = id;
		this.datedebut_repos = datedebut_repos;
		this.datefin_repos = datefin_repos;
		this.daysRequested = daysRequested;
		this.daysConsumed = daysConsumed;
		this.status_repos = status_repos;
		this.remainingDays = remainingDays;
		this.employe = employe;
	}

	public Repos() {
		
	}
}
