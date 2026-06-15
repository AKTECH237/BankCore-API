package AKTtech.sprint_backend.service;

import AKTtech.sprint_backend.model.Compte;
import AKTtech.sprint_backend.model.StatutOperation;
import AKTtech.sprint_backend.model.Transaction;
import AKTtech.sprint_backend.repository.CompteRepository;
import AKTtech.sprint_backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CompteRepository compteRepository;

    // Dépôt
    public Transaction depot(Long compteId, Double montant, String description) {
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));

        BigDecimal montantBD = BigDecimal.valueOf(montant);
        compte.setSolde(compte.getSolde().add(montantBD));
        compteRepository.save(compte);

        Transaction transaction = new Transaction();
        transaction.setType("DEPOT");
        transaction.setMontant(montantBD);
        transaction.setDateTransaction(LocalDateTime.now());
        transaction.setDescription(description);
        transaction.setCompteSource(compte);
        transaction.setStatutOperation(StatutOperation.VALIDEE);

        return transactionRepository.save(transaction);
    }

    // Retrait
    public Transaction retrait(Long compteId, Double montant, String description) {
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));

        BigDecimal montantBD = BigDecimal.valueOf(montant);

        if (compte.getSolde().compareTo(montantBD) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        compte.setSolde(compte.getSolde().subtract(montantBD));
        compteRepository.save(compte);

        Transaction transaction = new Transaction();
        transaction.setType("RETRAIT");
        transaction.setMontant(montantBD);
        transaction.setDateTransaction(LocalDateTime.now());
        transaction.setDescription(description);
        transaction.setCompteSource(compte);
        transaction.setStatutOperation(StatutOperation.VALIDEE);

        return transactionRepository.save(transaction);
    }

    // Virement
    public Transaction virement(Long compteSourceId, Long compteDestinationId, Double montant, String description) {
        Compte source = compteRepository.findById(compteSourceId)
                .orElseThrow(() -> new RuntimeException("Compte source non trouvé"));
        Compte destination = compteRepository.findById(compteDestinationId)
                .orElseThrow(() -> new RuntimeException("Compte destination non trouvé"));

        BigDecimal montantBD = BigDecimal.valueOf(montant);

        if (source.getSolde().compareTo(montantBD) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        source.setSolde(source.getSolde().subtract(montantBD));
        destination.setSolde(destination.getSolde().add(montantBD));
        compteRepository.save(source);
        compteRepository.save(destination);

        Transaction transaction = new Transaction();
        transaction.setType("VIREMENT");
        transaction.setMontant(montantBD);
        transaction.setDateTransaction(LocalDateTime.now());
        transaction.setDescription(description);
        transaction.setCompteSource(source);
        transaction.setCompteDestination(destination);
        transaction.setStatutOperation(StatutOperation.VALIDEE);

        return transactionRepository.save(transaction);
    }

    // Historique
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}