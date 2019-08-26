package com.cni.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.IFournisseurDAO;
import com.cni.stock.model.Fournisseur;


@Service("fournisseurService")
@Transactional(readOnly = true)
public class FournisseurService implements IFournisseurService {

	IFournisseurDAO fournisseurDAO;
	
	
	@Transactional(readOnly = false)
	@Override
	public void addFournisseur(Fournisseur fournisseur) {
		getFournisseurDAO().addFournisseur(fournisseur);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateFournisseur(Fournisseur fournisseur) {
		getFournisseurDAO().updateFournisseur(fournisseur);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteFournisseur(Fournisseur fournisseur) {
		getFournisseurDAO().deleteFournisseur(fournisseur);
	}

	@Override
	public Fournisseur findById(int id) {
		return getFournisseurDAO().findById(id);
	}

	@Override
	public List<Fournisseur> findAll() {
		return getFournisseurDAO().findAll();
	}
	
	public IFournisseurDAO getFournisseurDAO() {
		return fournisseurDAO;
	}
	
	public void setFournisseurDAO(IFournisseurDAO fournisseurDAO) {
		this.fournisseurDAO = fournisseurDAO;
	}
	
}
