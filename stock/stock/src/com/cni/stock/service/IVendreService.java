package com.cni.stock.service;

import java.util.List;

import com.cni.stock.model.Fournisseur;
import com.cni.stock.model.Produit;
import com.cni.stock.model.Vendre;

public interface IVendreService {
	
	public void addVendre(Vendre vendre);
	
	public void updateVendre(Vendre vendre);
	
	public void deleteVendre(Vendre vendre);
	
	public Vendre findById(int id);
	
	public Vendre findByProduitFournisseur(Produit produit, Fournisseur fournisseur);
	
	public List<Vendre> findAll();

	public List<Vendre> getVendreListByFournisseur(Fournisseur fournisseur);
	
	public List<Produit> getOtherProduitByFournisseur(Fournisseur fournisseur);

}


