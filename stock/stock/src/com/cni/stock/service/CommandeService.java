package com.cni.stock.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.ICommandeDAO;
import com.cni.stock.model.Commande;
import com.cni.stock.model.Fournisseur;



@Service("commandeService")
@Transactional(readOnly = true)
public class CommandeService implements ICommandeService {

	ICommandeDAO commandeDAO;
	
	
	@Transactional(readOnly = false)
	@Override
	public void addCommande(Commande commande) {
		getCommandeDAO().addCommande(commande);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateCommande(Commande commande) {
		getCommandeDAO().updateCommande(commande);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteCommande(Commande commande) {
		getCommandeDAO().deleteCommande(commande);
	}

	@Override
	public Commande findById(int id) {
		return getCommandeDAO().findById(id);
	}

	@Override
	public List<Commande> findAll() {
		System.out.println("findAll service");
		return getCommandeDAO().findAll();
	}
	
	public ICommandeDAO getCommandeDAO() {
		return commandeDAO;
	}
	
	public void setCommandeDAO(ICommandeDAO commandeDAO) {
		this.commandeDAO = commandeDAO;
	}

	@Override
	public Commande findCommandeByDateFournisseur(Date jour, Fournisseur fournisseur) {
		return getCommandeDAO().findCommandeByDateFournisseur(jour, fournisseur);
	}

	@Override
	public Commande findCommandeByDateAjout(Date jour) {
		return getCommandeDAO().findCommandeByDateAjout(jour);
	}

	@Override
	public Commande findCommandeByDateRetrait(Date jour) {
		return getCommandeDAO().findCommandeByDateRetrait(jour);
	}
	
}
