package com.mycompagny.produit.repository;


import com.mycompagny.produit.entity.Categorie;
import com.mycompagny.produit.entity.Produit;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
class ProduitRepositoryTests {

    @Autowired
    private ProduitRepository produitRepository;

    @Test
    public void testCreateAndFindProduit() {
        Produit prod = new Produit("PC Asus", 1500.500, new Date());
        produitRepository.save(prod);
        System.out.println(prod);

        Produit foundEntity = produitRepository.findById(prod.getIdProduit()).get();
        assertNotNull(foundEntity);
        assertEquals(prod.getNomProduit(), foundEntity.getNomProduit());
        System.out.println(foundEntity);
    }

    @Test
    public void testUpdateProduit() {

        Produit p = produitRepository.findById(1L).get();
        p.setPrixProduit(2000.0);
        produitRepository.save(p);
        System.out.println(p);

        Produit foundEntity = produitRepository.findById(p.getIdProduit()).get();
        assertEquals(p.getPrixProduit(),foundEntity.getPrixProduit());
        System.out.println(foundEntity);
    }

    @Test
    public void testDeleteProduit() {
        Long idProduit = 1L;
        Produit produit = produitRepository.findById(idProduit).get();
        assertNotNull(produit);
        produitRepository.deleteById(idProduit);

        try {
            Produit foundEntity = produitRepository.findById(idProduit).get();
            assertTrue(false);
        }catch (NoSuchElementException e){
            assertTrue(true);
        }

    }

    @Test
    public void testFindAllProduits() {
        List<Produit> prods = produitRepository.findAll();
        assertEquals(prods.size(),4);
        for (Produit p : prods)
            System.out.println(p);

    }


    @Test
    public void testFindProduitByNom() {
        List<Produit> prods = produitRepository.findByNomProduit("Ipad1");
        assertEquals(prods.size(),2);
        for (Produit p : prods)
            System.out.println(p);

    }

    @Test
    public void testFindProduitByNomContains() {
        List<Produit> prods = produitRepository.findByNomProduitContains("Ipad3");
        assertEquals(prods.size(),1);
        for (Produit p : prods)
            System.out.println(p);

    }

    @Test
    public void testfindByNomPrix() {
        List<Produit> prods = produitRepository.findByNomPrix("Ipad3", 300.0);
        assertEquals(prods.size(),1);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }


    @Test
    public void testfindByCategorie() {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);

        List<Produit> prods = produitRepository.findByCategorie(cat);
        assertEquals(prods.size(),2);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void findByCategorieIdCat() {
        List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
        assertEquals(prods.size(),2);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }


    @Test
    public void testfindByOrderByNomProduitAsc() {
        List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testTrierProduitsNomsPrix() {
        List<Produit> prods = produitRepository.trierProduitsNomsPrix();
        for (Produit p : prods) {
            System.out.println(p);
        }
    }


}
