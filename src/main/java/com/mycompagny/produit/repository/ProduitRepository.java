package com.mycompagny.produit.repository;

import com.mycompagny.produit.entity.Categorie;
import com.mycompagny.produit.entity.Produit;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource permet d'afficher la liste des services à la racine
//en ajoutant path = "rest" se sera afficher dans /localhost:8080/produits/rest
@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    //@Query("select produit from Produit produit inner join fetch produit.categorie")
    @EntityGraph(value="produit.categorie",type= EntityGraph.EntityGraphType.FETCH)
    //List<Produit> findAll();

    //avec spring pas besoin d'écrire la requete, c'est automatique en indiquant exactement les bonnes variable
    List<Produit> findByNomProduit(String nom);

    List<Produit> findByNomProduitContains(String nom);
	
	/*@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
	List<Produit> findByNomPrix (String nom, Double prix);*/

    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit >= :prix")
    List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

    @Query("select p from Produit p where p.categorie = ?1")
    List<Produit> findByCategorie(Categorie categorie);

    List<Produit> findByCategorieIdCat(Long id);

    List<Produit> findByOrderByNomProduitAsc();

    @Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
    List<Produit> trierProduitsNomsPrix();

}
