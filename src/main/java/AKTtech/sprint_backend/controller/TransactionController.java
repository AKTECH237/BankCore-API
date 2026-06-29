package AKTtech.sprint_backend.controller;

import AKTtech.sprint_backend.model.Transaction;
import AKTtech.sprint_backend.repository.TransactionRepository;
import AKTtech.sprint_backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    // GET historique
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // POST dépôt
    @PostMapping("/depot")
    public Transaction depot(@RequestBody Map<String, Object> body) {
        String compteId = body.get("compteId").toString();
        Double montant = Double.valueOf(body.get("montant").toString());
        String description = body.get("description").toString();
        return transactionService.depot(compteId, montant, description);
    }

    // POST retrait
    @PostMapping("/retrait")
    public Transaction retrait(@RequestBody Map<String, Object> body) {
        String compteId = body.get("compteId").toString();
        Double montant = Double.valueOf(body.get("montant").toString());
        String description = body.get("description").toString();
        return transactionService.retrait(compteId, montant, description);
    }

    // POST virement
    @PostMapping("/virement")
    public Transaction virement(@RequestBody Map<String, Object> body) {
        String compteSourceId = body.get("compteSourceId").toString();
        String compteDestinationId = body.get("compteDestinationId").toString();
        Double montant = Double.valueOf(body.get("montant").toString());
        String description = body.get("description").toString();
        return transactionService.virement(compteSourceId, compteDestinationId, montant, description);
    }

    // DELETE transaction
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable String id) {
        transactionRepository.deleteById(id);
    }
}