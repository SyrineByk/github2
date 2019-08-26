package com.cni.stock.service;

import java.util.List;

import com.cni.stock.model.Fournisseur;

public interface IFournisseurService {
	
	public void addFournisseur(Fournisseur fournisseur);
	
	public void updateFournisseur(Fournisseur fournisseur);
	
	public void deleteFournisseur(Fournisseur fournisseur);
	
	public Fournisseur findById(int id);
	
	public List<Fournisseur> findAll();

}


