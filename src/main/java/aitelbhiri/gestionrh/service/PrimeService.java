package aitelbhiri.gestionrh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import aitelbhiri.gestionrh.model.Prime;
import aitelbhiri.gestionrh.repository.PrimeRepository;

@Service
public class PrimeService {

    private final PrimeRepository primeRepository;

    public PrimeService(PrimeRepository primeRepository) {
        this.primeRepository = primeRepository;
    }

    public List<Prime> getAllPrimes() {
        return primeRepository.findAll();
    }

    public Prime getPrimeById(int id) {
        return primeRepository.findById(id).orElse(null);
    }

    public Prime addPrime(Prime prime) {
        return primeRepository.save(prime);
    }

    public Prime updatePrime(int id, Prime updatedPrime) {
        Prime existingPrime = getPrimeById(id);

        // Mise à jour des attributs de la prime existante avec les attributs de la prime mise à jour
        existingPrime.setMontant_prime(updatedPrime.getMontant_prime());
        existingPrime.setMotif(updatedPrime.getMotif());
        // Vous pouvez mettre à jour d'autres attributs selon vos besoins

        return primeRepository.save(existingPrime);
    }

    public void deletePrime(int id) {
        Prime existingPrime = getPrimeById(id);
        primeRepository.delete(existingPrime);
    }
}
