package com.cni.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.IFactureDAO;
import com.cni.stock.model.Facture;



@Service("factureService")
@Transactional(readOnly = true)
public class FactureService implements IFactureService {

	IFactureDAO factureDAO;
	
	
	@Transactional(readOnly = false)
	@Override
	public void addFacture(Facture facture) {
		getFactureDAO().addFacture(facture);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateFacture(Facture facture) {
		getFactureDAO().updateFacture(facture);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteFacture(Facture facture) {
		getFactureDAO().deleteFacture(facture);
	}

	@Override
	public Facture findById(int id) {
		return getFactureDAO().findById(id);
	}

	@Override
	public List<Facture> findAll() {
		return getFactureDAO().findAll();
	}
	
	public IFactureDAO getFactureDAO() {
		return factureDAO;
	}
	
	public void setFactureDAO(IFactureDAO factureDAO) {
		this.factureDAO = factureDAO;
	}
	
}
