package com.cni.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.ITypeDAO;
import com.cni.stock.model.Type;



@Service("typeService")
@Transactional(readOnly = true)
public class TypeService implements ITypeService {

	ITypeDAO typeDAO;
	
	
	@Transactional(readOnly = false)
	@Override
	public void addType(Type type) {
		getTypeDAO().addType(type);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateType(Type type) {
		getTypeDAO().updateType(type);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteType(Type type) {
		getTypeDAO().deleteType(type);
	}

	@Override
	public Type findById(int id) {
		return getTypeDAO().findById(id);
	}

	@Override
	public List<Type> findAll() {
		return getTypeDAO().findAll();
	}
	
	public ITypeDAO getTypeDAO() {
		return typeDAO;
	}
	
	public void setTypeDAO(ITypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}
	
}
