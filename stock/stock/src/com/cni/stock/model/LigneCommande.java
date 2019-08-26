package com.cni.stock.model;

// Generated 7 juil. 2014 18:37:58 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * LigneCommande generated by hbm2java
 */
@Entity
@Table(name = "ligne_commande", catalog = "stock")
public class LigneCommande implements java.io.Serializable {

	private int idLigneCommande;
	private Commande commande;
	private Produit produit;
	private Integer quantite;
	private Integer prixTotal;

	public LigneCommande() {
	}

	public LigneCommande(int idLigneCommande, Produit produit) {
		this.idLigneCommande = idLigneCommande;
		this.produit = produit;
	}

	public LigneCommande(int idLigneCommande, Commande commande,
			Produit produit, Integer quantite, Integer prixTotal) {
		this.idLigneCommande = idLigneCommande;
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
		this.prixTotal = prixTotal;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_ligne_commande", unique = true, nullable = false)
	public int getIdLigneCommande() {
		return this.idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_commande")
	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produit", nullable = false)
	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Column(name = "quantite")
	public Integer getQuantite() {
		return this.quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	@Column(name = "prix_total")
	public Integer getPrixTotal() {
		return this.prixTotal;
	}

	public void setPrixTotal(Integer prixTotal) {
		this.prixTotal = prixTotal;
	}

}