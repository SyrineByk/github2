package com.cni.stock.dao;

import java.util.List;

import com.cni.stock.model.Fournisseur;

public interface IFournisseurDAO {
	
	public void addFournisseur(Fournisseur fournisseur);
	
	public void updateFournisseur(Fournisseur fournisseur);
	
	public void deleteFournisseur(Fournisseur fournisseur);
	
	public Fournisseur findById(int id);
	
	public List<Fournisseur> findAll();

}
