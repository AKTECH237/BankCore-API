package AKTtech.sprint_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "comptes")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCompte;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Le type de compte est obligatoire")
    private TypeCompte typeCompte;

    private BigDecimal solde;

    @Enumerated(EnumType.STRING)
    private StatutCompte statutCompte;

    private String devise;

    private LocalDateTime dateOuverture;

    @NotNull(message = "Le client est obligatoire")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Constructeur
    public Compte() {
        this.statutCompte = StatutCompte.ACTIF;
        this.devise = "XAF";
        this.dateOuverture = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroCompte() { return numeroCompte; }
    public void setNumeroCompte(String numeroCompte) { this.numeroCompte = numeroCompte; }

    public TypeCompte getTypeCompte() { return typeCompte; }
    public void setTypeCompte(TypeCompte typeCompte) { this.typeCompte = typeCompte; }

    public BigDecimal getSolde() { return solde; }
    public void setSolde(BigDecimal solde) { this.solde = solde; }

    public StatutCompte getStatutCompte() { return statutCompte; }
    public void setStatutCompte(StatutCompte statutCompte) { this.statutCompte = statutCompte; }

    public String getDevise() { return devise; }
    public void setDevise(String devise) { this.devise = devise; }

    public LocalDateTime getDateOuverture() { return dateOuverture; }
    public void setDateOuverture(LocalDateTime dateOuverture) { this.dateOuverture = dateOuverture; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
}