package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class CategorieProduitServiceImplTest {
/*
    @Autowired
    ICategorieProduitService categorieProduitService;

    @Test
    @Order(1)
    void testAddCategorieProduit(){
        List<CategorieProduit> categories = categorieProduitService.retrieveAllCategorieProduits();
        int expected = categories.size();
        CategorieProduit cat = new CategorieProduit();
        cat.setCodeCategorie("Test Code");
        cat.setLibelleCategorie("Test Libelle");
        CategorieProduit catSaved = categorieProduitService.addCategorieProduit(cat);
        assertEquals(expected+1,categorieProduitService.retrieveAllCategorieProduits().size());
        assertNotNull(catSaved.getLibelleCategorie());
        categorieProduitService.deleteCategorieProduit(catSaved.getIdCategorieProduit());
    }

    @Test
    @Order(2)
    void testUpdateCategorieProduit()  {
        List<CategorieProduit> categories = categorieProduitService.retrieveAllCategorieProduits();
        if (categories.isEmpty())
        {
            log.info("Pas de categories à tester !");
            return ;
        }
        CategorieProduit oldCat= categories.get(0) ;
        CategorieProduit cat = new CategorieProduit();
        cat.setIdCategorieProduit(oldCat.getIdCategorieProduit());
        cat.setCodeCategorie("CodeTest");
        cat.setLibelleCategorie("LibelleTest");
        CategorieProduit savedCategorie= categorieProduitService.updateCategorieProduit(cat);
        assertNotEquals(savedCategorie,oldCat);
        assertNotNull(savedCategorie.getLibelleCategorie());
        categorieProduitService.updateCategorieProduit(oldCat);
    }

    @Test
    @Order(3)
    void testDeleteCategorieProduit() {

        CategorieProduit cat = new CategorieProduit();
        cat.setLibelleCategorie("Test Libelle");
        cat.setCodeCategorie("Test Code");
        CategorieProduit savedCat = categorieProduitService.addCategorieProduit(cat);
        log.info("catégorie à supprimer : " +savedCat);
        Long idToBeDeleted = savedCat.getIdCategorieProduit();
        categorieProduitService.deleteCategorieProduit(idToBeDeleted);
        assertNull(categorieProduitService.retrieveCategorieProduit(idToBeDeleted));
    }

    @Test
    @Order(4)
    void testRetrieveCategorieProduitById(){
        CategorieProduit cat = new CategorieProduit();
        String s = "Test Libelle";
        cat.setLibelleCategorie(s);
        cat.setCodeCategorie("Test Code");
        CategorieProduit savedCat = categorieProduitService.addCategorieProduit(cat);
        CategorieProduit c = categorieProduitService.retrieveCategorieProduit(savedCat.getIdCategorieProduit());
        assertEquals(s,c.getLibelleCategorie());
        categorieProduitService.deleteCategorieProduit(savedCat.getIdCategorieProduit());
    }

    @Test
    @Order(5)
    void testRetrieveAllCategorieProduit(){
        int expected = categorieProduitService.retrieveAllCategorieProduits().size();
        CategorieProduit cat = new CategorieProduit();
        cat.setLibelleCategorie("Test Libelle");
        cat.setCodeCategorie("Test Code");
        CategorieProduit catSaved = categorieProduitService.addCategorieProduit(cat);
        int x = categorieProduitService.retrieveAllCategorieProduits().size();
        assertNotEquals(expected,x);
        categorieProduitService.deleteCategorieProduit(catSaved.getIdCategorieProduit());
    }
*/
}
