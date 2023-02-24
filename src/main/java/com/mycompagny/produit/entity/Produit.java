package com.mycompagny.produit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PRODUIT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "produit.categorie", attributeNodes = @NamedAttributeNode("categorie"))
public class Produit implements Serializable {

    private static final long serialVersionUID = 8622079431204218869L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUIT")
    private Long idProduit;

    @Column(name = "NOM_PRODUIT", nullable = false, length = 40)
    private String nomProduit;

    @Column(name = "PRIX_PRODUIT", nullable = false)
    private Double prixProduit;

    @Column(name = "DATE_CREATION", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCat", nullable = true)
    private Categorie categorie;


    public Produit(String nomProduit, Double prixProduit, Date dateCreation) {
        super();
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
    }

    public Categorie getCategorie() {
        if (this.categorie == null) {
            this.categorie = new Categorie();
        }
        return this.categorie;
    }

    @Override
    public String toString() {
        return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit
                + ", dateCreation=" + dateCreation + "]";
    }


}
