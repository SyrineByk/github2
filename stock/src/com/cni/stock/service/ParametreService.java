package com.cni.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.IParametreDAO;
import com.cni.stock.model.Parametre;



@Service("parametreService")
@Transactional(readOnly = true)
public class ParametreService implements IParametreService {

	IParametreDAO parametreDAO;
	
	
	@Transactional(readOnly = false)
	@Override
	public void addParametre(Parametre parametre) {
		getParametreDAO().addParametre(parametre);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateParametre(Parametre parametre) {
		getParametreDAO().updateParametre(parametre);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteParametre(Parametre parametre) {
		getParametreDAO().deleteParametre(parametre);
	}

	@Override
	public Parametre findById(int id) {
		return getParametreDAO().findById(id);
	}

	@Override
	public List<Parametre> findAll() {
		return getParametreDAO().findAll();
	}
	
	public IParametreDAO getParametreDAO() {
		return parametreDAO;
	}
	
	public void setParametreDAO(IParametreDAO parametreDAO) {
		this.parametreDAO = parametreDAO;
	}
	
}
