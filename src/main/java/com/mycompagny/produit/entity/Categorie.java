package com.mycompagny.produit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CATEGORIE")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAT")
    private Long idCat;

    @Column(name = "NOM_CAT")
    private String nomCat;

    @Column(name = "DESCRIPTION_CAT")
    private String descriptionCat;


    @OneToMany(mappedBy = "categorie")
    @JsonIgnore //permet d'éviter la référence croisé, une boucle infini lors de l'appel du Webservice
    private List<Produit> produits;
}
