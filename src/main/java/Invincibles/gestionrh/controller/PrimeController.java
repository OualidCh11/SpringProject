package Invincibles.gestionrh.controller;

import java.util.List;

import Invincibles.gestionrh.model.Prime;
import Invincibles.gestionrh.service.PrimeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/primes")
public class PrimeController {

    private final PrimeService primeService;

    public PrimeController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping
    public List<Prime> getAllPrimes() {
        return primeService.getAllPrimes();
    }

    @GetMapping("/{id}")
    public Prime getPrimeById(@PathVariable int id) {
        return primeService.getPrimeById(id);
    }

    @PostMapping
    public Prime addPrime(@RequestBody Prime prime) {
        return primeService.addPrime(prime);
    }

    @PutMapping("/{id}")
    public Prime updatePrime(@PathVariable int id, @RequestBody Prime prime) {
        return primeService.updatePrime(id, prime);
    }

    @DeleteMapping("/{id}")
    public void deletePrime(@PathVariable int id) {
        primeService.deletePrime(id);
    }
}

