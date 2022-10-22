package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.services.FactureServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplTest {

	@Autowired
	FactureServiceImpl factureService;

	@Test
	public void testAddFacture() {
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
