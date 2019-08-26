package com.cni.stock.service;

import java.util.List;

import com.cni.stock.model.Unite;

public interface IUniteService {
	
	public void addUnite(Unite unite);
	
	public void updateUnite(Unite unite);
	
	public void deleteUnite(Unite unite);
	
	public Unite findById(int id);
	
	public List<Unite> findAll();

}


