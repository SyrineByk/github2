package com.cni.stock.service;

import java.util.List;

import com.cni.stock.model.Type;

public interface ITypeService {
	
	public void addType(Type type);
	
	public void updateType(Type type);
	
	public void deleteType(Type type);
	
	public Type findById(int id);
	
	public List<Type> findAll();

}


