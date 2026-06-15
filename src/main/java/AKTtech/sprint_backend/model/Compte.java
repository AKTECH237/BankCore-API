package AKTtech.sprint_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

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

    private Double solde;

    @NotNull(message = "Le client est obligatoire")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Constructeurs
    public Compte() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroCompte() { return numeroCompte; }
    public void setNumeroCompte(String numeroCompte) { this.numeroCompte = numeroCompte; }

    public TypeCompte getTypeCompte() { return typeCompte; }
    public void setTypeCompte(TypeCompte typeCompte) { this.typeCompte = typeCompte; }

    public Double getSolde() { return solde; }
    public void setSolde(Double solde) { this.solde = solde; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
}