package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.services.IFactureService;


@SpringBootTest
class FactureServiceImplTest {

	
	@Autowired
	IFactureService factureService;

	@Test
	void testAddFacture() {
		
		
		List<Facture> stocks = factureService.retrieveAllFactures();
		int expected = stocks.size();
		Facture f = factureService.addFacture(Facture.builder().montantFacture(1000).montantRemise(200).build());
		assertEquals(expected + 1, factureService.retrieveAllFactures().size());
		assertNotNull(f.getIdFacture());
	}
}
