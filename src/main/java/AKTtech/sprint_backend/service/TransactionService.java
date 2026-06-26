package AKTtech.sprint_backend.service;

import AKTtech.sprint_backend.model.Compte;
import AKTtech.sprint_backend.model.StatutOperation;
import AKTtech.sprint_backend.model.Transaction;
import AKTtech.sprint_backend.repository.CompteRepository;
import AKTtech.sprint_backend.repository.TransactionRepository;
import AKTtech.sprint_backend.model.CanalOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import AKTtech.sprint_backend.model.TypeOperation;

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

    public Transaction depot(String compteId, Double montant, String description) {
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));

        BigDecimal montantBD = BigDecimal.valueOf(montant);
        BigDecimal soldeAvant = compte.getSolde();

        Transaction transaction = new Transaction();
        transaction.setTypeOperation(TypeOperation.DEPOT);
        transaction.setMontant(montantBD);
        transaction.setSoldeAvant(soldeAvant);
        transaction.setSoldeApres(soldeAvant.add(montantBD));
        transaction.setDateTransaction(LocalDateTime.now());
        transaction.setDescription(description);
        transaction.setCompteSource(compte);
        transaction.setStatutOperation(StatutOperation.VALIDEE);
        transaction.setCanalOperation(CanalOperation.API);
        transaction.setReferenceOperation(genererReference());

        return transactionRepository.save(transaction);
    }


    // Retrait
    public Transaction retrait(String compteId, Double montant, String description) {
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));

        BigDecimal montantBD = BigDecimal.valueOf(montant);

        if (compte.getSolde().compareTo(montantBD) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        BigDecimal soldeAvant = compte.getSolde();

        Transaction transaction = new Transaction();
        transaction.setTypeOperation(TypeOperation.RETRAIT);
        transaction.setMontant(montantBD);
        transaction.setSoldeAvant(soldeAvant);
        transaction.setSoldeApres(soldeAvant.subtract(montantBD));
        transaction.setDateTransaction(LocalDateTime.now());
        transaction.setDescription(description);
        transaction.setCompteSource(compte);
        transaction.setStatutOperation(StatutOperation.VALIDEE);
        transaction.setCanalOperation(CanalOperation.API);
        transaction.setReferenceOperation(genererReference());

        return transactionRepository.save(transaction);
    }
    // Virement

    public Transaction virement(String compteSourceId, String compteDestinationId, Double montant, String description) {
        Compte source = compteRepository.findById(compteSourceId)
                .orElseThrow(() -> new RuntimeException("Compte source non trouvé"));
        Compte destination = compteRepository.findById(compteDestinationId)
                .orElseThrow(() -> new RuntimeException("Compte destination non trouvé"));

        BigDecimal montantBD = BigDecimal.valueOf(montant);

        if (source.getSolde().compareTo(montantBD) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        BigDecimal soldeAvant = source.getSolde();

        Transaction transaction = new Transaction();
        transaction.setTypeOperation(TypeOperation.VIREMENT);
        transaction.setMontant(montantBD);
        transaction.setSoldeAvant(soldeAvant);
        transaction.setSoldeApres(soldeAvant.subtract(montantBD));
        transaction.setDateTransaction(LocalDateTime.now());
        transaction.setDescription(description);
        transaction.setCompteSource(source);
        transaction.setCompteDestination(destination);
        transaction.setStatutOperation(StatutOperation.VALIDEE);
        transaction.setCanalOperation(CanalOperation.API);
        transaction.setReferenceOperation(genererReference());

        return transactionRepository.save(transaction);
    }

    // Historique
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    private String genererReference() {
        String date = java.time.LocalDate.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd"));
        long count = transactionRepository.count() + 1;
        return String.format("TXN-%s-%06d", date, count);
    }
}