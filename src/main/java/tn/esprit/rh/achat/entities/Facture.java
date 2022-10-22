package tn.esprit.rh.achat.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	private float montantRemise;
	private float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateCreationFacture;
	@Temporal(TemporalType.DATE)
	private Date dateDerniereModificationFacture;
	private Boolean archivee;
	@OneToMany(mappedBy = "facture")
	private Set<DetailFacture> detailsFacture;
	@ManyToOne
	@JsonIgnore
	private Fournisseur fournisseur;
	@OneToMany(mappedBy = "facture")
	@JsonIgnore
	private Set<Reglement> reglements;

	public Facture(FactureModel fm) {
		super();
		this.idFacture = fm.getIdFacture();
		this.montantFacture = fm.getMontantFacture();
		this.montantRemise = fm.getMontantRemise();
		this.dateCreationFacture = fm.getDateCreationFacture();
		this.dateDerniereModificationFacture = fm.getDateDerniereModificationFacture();
		this.archivee = fm.getArchivee();
		this.detailsFacture = fm.getDetailsFacture();
		this.fournisseur = fm.getFournisseur();
		this.reglements = fm.getReglements();
	}
}
