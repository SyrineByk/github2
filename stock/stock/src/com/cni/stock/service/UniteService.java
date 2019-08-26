package com.cni.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.IUniteDAO;
import com.cni.stock.model.Unite;



@Service("uniteService")
@Transactional(readOnly = true)
public class UniteService implements IUniteService {

	IUniteDAO uniteDAO;
	
	
	@Transactional(readOnly = false)
	@Override
	public void addUnite(Unite unite) {
		getUniteDAO().addUnite(unite);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateUnite(Unite unite) {
		getUniteDAO().updateUnite(unite);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteUnite(Unite unite) {
		getUniteDAO().deleteUnite(unite);
	}

	@Override
	public Unite findById(int id) {
		return getUniteDAO().findById(id);
	}

	@Override
	public List<Unite> findAll() {
		return getUniteDAO().findAll();
	}
	
	public IUniteDAO getUniteDAO() {
		return uniteDAO;
	}
	
	public void setUniteDAO(IUniteDAO uniteDAO) {
		this.uniteDAO = uniteDAO;
	}
	
}
