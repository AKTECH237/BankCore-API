package AKTtech.sprint_backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private BigDecimal montant;
    private LocalDateTime dateTransaction;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatutOperation statutOperation;

    @ManyToOne
    @JoinColumn(name = "compte_source_id")
    private Compte compteSource;

    @ManyToOne
    @JoinColumn(name = "compte_destination_id")
    private Compte compteDestination;

    // Constructeur
    public Transaction() {
        this.statutOperation = StatutOperation.EN_ATTENTE;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }

    public LocalDateTime getDateTransaction() { return dateTransaction; }
    public void setDateTransaction(LocalDateTime dateTransaction) { this.dateTransaction = dateTransaction; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public StatutOperation getStatutOperation() { return statutOperation; }
    public void setStatutOperation(StatutOperation statutOperation) { this.statutOperation = statutOperation; }
    @Enumerated(EnumType.STRING)
    private CanalOperation canalOperation;
    public Compte getCompteSource() { return compteSource; }
    public void setCompteSource(Compte compteSource) { this.compteSource = compteSource; }

    public Compte getCompteDestination() { return compteDestination; }
    public void setCompteDestination(Compte compteDestination) { this.compteDestination = compteDestination; }

    public CanalOperation getCanalOperation() { return canalOperation; }
    public void setCanalOperation(CanalOperation canalOperation) { this.canalOperation = canalOperation; }
}
