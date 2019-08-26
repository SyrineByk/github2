package com.cni.stock.dao;

import java.util.List;

import com.cni.stock.model.Facture;

public interface IFactureDAO {
	
	public void addFacture(Facture facture);
	
	public void updateFacture(Facture facture);
	
	public void deleteFacture(Facture facture);
	
	public Facture findById(int id);
	
	public List<Facture> findAll();

}
