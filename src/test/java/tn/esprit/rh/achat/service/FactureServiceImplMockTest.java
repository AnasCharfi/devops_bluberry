package tn.esprit.rh.achat.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FactureServiceImplMockTest {
	
	@Mock
	FactureRepository factureRepository;

	@InjectMocks
	FactureServiceImpl factureService;

	
	Facture facture = new Facture( Long.valueOf(1), 100, 10, new Date(), new Date(), false, null, null, null);
	List<Facture> listFacture= new ArrayList<Facture>() {
	{
	add(new Facture( Long.valueOf(2), 200, 20, new Date(), new Date(), false, null, null, null));
	add(new Facture( Long.valueOf(3), 300, 30, new Date(), new Date(), false, null, null, null));
	}
	};
	
	@Test
	void retrieveAllFacturesMock() {
		Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));
		Facture f1 = factureService.retrieveFacture(Long.valueOf(1));
		assertNotNull(f1);
		System.out.println(f1.getIdFacture() +" " +f1.getMontantFacture() + " " +f1.getMontantRemise());
	}
}
