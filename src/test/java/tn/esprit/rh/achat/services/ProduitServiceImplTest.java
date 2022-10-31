package tn.esprit.rh.achat.services;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Produit;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@RunWith(SpringRunner.class)
public class ProduitServiceImplTest {

    @Autowired
    IProduitService produitService;

    @Test
    @Order(1)
    public void testAddProduit(){
        List<Produit> produits = produitService.retrieveAllProduits();
        int expected = produits.size();
        Produit prod = new Produit();
        prod.setCodeProduit("Test Code");
        prod.setLibelleProduit("Test Libelle");
        Produit prodSaved = produitService.addProduit(prod);
        assertEquals(expected+1,produitService.retrieveAllProduits().size());
        assertNotNull(prodSaved.getLibelleProduit());
        produitService.deleteProduit(prodSaved.getIdProduit());
    }

    @Test
    @Order(2)
    public void testUpdateProduit()  {
        List<Produit> produits = produitService.retrieveAllProduits();
        if (produits.isEmpty())
        {
            log.info("aucun produit à tester !");
            return ;
        }
        Produit oldProd= produits.get(0) ;
        Produit prod = new Produit();
        prod.setIdProduit(oldProd.getIdProduit());
        prod.setCodeProduit("CodeTest");
        prod.setLibelleProduit("LibelleTest");
        Produit savedProduit= produitService.updateProduit(prod);
        assertNotEquals(savedProduit,oldProd);
        assertNotNull(savedProduit.getLibelleProduit());
        produitService.updateProduit(oldProd);
    }

    @Test
    @Order(3)
    public void testDeleteProduit() {

        Produit prod = new Produit();
        prod.setLibelleProduit("Test Libelle");
        prod.setCodeProduit("Test Code");
        Produit savedProd = produitService.addProduit(prod);
        log.info("produit à supprimer : " +savedProd);
        Long idToBeDeleted = savedProd.getIdProduit();
        produitService.deleteProduit(idToBeDeleted);
        assertNull(produitService.retrieveProduit(idToBeDeleted));
    }
    
    @Test
    @Order(4)
    public void testRetrieveProduitById(){
        Produit prod = new Produit();
        String l = "Test Libelle";
        prod.setLibelleProduit(l);
        prod.setCodeProduit("Test Code");
        Produit savedProd = produitService.addProduit(prod);
        Produit p = produitService.retrieveProduit(savedProd.getIdProduit());
        assertEquals(l,p.getLibelleProduit());
        produitService.deleteProduit(savedProd.getIdProduit());
    }

    @Test
    @Order(5)
    public void testRetrieveAllProduit(){
        int expected = produitService.retrieveAllProduits().size();
        Produit prod = new Produit();
        prod.setLibelleProduit("Test Libelle");
        prod.setCodeProduit("Test Code");
        Produit prodSaved = produitService.addProduit(prod);
        int s = produitService.retrieveAllProduits().size();
        assertNotEquals(expected,s);
        produitService.deleteProduit(prodSaved.getIdProduit());
    }

}