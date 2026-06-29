package AKTtech.sprint_backend.controller;

import AKTtech.sprint_backend.model.Compte;
import AKTtech.sprint_backend.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;

    // GET tous les comptes
    @GetMapping
    public List<Compte> getAllCompte(){

         return compteService.getAllComptes();
    }

    // GET un compte par ID
    @GetMapping("/{id}")
    public Optional<Object> getCompteById(@PathVariable String id){

        return Optional.ofNullable(compteService.getCompteById(id));
    }

    //POST creer un compte
    @PostMapping
    public Compte createCompte(@RequestBody Compte compte){
        return compteService.createCompte(compte);
    }

    //PUT modifier un compte
    @PutMapping("/{id}")
    public Compte updateCompte(@PathVariable String id, @RequestBody Compte compte){
        return compteService.updateCompte(id, compte);
    }

    //DELETE suprimer un compte
    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable String id){
       compteService.deleteCompte(id);
    }
}

