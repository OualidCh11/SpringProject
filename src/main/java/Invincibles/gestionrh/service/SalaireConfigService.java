package Invincibles.gestionrh.service;

import java.util.List;

import Invincibles.gestionrh.model.SalaireConfig;
import Invincibles.gestionrh.repository.SalaireConfigRepository;
import org.springframework.stereotype.Service;

@Service
public class SalaireConfigService {

    private final SalaireConfigRepository salaireconfigRepository;

    public SalaireConfigService(SalaireConfigRepository salaireconfigRepository) {
        this.salaireconfigRepository = salaireconfigRepository;
    }

    public List<SalaireConfig> getAllSalairesConfig() {
        return salaireconfigRepository.findAll();
    }

    public SalaireConfig getSalaireConfigById(int id) {
        return salaireconfigRepository.findById(id).orElse(null);
    }

    public SalaireConfig addSalaireConfig(SalaireConfig salaireconfig) {
        return salaireconfigRepository.save(salaireconfig);
    }

    public SalaireConfig updateSalaireConfig(int id, SalaireConfig updatedSalaireConfig) {
        SalaireConfig existingSalaireConfig = getSalaireConfigById(id);

        // Update the attributes of the existing SalaireConfig with the attributes of the updated SalaireConfig
        if (existingSalaireConfig != null) {
            existingSalaireConfig.setPrimeAnciennetepourcentage(updatedSalaireConfig.getPrimeAnciennetepourcentage());
            existingSalaireConfig.setCotisationCNSSpourcentage(updatedSalaireConfig.getCotisationCNSSpourcentage());
            existingSalaireConfig.setIndemnitePerteEmploipourcentage(updatedSalaireConfig.getIndemnitePerteEmploipourcentage());
            existingSalaireConfig.setCotisationAMOpourcentage(updatedSalaireConfig.getCotisationAMOpourcentage());
            existingSalaireConfig.setAssuranceMaladieMutuellepourcentage(updatedSalaireConfig.getAssuranceMaladieMutuellepourcentage());
            existingSalaireConfig.setCotisationCIMRpourcentage(updatedSalaireConfig.getCotisationCIMRpourcentage());

            // You can update other attributes here as well

            return salaireconfigRepository.save(existingSalaireConfig);
        }
        return null;
    }

    public void deleteSalaireConfig(int id) {
        SalaireConfig existingSalaireConfig = getSalaireConfigById(id);
        if (existingSalaireConfig != null) {
            salaireconfigRepository.delete(existingSalaireConfig);
        }
    }
    
    public SalaireConfig getSalaireConfig() {
        SalaireConfig salaireConfig = salaireconfigRepository.findFirst(); // Assuming findFirst() method exists
        
        return salaireConfig;
    }
}
