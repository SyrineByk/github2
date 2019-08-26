package com.cni.stock.dao;

import java.util.List;

import com.cni.stock.model.Fournisseur;
import com.cni.stock.model.Produit;
import com.cni.stock.model.Vendre;

public interface IProduitDAO {
	
	public void addProduit(Produit produit);
	
	public void updateProduit(Produit produit);
	
	public void deleteProduit(Produit produit);
	
	public Produit findById(int id);
	
	public List<Produit> findAll();
	
	public List<Produit> findProduitByFournisseur(Fournisseur fournisseur);

	public void incrementStock(Produit produit, int nbre);

	public void decrementStock(Produit produit, int nbre);

}
