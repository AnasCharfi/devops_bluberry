package tn.esprit.rh.achat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.IOperateurService;

@SpringBootTest
class OperateurServiceImplTest {

    @Autowired
    IOperateurService OprateurServiceImpl;
    OperateurRepository repo;

    @Test
    @Rollback(true)
    public void TestAddOperateur() {
        Operateur O = OprateurServiceImpl.addOperateur(Operateur.builder().nom("Thouraya").prenom("Mazlout")
                .password("PWD5").build());
        Assertions.assertNotNull(O);
    }

    @Test
    @Rollback(false)
    void TestRetrieveAllOperateur() {
        int listOperateurs = OprateurServiceImpl.retrieveAllOperateurs().size();
        OprateurServiceImpl.addOperateur(Operateur.builder().nom("Thouraya").prenom("Mazlout")
                .password("PWD5").build());
        Assertions.assertEquals(listOperateurs + 1, OprateurServiceImpl.retrieveAllOperateurs().size());
    }

    @Test
    void TestdeleteOperateur() {
        long id = 5;
        int listOperateurs = OprateurServiceImpl.retrieveAllOperateurs().size();
        OprateurServiceImpl.deleteOperateur(id);
        Assertions.assertEquals(listOperateurs - 1, OprateurServiceImpl.retrieveAllOperateurs().size());
    }

    @Test
    @Rollback(false)
    void TestRetrieveOperateur() {
        long id = 13;
        Operateur o = OprateurServiceImpl.retrieveOperateur(id);
        Assertions.assertNotNull(o);
    }

    @Test
    @Rollback(false)
    void TestUpdateOperateur() {
        Operateur o = OprateurServiceImpl.addOperateur(Operateur.builder().nom("Thouraya").prenom("Mazlout")
                .password("PWD5").build());
        Operateur ou = OprateurServiceImpl.updateOperateur(o);
        Assertions.assertNotNull(ou);
    }

}