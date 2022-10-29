package tn.esprit.rh.achat.entities;

import java.util.Date;
import java.util.Set;


public class ProduitDTO {
    private Long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private float prix;

    private Date dateCreation;

    private Date dateDerniereModification;

    private Stock stock;

    private Set<DetailFacture> detailFacture;

    private CategorieProduit categorieProduit;
}
