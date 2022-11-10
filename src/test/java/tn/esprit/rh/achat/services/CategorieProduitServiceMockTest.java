package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CategorieProduitServiceMockTest {

    @Mock
    CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    CategorieProduitServiceImpl categorieProduitService;

    CategorieProduit categorieProduit = new CategorieProduit(Long.valueOf(1),"CodeCat", "LibelleCat",null);

    List<CategorieProduit> mycategories = new ArrayList<CategorieProduit>() {
        {
        add(new CategorieProduit(Long.valueOf(2),"CodeCat2", "LibelleCat2",null));
        add(new CategorieProduit(Long.valueOf(2),"CodeCat2", "LibelleCat2",null));
        }
    };

    @Test
    void retrieveAllCategorieProduit()
    {
        Mockito.when(categorieProduitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categorieProduit));
        CategorieProduit categorieProduit1 = categorieProduitService.retrieveCategorieProduit(Long.valueOf(1));
        assertNotNull(categorieProduit1);
    }
}
