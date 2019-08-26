package com.cni.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.ICategorieDAO;
import com.cni.stock.model.Categorie;

@Service("categorieService")
@Transactional(readOnly = true)
public class CategorieService implements ICategorieService {

	ICategorieDAO categorieDAO;	
	
	@Transactional(readOnly = false)
	@Override
	public void addCategorie(Categorie categorie) {
		getCategorieDAO().addCategorie(categorie);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateCategorie(Categorie categorie) {
		getCategorieDAO().updateCategorie(categorie);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteCategorie(Categorie categorie) {
		getCategorieDAO().deleteCategorie(categorie);
	}

	@Override
	public Categorie findById(int id) {
		return getCategorieDAO().findById(id);
	}

	@Override
	public List<Categorie> findAll() {
		return getCategorieDAO().findAll();
	}
	
	public ICategorieDAO getCategorieDAO() {
		return categorieDAO;
	}
	
	public void setCategorieDAO(ICategorieDAO categorieDAO) {
		this.categorieDAO = categorieDAO;
	}
	
}
