package tn.esprit.rh.achat;

import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplMock {
    @Mock
    OperateurRepository repo;
    @InjectMocks
    OperateurServiceImpl OperateurService;
 Operateur o = Operateur.builder().nom("thouraya").prenom("mazlout").password("pwd").build();
 List<Operateur> listop = new ArrayList<Operateur>(){
     {
         add( Operateur.builder().nom("Thouraya1").prenom("Mazlout1").password("PWD51").build());
         add(Operateur.builder().nom("Thouraya2").prenom("Mazlout2").password("PWD52").build());

     }

 };


    @Test
    void TestRetrieveOperateur(){
        Mockito.when(repo.findById(Mockito.anyLong())).thenReturn(Optional.of(o));
        Operateur o1 = OperateurService.retrieveOperateur(Long.valueOf("1"));
        Assertions.assertNotNull(o1);

    }

    @Test
    void TestRetrieveAllOperateur() {
        Mockito.when(repo.findAll()).thenReturn(listop);
        int listOperateurs = OperateurService.retrieveAllOperateurs().size();
        Assertions.assertEquals(listop.size() , OperateurService.retrieveAllOperateurs().size());

    }


    @Test
    public void TestAddOperateur(){
        Mockito.when(repo.save(o)).thenReturn(o);
        Operateur O= OperateurService.addOperateur(o);
        Assertions.assertNotNull(O);
    }

    @Test
    void TestdeleteOperateur(){
        OperateurService.deleteOperateur(1l);
        Mockito.verify(repo).deleteById(1l);
        int listOperateurs = OperateurService.retrieveAllOperateurs().size();
        Assertions.assertEquals(listOperateurs,OperateurService.retrieveAllOperateurs().size());
    }

    @Test
    void TestUpdateOperateur(){
        Mockito.when(repo.save(o)).thenReturn(o);
        Operateur ou= OperateurService.updateOperateur(o);
        Assertions.assertNotNull(ou);
    }

}
