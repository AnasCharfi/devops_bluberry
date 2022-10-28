package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.services.IFactureService;

class FactureServiceImplTest {

	@Autowired
	IFactureService factureService;

	@Test
	void testAddFacture() {
		

		List<Facture> stocks = factureService.retrieveAllFactures();
		int expected = stocks.size();
		Facture f = new Facture();
		f.setMontantFacture(1000);
		f.setMontantRemise(50);
		Calendar calendar = Calendar.getInstance();

		f.setDateCreationFacture(calendar.getTime());

		Facture savedFacture = factureService.addFacture(f);
		assertEquals(expected + 1, factureService.retrieveAllFactures().size());
		assertNotNull(savedFacture.getIdFacture());
	}
}
