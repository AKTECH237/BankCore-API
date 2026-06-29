package AKTtech.sprint_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String codeClient;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email est invalide")
    private String email;

    @NotBlank(message = "Le téléphone est obligatoire")
    private String telephone;

    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String sexe;
    private String adresse;
    private String ville;
    private String nationalite;
    private String paysResidenceCode;
    private String typePieceIdentite;
    private String numeroPieceIdentite;
    private LocalDate dateExpirationPiece;
    private String profession;
    private String employeur;
    private BigDecimal revenuMensuelEstime;

    private String niveauRisqueClient;
    private String statutKYC;

    private LocalDateTime dateValidationKYC;

    @Enumerated(EnumType.STRING)
    private StatutClient statutClient;

    private LocalDateTime dateCreation;
    private LocalDateTime dateDerniereModification;

    // Constructeur
    public Client() {
        this.statutClient = StatutClient.ACTIF;
        this.dateCreation = LocalDateTime.now();
        this.statutKYC = "EN_ATTENTE";
        this.niveauRisqueClient = "FAIBLE";
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCodeClient() { return codeClient; }
    public void setCodeClient(String codeClient) { this.codeClient = codeClient; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }

    public String getLieuNaissance() { return lieuNaissance; }
    public void setLieuNaissance(String lieuNaissance) { this.lieuNaissance = lieuNaissance; }

    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public String getNationalite() { return nationalite; }
    public void setNationalite(String nationalite) { this.nationalite = nationalite; }

    public String getPaysResidenceCode() { return paysResidenceCode; }
    public void setPaysResidenceCode(String paysResidenceCode) { this.paysResidenceCode = paysResidenceCode; }

    public String getTypePieceIdentite() { return typePieceIdentite; }
    public void setTypePieceIdentite(String typePieceIdentite) { this.typePieceIdentite = typePieceIdentite; }

    public String getNumeroPieceIdentite() { return numeroPieceIdentite; }
    public void setNumeroPieceIdentite(String numeroPieceIdentite) { this.numeroPieceIdentite = numeroPieceIdentite; }

    public LocalDate getDateExpirationPiece() { return dateExpirationPiece; }
    public void setDateExpirationPiece(LocalDate dateExpirationPiece) { this.dateExpirationPiece = dateExpirationPiece; }

    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }

    public String getEmployeur() { return employeur; }
    public void setEmployeur(String employeur) { this.employeur = employeur; }

    public BigDecimal getRevenuMensuelEstime() { return revenuMensuelEstime; }
    public void setRevenuMensuelEstime(BigDecimal revenuMensuelEstime) { this.revenuMensuelEstime = revenuMensuelEstime; }

    public String getNiveauRisqueClient() { return niveauRisqueClient; }
    public void setNiveauRisqueClient(String niveauRisqueClient) { this.niveauRisqueClient = niveauRisqueClient; }

    public String getStatutKYC() { return statutKYC; }
    public void setStatutKYC(String statutKYC) { this.statutKYC = statutKYC; }

    public LocalDateTime getDateValidationKYC() { return dateValidationKYC; }
    public void setDateValidationKYC(LocalDateTime dateValidationKYC) { this.dateValidationKYC = dateValidationKYC; }

    public StatutClient getStatutClient() { return statutClient; }
    public void setStatutClient(StatutClient statutClient) { this.statutClient = statutClient; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    public LocalDateTime getDateDerniereModification() { return dateDerniereModification; }
    public void setDateDerniereModification(LocalDateTime dateDerniereModification) { this.dateDerniereModification = dateDerniereModification; }
}