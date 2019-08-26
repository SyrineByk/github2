package com.cni.stock.service;

import java.util.List;

import com.cni.stock.model.Categorie;

public interface ICategorieService {
	
	public void addCategorie(Categorie categorie);
	
	public void updateCategorie(Categorie categorie);
	
	public void deleteCategorie(Categorie categorie);
	
	public Categorie findById(int id);
	
	public List<Categorie> findAll();

}


