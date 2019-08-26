package com.cni.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.IUtilisateurDAO;
import com.cni.stock.model.Utilisateur;



@Service("utilisateurService")
@Transactional(readOnly = true)
public class UtilisateurService implements IUtilisateurService {

	IUtilisateurDAO utilisateurDAO;
	
	
	@Transactional(readOnly = false)
	@Override
	public void addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurDAO().addUtilisateur(utilisateur);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		getUtilisateurDAO().updateUtilisateur(utilisateur);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		getUtilisateurDAO().deleteUtilisateur(utilisateur);
	}

	@Override
	public Utilisateur findById(int id) {
		return getUtilisateurDAO().findById(id);
	}

	@Override
	public List<Utilisateur> findAll() {
		return getUtilisateurDAO().findAll();
	}
	
	public IUtilisateurDAO getUtilisateurDAO() {
		return utilisateurDAO;
	}
	
	public void setUtilisateurDAO(IUtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}
	
}
