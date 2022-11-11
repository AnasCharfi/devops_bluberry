package tn.esprit.rh.achat.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplMock {
	@Mock
    ProduitRepository produitRepository;

    @InjectMocks
    ProduitServiceImpl produitService;

    Produit produit = new Produit(Long.valueOf(1),"CodeProd", "LibelleProd",(float) 30.0,new Date(),new Date(),null,null,null);

    List<Produit> myproduits = new ArrayList<Produit>() {
        {
        add(new Produit(Long.valueOf(2),"prod2", "aa",(float) 30.0,new Date(),new Date(),null,null,null));
        add(new Produit(Long.valueOf(3),"prod3", "bb",(float) 10.0,new Date(),new Date(),null,null,null));
        }
    };

    @Test
    public void retrieveProduit()
    {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit produit1 = produitService.retrieveProduit(Long.valueOf(1));
        assertNotNull(produit1);
    }
}
