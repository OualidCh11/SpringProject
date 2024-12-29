package Invincibles.gestionrh.model;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="GestionnaireRH")
public class GestionnaireRH extends Employe {

	public GestionnaireRH(int id, String username, String matricule, String nom, String prenom, Date datenaissance,
		    String ville, String cin, String email, String password, int age,
			String numerotelephone, String sexe,int totalAllocatedDays, Departement departement, Post post) {
		super(id, username, matricule, nom, prenom, datenaissance, ville, cin, email, password, age,
				numerotelephone, sexe, totalAllocatedDays, departement, post);
		// TODO Auto-generated constructor stub
	}
	

    public GestionnaireRH() {
        // Empty constructor (required by JPA)
    }
	
	

}
