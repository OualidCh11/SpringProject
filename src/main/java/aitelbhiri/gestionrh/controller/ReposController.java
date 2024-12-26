package aitelbhiri.gestionrh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import aitelbhiri.gestionrh.model.Repos;
import aitelbhiri.gestionrh.service.ReposService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/repos")
public class ReposController {

    @Autowired
    private ReposService reposService;

    @GetMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public List<Repos> getAllRepos() {
        return reposService.getAllRepos();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public Repos getReposById(@PathVariable int id) {
        return reposService.getReposById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public Repos createRepos(@RequestBody Repos repos) {
        return reposService.createRepos(repos);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public Repos updateRepos(@PathVariable int id, @RequestBody Repos updatedRepos) {
        return reposService.updateRepos(id, updatedRepos);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public void deleteRepos(@PathVariable int id) {
        reposService.deleteRepos(id);
    }
    
    @GetMapping("/employe/{employeeId}")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public List<Repos> getReposForEmployee(@PathVariable int employeeId) {
        return reposService.getReposByEmployeeId(employeeId);
    }
    
    @GetMapping("/count")
    @PreAuthorize("hasRole('GESTIONNAIRERH') or hasRole('EMPLOYE')")
    public long countReposs() {
        return reposService.countRepos();
    }
    
}
