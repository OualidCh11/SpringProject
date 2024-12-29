package Invincibles.gestionrh.service;

import java.util.List;

import Invincibles.gestionrh.model.Salaire;
import Invincibles.gestionrh.model.SalaireConfig;
import Invincibles.gestionrh.repository.SalaireRepository;
import org.springframework.stereotype.Service;

@Service
public class SalaireService {

    private SalaireRepository salaireRepository;
    private SalaireConfigService salaireConfigService;
    
    public SalaireService(SalaireRepository salaireRepository, SalaireConfigService salaireConfigService) {
        this.salaireRepository = salaireRepository;
        this.salaireConfigService = salaireConfigService;
    }
    
    
    public List<Salaire> getAllSalaires() {
        return salaireRepository.findAll();
    }

    
    public Salaire calculateSalaire(Salaire salaire) {
        // Fetch SalaireConfig from the database
        SalaireConfig salaireConfig = salaireConfigService.getSalaireConfig();

        if (salaireConfig != null) {
            // Use the percentage values from SalaireConfig
            double primeAnciennete = salaire.getSalaireBaseMensuel() * (salaireConfig.getPrimeAnciennetepourcentage() / 100);
            double cotisationCNSS = salaire.getSalaireBaseMensuel() * (salaireConfig.getCotisationCNSSpourcentage() / 100);
            double indemnitePerteEmploi = salaire.getSalaireBaseMensuel() * (salaireConfig.getIndemnitePerteEmploipourcentage() / 100);
            double cotisationAMO = salaire.getSalaireBaseMensuel() * (salaireConfig.getCotisationAMOpourcentage() / 100);
            double assuranceMaladieMutuelle = salaire.getSalaireBaseMensuel() * (salaireConfig.getAssuranceMaladieMutuellepourcentage() / 100);
            double cotisationCIMR = salaire.getSalaireBaseMensuel() * (salaireConfig.getCotisationCIMRpourcentage() / 100);

            // Calculate the total salary.
            double totalSalaire = salaire.getSalaireBaseMensuel() + primeAnciennete - cotisationCNSS
                    - indemnitePerteEmploi - cotisationAMO - assuranceMaladieMutuelle - cotisationCIMR;

            salaire.setPrimeAnciennete(primeAnciennete);
            salaire.setCotisationCNSS(cotisationCNSS);
            salaire.setIndemnitePerteEmploi(indemnitePerteEmploi);
            salaire.setCotisationAMO(cotisationAMO);
            salaire.setAssuranceMaladieMutuelle(assuranceMaladieMutuelle);
            salaire.setCotisationCIMR(cotisationCIMR);
            salaire.setTotalSalaire(totalSalaire);

            return salaire;
        } else {
            // Handle the case where SalaireConfig is not found.
            // You can throw an exception or handle it based on your application's logic.
            return null;
        }
    }

    public Salaire saveSalaire(Salaire salaire) {
        return salaireRepository.save(salaire);
    }
    
    // Méthode pour mettre à jour les informations d'un employé
    public Salaire updateSalaire(int id, Salaire updatedSalaire) {
        Salaire existingSalaire = salaireRepository.findById(id).orElse(null);
        if (existingSalaire != null) {
            // Mettez à jour les attributs de existingEmploye avec les attributs de updatedEmploye
            existingSalaire.setSalaireBaseMensuel(updatedSalaire.getSalaireBaseMensuel());
            existingSalaire.setDate_joindre(updatedSalaire.getDate_joindre());
            existingSalaire.setNombreJourOuvre(updatedSalaire.getNombreJourOuvre());

            return salaireRepository.save(existingSalaire);
        }
        return null;
    }
    
    // Méthode pour supprimer un employé par son ID
    public void deleteSalaire(int id) {
        salaireRepository.deleteById(id);
    }


}
