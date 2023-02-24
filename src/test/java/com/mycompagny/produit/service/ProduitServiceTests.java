package com.mycompagny.produit.service;


import com.mycompagny.produit.entity.Categorie;
import com.mycompagny.produit.entity.Produit;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProduitServiceTests {

    @Autowired
    private ProduitService produitService;

    @Test
    public void testAllProduits() {
        List<Produit> prods = produitService.getAllProduits();
        assertEquals(prods.size(), 4);
        for (Produit p : prods)
            System.out.println(p);

    }
    @Test
    public void testFindByNomProduit() {
        List<Produit> prods = produitService.findByNomProduit("Ipad3");
        assertEquals(prods.size(), 1);
        for (Produit p : prods)
            System.out.println(p);

    }

    @Test
    public void testFindByNomProduitContains() {
        List<Produit> prods = produitService.findByNomProduitContains("Ipad3");
        assertEquals(prods.size(), 1);
        for (Produit p : prods)
            System.out.println(p);

    }


    @Test
    public void testFindByNomPrix() {
        List<Produit> list = produitService.getAllProduits();
        for (Produit p : list) {
            System.out.println(p);
        }
        List<Produit> prods = produitService.findByNomPrix("Ipad3", 300.0);
        assertEquals(prods.size(), 1);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }


    @Test
    public void testFindByCategorie() {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);

        List<Produit> prods = produitService.findByCategorie(cat);
        assertEquals(prods.size(), 2);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByCategorieIdCat() {
        List<Produit> prods = produitService.findByCategorieIdCat(1L);
        assertEquals(prods.size(), 2);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }


    @Test
    public void testFindByOrderByNomProduitAsc() {
        List<Produit> prods = produitService.findByOrderByNomProduitAsc();
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testTrierProduitsNomsPrix() {
        List<Produit> prods = produitService.trierProduitsNomsPrix();
        for (Produit p : prods) {
            System.out.println(p);
        }
    }


    @Test
    public void testSaveProduit() {
        Produit prod = new Produit("PC Asus", 1500.500, new Date());
        produitService.saveProduit(prod);
        System.out.println(prod);

        Produit foundEntity = produitService.getProduit(prod.getIdProduit());
        assertNotNull(foundEntity);
        assertEquals(prod.getNomProduit(), foundEntity.getNomProduit());
        System.out.println(foundEntity);
    }

    @Test
    public void testUpdateProduit() {

        Produit p = produitService.getProduit(1L);
        p.setPrixProduit(2000.0);
        produitService.updateProduit(p);
        System.out.println(p);

        Produit foundEntity = produitService.getProduit(p.getIdProduit());
        assertEquals(p.getPrixProduit(), foundEntity.getPrixProduit());
        System.out.println(foundEntity);
    }

    @Test
    public void testDeleteProduit() {
        Long idProduit = 2L;
        Produit produit = produitService.getProduit(idProduit);
        assertNotNull(produit);
        produitService.deleteProduit(produit);

        Produit foundEntity = produitService.getProduit(idProduit);
        assertEquals(foundEntity, null);
    }

    @Test
    public void testDeleteProduitById() {
        Long idProduit = 1L;
        Produit produit = produitService.getProduit(idProduit);
        assertNotNull(produit);
        produitService.deleteProduitById(idProduit);

        Produit foundEntity = produitService.getProduit(idProduit);
        assertEquals(foundEntity, null);

    }




}
