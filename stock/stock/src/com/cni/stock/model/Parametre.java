package com.cni.stock.model;

// Generated 7 juil. 2014 18:37:58 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Parametre generated by hbm2java
 */
@Entity
@Table(name = "parametre", catalog = "stock")
public class Parametre implements java.io.Serializable {

	private int idParametre;
	private String libelle;
	private String description;
	private Integer valeurEntier;
	private String valeurChaine;

	public Parametre() {
	}

	public Parametre(int idParametre) {
		this.idParametre = idParametre;
	}

	public Parametre(int idParametre, String libelle, String description,
			Integer valeurEntier, String valeurChaine) {
		this.idParametre = idParametre;
		this.libelle = libelle;
		this.description = description;
		this.valeurEntier = valeurEntier;
		this.valeurChaine = valeurChaine;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_parametre", unique = true, nullable = false)
	public int getIdParametre() {
		return this.idParametre;
	}

	public void setIdParametre(int idParametre) {
		this.idParametre = idParametre;
	}

	@Column(name = "libelle", length = 256)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Column(name = "description", length = 256)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "valeur_entier")
	public Integer getValeurEntier() {
		return this.valeurEntier;
	}

	public void setValeurEntier(Integer valeurEntier) {
		this.valeurEntier = valeurEntier;
	}

	@Column(name = "valeur_chaine", length = 256)
	public String getValeurChaine() {
		return this.valeurChaine;
	}

	public void setValeurChaine(String valeurChaine) {
		this.valeurChaine = valeurChaine;
	}

}
