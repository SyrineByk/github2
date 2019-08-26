package com.cni.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.ILigneCommandeDAO;
import com.cni.stock.model.LigneCommande;



@Service("ligneCommandeService")
@Transactional(readOnly = true)
public class LigneCommandeService implements ILigneCommandeService {

	ILigneCommandeDAO ligneCommandeDAO;
	
	
	@Transactional(readOnly = false)
	@Override
	public void addLigneCommande(LigneCommande ligneCommande) {
		getLigneCommandeDAO().addLigneCommande(ligneCommande);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateLigneCommande(LigneCommande ligneCommande) {
		getLigneCommandeDAO().updateLigneCommande(ligneCommande);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteLigneCommande(LigneCommande ligneCommande) {
		getLigneCommandeDAO().deleteLigneCommande(ligneCommande);
	}

	@Override
	public LigneCommande findById(int id) {
		return getLigneCommandeDAO().findById(id);
	}

	@Override
	public List<LigneCommande> findAll() {
		System.out.println("findAll DAO");
		return getLigneCommandeDAO().findAll();
	}
	
	@Override
	public List<LigneCommande> findAllAchat() {
		System.out.println("findAll DAO");
		return getLigneCommandeDAO().findAllAchat();
	}
	
	@Override
	public List<LigneCommande> findAllAjout() {
		System.out.println("findAll DAO");
		return getLigneCommandeDAO().findAllAjout();
	}
	
	@Override
	public List<LigneCommande> findAllRetrait() {
		System.out.println("findAll DAO");
		return getLigneCommandeDAO().findAllRetrait();
	}
	
	public ILigneCommandeDAO getLigneCommandeDAO() {
		return ligneCommandeDAO;
	}
	
	public void setLigneCommandeDAO(ILigneCommandeDAO ligneCommandeDAO) {
		this.ligneCommandeDAO = ligneCommandeDAO;
	}
	
}
