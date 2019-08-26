package com.cni.stock.dao;

import java.util.Date;
import java.util.List;

import com.cni.stock.model.Commande;
import com.cni.stock.model.Fournisseur;

public interface ICommandeDAO {
	
	public void addCommande(Commande commande);
	
	public void updateCommande(Commande commande);
	
	public void deleteCommande(Commande commande);
	
	public Commande findById(int id);
	
	public List<Commande> findAll();

	public Commande findCommandeByDateFournisseur(Date jour, Fournisseur fournisseur);

	public Commande findCommandeByDateAjout(Date jour);

	public Commande findCommandeByDateRetrait(Date jour);

}
