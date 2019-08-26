package com.cni.stock.dao;

import java.util.List;

import com.cni.stock.model.Categorie;

public interface ICategorieDAO {
	
	public void addCategorie(Categorie categorie);
	
	public void updateCategorie(Categorie categorie);
	
	public void deleteCategorie(Categorie categorie);
	
	public Categorie findById(int id);
	
	public List<Categorie> findAll();

}
