package com.cni.stock.dao;

import java.util.List;

import com.cni.stock.model.Parametre;

public interface IParametreDAO {
	
	public void addParametre(Parametre parametre);
	
	public void updateParametre(Parametre parametre);
	
	public void deleteParametre(Parametre parametre);
	
	public Parametre findById(int id);
	
	public List<Parametre> findAll();

}
