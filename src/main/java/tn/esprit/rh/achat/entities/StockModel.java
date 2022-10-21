package tn.esprit.rh.achat.entities;


import java.util.Set;
import lombok.Data;

@Data
public class StockModel {

         long idStock;
         String libelleStock;
         Integer qte;
         Integer qteMin;
         Set<Produit> produits;


}

