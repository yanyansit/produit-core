package com.mycompagny.produit.service.impl;

import com.mycompagny.produit.entity.Categorie;
import com.mycompagny.produit.entity.Produit;
import com.mycompagny.produit.repository.ProduitRepository;
import com.mycompagny.produit.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    @Override
    //@Transactional
    public Produit saveProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    //@Transactional
    public Produit updateProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    //@Transactional
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);

    }

    @Override
    //@Transactional
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);

    }

    @Override
    //@Transactional(readOnly = true)
    public Produit getProduit(Long id) {
        Optional<Produit> byId = produitRepository.findById(id);

        return byId.isPresent() ? byId.get() : null ;
    }

    @Override
    //@Transactional(readOnly = true)
    public List<Produit> getAllProduits() {
        //List<Produit> list = produitRepository.findAll();
        //ceci permet d'initialiser la catégorie de chaque produit
        //list.forEach(produit -> Hibernate.isInitialized(produit.getCategorie()));
        return produitRepository.findAll();
    }

    @Override
    //@Transactional(readOnly = true)
    public List<Produit> findByNomProduit(String nom) {

        return produitRepository.findByNomProduit(nom);
    }

    @Override
    //@Transactional(readOnly = true)
    public List<Produit> findByNomProduitContains(String nom) {

        return produitRepository.findByNomProduitContains(nom);
    }

    @Override
    //@Transactional(readOnly = true)
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }

    @Override
    //@Transactional(readOnly = true)
    public List<Produit> findByCategorie(Categorie categorie) {

        return produitRepository.findByCategorie(categorie);
    }

    @Override
    //@Transactional(readOnly = true)
    public List<Produit> findByCategorieIdCat(Long id) {

        return produitRepository.findByCategorieIdCat(id);
    }

    @Override
    //@Transactional(readOnly = true)
    public List<Produit> findByOrderByNomProduitAsc() {

        return produitRepository.findByOrderByNomProduitAsc();
    }

    @Override
    //@Transactional(readOnly = true)
    public List<Produit> trierProduitsNomsPrix() {

        return produitRepository.trierProduitsNomsPrix();
    }


}
