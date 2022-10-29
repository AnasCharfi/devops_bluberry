package tn.esprit.rh.achat.entities;

import java.util.Set;

public class CategorieProduitDTO {
    private Long idCategorieProduit;
    private String codeCategorie;
    private String libelleCategorie;
    private Set<Produit> produits;
}
