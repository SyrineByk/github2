package com.cni.stock.service;

import java.util.List;

import com.cni.stock.model.Parametre;

public interface IParametreService {
	
	public void addParametre(Parametre parametre);
	
	public void updateParametre(Parametre parametre);
	
	public void deleteParametre(Parametre parametre);
	
	public Parametre findById(int id);
	
	public List<Parametre> findAll();

}


