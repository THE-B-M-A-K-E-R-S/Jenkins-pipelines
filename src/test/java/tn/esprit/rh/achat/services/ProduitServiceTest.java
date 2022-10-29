package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 class ProduitServiceTest {

    @Autowired
    IProduitService ps;

    @Test
    @Order(1)
    void testRetrieveAllUsers() {
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }

    @Test
    @Order(2)
    void testAddProduit() {
        Produit p = new Produit();
        p.setIdProduit(1L);
        p.setLibelleProduit("Produit 1");
        p.setPrix(100);
        p.setPrix(10F);
        ps.addProduit(p);
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(1, listProduits.size());
        ps.deleteProduit(p.getIdProduit());
    }

    @Test
    @Order(3)
     void testUpdateProduit() {
        Produit p = new Produit();
        p.setIdProduit(1L);
        p.setLibelleProduit("Produit 1");
        p.setPrix(100);
        p.setPrix(10F);
        ps.addProduit(p);
        Produit updated = ps.getProduitByLibelle("Produit 1");
        updated.setLibelleProduit("Produit 2");
        ps.updateProduit(updated, updated.getIdProduit());
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(1, listProduits.size());
        Assertions.assertEquals("Produit 2", listProduits.get(0).getLibelleProduit());
        ps.deleteProduit(updated.getIdProduit());
    }

    @Test
    @Order(4)
    void testDeleteProduit() {
        Produit p = new Produit();
        p.setIdProduit(1L);
        p.setLibelleProduit("Produit 1");
        p.setPrix(100);
        p.setPrix(10F);
        ps.addProduit(p);
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(1, listProduits.size());
        ps.deleteProduit(listProduits.get(0).getIdProduit());
        listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }


}
