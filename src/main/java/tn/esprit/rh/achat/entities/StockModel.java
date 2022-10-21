package tn.esprit.rh.achat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.esprit.rh.achat.entities.Produit;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

public class StockModel {
        public String libelleStock;
        public Integer qte;
        public Integer qteMin;
        public  Set<Produit> produits;


}

