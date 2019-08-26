package com.cni.stock.service;

import java.util.List;

import com.cni.stock.model.LigneCommande;

public interface ILigneCommandeService {
	
	public void addLigneCommande(LigneCommande ligneCommande);
	
	public void updateLigneCommande(LigneCommande ligneCommande);
	
	public void deleteLigneCommande(LigneCommande ligneCommande);
	
	public LigneCommande findById(int id);
	
	public List<LigneCommande> findAll();

	public List<LigneCommande> findAllAchat();
	
	public List<LigneCommande> findAllAjout();
	
	public List<LigneCommande> findAllRetrait();
	
}


