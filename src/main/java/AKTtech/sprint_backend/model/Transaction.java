package AKTtech.sprint_backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String referenceOperation;

    @Enumerated(EnumType.STRING)
    private TypeOperation typeOperation;

    private java.math.BigDecimal fraisOperation;
    private String motif;
    private BigDecimal montant;
    private BigDecimal soldeAvant;
    private BigDecimal soldeApres;
    private LocalDateTime dateTransaction;
    private String description;
    private String endToEndId;
    private LocalDateTime dateExecution;
    private LocalDateTime dateValidation;

    @Enumerated(EnumType.STRING)
    private StatutOperation statutOperation;

    @Enumerated(EnumType.STRING)
    private CanalOperation canalOperation;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferenceOperation() {
        return referenceOperation;
    }

    public void setReferenceOperation(String referenceOperation) {
        this.referenceOperation = referenceOperation;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public BigDecimal getFraisOperation() {
        return fraisOperation;
    }

    public void setFraisOperation(BigDecimal fraisOperation) {
        this.fraisOperation = fraisOperation;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public BigDecimal getSoldeAvant() {
        return soldeAvant;
    }

    public void setSoldeAvant(BigDecimal soldeAvant) {
        this.soldeAvant = soldeAvant;
    }

    public BigDecimal getSoldeApres() {
        return soldeApres;
    }

    public void setSoldeApres(BigDecimal soldeApres) {
        this.soldeApres = soldeApres;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndToEndId() {
        return endToEndId;
    }

    public void setEndToEndId(String endToEndId) {
        this.endToEndId = endToEndId;
    }

    public LocalDateTime getDateExecution() {
        return dateExecution;
    }

    public void setDateExecution(LocalDateTime dateExecution) {
        this.dateExecution = dateExecution;
    }

    public LocalDateTime getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(LocalDateTime dateValidation) {
        this.dateValidation = dateValidation;
    }

    public StatutOperation getStatutOperation() {
        return statutOperation;
    }

    public void setStatutOperation(StatutOperation statutOperation) {
        this.statutOperation = statutOperation;
    }

    public CanalOperation getCanalOperation() {
        return canalOperation;
    }

    public void setCanalOperation(CanalOperation canalOperation) {
        this.canalOperation = canalOperation;
    }

    public Compte getCompteSource() {
        return compteSource;
    }

    public void setCompteSource(Compte compteSource) {
        this.compteSource = compteSource;
    }

    public Compte getCompteDestination() {
        return compteDestination;
    }

    public void setCompteDestination(Compte compteDestination) {
        this.compteDestination = compteDestination;
    }
}