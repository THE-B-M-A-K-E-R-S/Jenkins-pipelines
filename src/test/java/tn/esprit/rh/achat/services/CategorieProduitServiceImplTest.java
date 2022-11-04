package tn.esprit.rh.achat.services;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategorieProduitServiceImplTest {

    @Autowired
    ICategorieProduitService cps;

    @Test
    @Order(1)
    void testRetrieveAllCategorieProduits() {
        List<CategorieProduit> listCategorieProduits = cps.retrieveAllCategorieProduits();
        Assertions.assertEquals(0, listCategorieProduits.size());
    }

    @Test
    @Order(2)
    void testAddCategorieProduit() {
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setIdCategorieProduit(1L);
        categorieProduit.setCodeCategorie("Test");
        categorieProduit.setLibelleCategorie("Lib");
        cps.addCategorieProduit(categorieProduit);
        List<CategorieProduit> categorieProduits = cps.retrieveAllCategorieProduits();
        Assertions.assertEquals(1, categorieProduits.size());
        cps.deleteCategorieProduit(categorieProduit.getIdCategorieProduit());
    }

    @Test
    @Order(3)
    void testDeleteCategorieProduit() {
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setIdCategorieProduit(1L);
        categorieProduit.setCodeCategorie("Test");
        categorieProduit.setLibelleCategorie("Lib");
        cps.addCategorieProduit(categorieProduit);
        List<CategorieProduit> categorieProduits = cps.retrieveAllCategorieProduits();
        Assertions.assertEquals(1, categorieProduits.size());
        cps.deleteCategorieProduit(categorieProduits.get(0).getIdCategorieProduit());
        categorieProduits = cps.retrieveAllCategorieProduits();
        Assertions.assertEquals(0, categorieProduits.size());
    }

    @Test
    @Order(4)
    void testUpdateCategorieProduit() {
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setIdCategorieProduit(1L);
        categorieProduit.setCodeCategorie("Test");
        categorieProduit.setLibelleCategorie("Lib");
        cps.addCategorieProduit(categorieProduit);
        CategorieProduit updated = cps.retrieveCategorieProduit(1L);
        updated.setLibelleCategorie("Lib 2");
        cps.updateCategorieProduit(updated);
        List<CategorieProduit> categorieProduits = cps.retrieveAllCategorieProduits();
        Assertions.assertEquals(1, categorieProduits.size());
        Assertions.assertEquals("Lib 2", categorieProduits.get(0).getLibelleCategorie());
        cps.deleteCategorieProduit(updated.getIdCategorieProduit());
    }

    @Test
    @Order(5)
    void testRetrieveCategorieProduit() {
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setIdCategorieProduit(1L);
        categorieProduit.setCodeCategorie("Test");
        categorieProduit.setLibelleCategorie("Lib");
        cps.addCategorieProduit(categorieProduit);
        CategorieProduit retrieved = cps.retrieveCategorieProduit(1L);
        Assertions.assertEquals(categorieProduit.getLibelleCategorie(), retrieved.getLibelleCategorie());
        Assertions.assertEquals(categorieProduit.getCodeCategorie(), retrieved.getCodeCategorie());
        Assertions.assertEquals(categorieProduit.getIdCategorieProduit(), retrieved.getIdCategorieProduit());
        cps.deleteCategorieProduit(retrieved.getIdCategorieProduit());
    }


}
