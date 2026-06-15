package AKTtech.sprint_backend.service;

import AKTtech.sprint_backend.model.Compte;
import AKTtech.sprint_backend.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public Optional<Compte> getCompteById(Long id) {
        return compteRepository.findById(id);
    }

    public Compte createCompte(Compte compte) {
        // Algorithme de numérotation automatique
        String annee = String.valueOf(java.time.LocalDate.now().getYear());
        long nombreComptes = compteRepository.count();
        String numero = String.format("CMR-%s-%06d", annee, nombreComptes + 1);
        compte.setNumeroCompte(numero);
        return compteRepository.save(compte);
    }

    public Compte updateCompte(Long id, Compte compteModifie){
        Compte compte = (Compte) compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));
        compte.setNumeroCompte(compteModifie.getNumeroCompte());
        compte.setTypeCompte(compteModifie.getTypeCompte());
        compte.setSolde(compteModifie.getSolde());
        compte.setClient(compteModifie.getClient());
        return compteRepository.save(compte);
    }

    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }
}
