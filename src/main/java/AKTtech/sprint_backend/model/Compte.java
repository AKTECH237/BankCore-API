package AKTtech.sprint_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "comptes")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String numeroCompte;

    private String iban;
    private String rib;
    private java.math.BigDecimal soldeComptable;
    private java.math.BigDecimal plafondRetraitJournalier;
    private java.math.BigDecimal plafondVirementJournalier;
    private BigDecimal decouvertAutorise;
    private BigDecimal tauxInteret;
    private BigDecimal fraisTenueCompte;
    private LocalDateTime dateDerniereOperation;
    private LocalDateTime dateDerniereModification;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Le type de compte est obligatoire")
    private TypeCompte typeCompte;

    private BigDecimal solde;

    @Enumerated(EnumType.STRING)
    private StatutCompte statutCompte;

    @Enumerated(EnumType.STRING)
    private Devise devise;

    private LocalDateTime dateOuverture;

    private LocalDateTime dateFermeture;
    private String motifFermeture;
    private String motifBlocage;

    @NotNull(message = "Le client est obligatoire")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Constructeur
    public Compte() {
        this.statutCompte = StatutCompte.ACTIF;
        this.devise = Devise.XAF;
        this.dateOuverture = LocalDateTime.now();
    }
    // getter et setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public BigDecimal getSoldeComptable() {
        return soldeComptable;
    }

    public void setSoldeComptable(BigDecimal soldeComptable) {
        this.soldeComptable = soldeComptable;
    }

    public BigDecimal getPlafondRetraitJournalier() {
        return plafondRetraitJournalier;
    }

    public void setPlafondRetraitJournalier(BigDecimal plafondRetraitJournalier) {
        this.plafondRetraitJournalier = plafondRetraitJournalier;
    }

    public BigDecimal getPlafondVirementJournalier() {
        return plafondVirementJournalier;
    }

    public void setPlafondVirementJournalier(BigDecimal plafondVirementJournalier) {
        this.plafondVirementJournalier = plafondVirementJournalier;
    }

    public BigDecimal getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(BigDecimal decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }

    public BigDecimal getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(BigDecimal tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public BigDecimal getFraisTenueCompte() {
        return fraisTenueCompte;
    }

    public void setFraisTenueCompte(BigDecimal fraisTenueCompte) {
        this.fraisTenueCompte = fraisTenueCompte;
    }

    public LocalDateTime getDateDerniereOperation() {
        return dateDerniereOperation;
    }

    public void setDateDerniereOperation(LocalDateTime dateDerniereOperation) {
        this.dateDerniereOperation = dateDerniereOperation;
    }

    public LocalDateTime getDateDerniereModification() {
        return dateDerniereModification;
    }

    public void setDateDerniereModification(LocalDateTime dateDerniereModification) {
        this.dateDerniereModification = dateDerniereModification;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public StatutCompte getStatutCompte() {
        return statutCompte;
    }

    public void setStatutCompte(StatutCompte statutCompte) {
        this.statutCompte = statutCompte;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public LocalDateTime getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(LocalDateTime dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public LocalDateTime getDateFermeture() {
        return dateFermeture;
    }

    public void setDateFermeture(LocalDateTime dateFermeture) {
        this.dateFermeture = dateFermeture;
    }

    public String getMotifFermeture() {
        return motifFermeture;
    }

    public void setMotifFermeture(String motifFermeture) {
        this.motifFermeture = motifFermeture;
    }

    public String getMotifBlocage() {
        return motifBlocage;
    }

    public void setMotifBlocage(String motifBlocage) {
        this.motifBlocage = motifBlocage;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}