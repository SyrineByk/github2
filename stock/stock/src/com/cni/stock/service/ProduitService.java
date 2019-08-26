package com.cni.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.IProduitDAO;
import com.cni.stock.model.Fournisseur;
import com.cni.stock.model.Produit;
import com.cni.stock.model.Vendre;



@Service("produitService")
@Transactional(readOnly = true)
public class ProduitService implements IProduitService {

	IProduitDAO produitDAO;
	
	public IProduitDAO getProduitDAO() {
		return produitDAO;
	}
	
	public void setProduitDAO(IProduitDAO produitDAO) {
		this.produitDAO = produitDAO;
	}
	
	@Transactional(readOnly = false)
	@Override
	public void addProduit(Produit produit) {
		getProduitDAO().addProduit(produit);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateProduit(Produit produit) {
		getProduitDAO().updateProduit(produit);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteProduit(Produit produit) {
		getProduitDAO().deleteProduit(produit);
	}

	@Override
	public Produit findById(int id) {
		return getProduitDAO().findById(id);
	}

	@Override
	public List<Produit> findAll() {
		return getProduitDAO().findAll();
	}
	
	
	@Override
	public List<Produit> findProduitByFournisseur(Fournisseur fournisseur) {
		System.out.println("setProduitByFournisseurService begin");
		return getProduitDAO().findProduitByFournisseur(fournisseur);
	}
	
	@Override
	public void incrementStock(Produit produit, int nbre) {
		getProduitDAO().incrementStock(produit, nbre);		
	}
	
	@Override
	public void decrementStock(Produit produit, int nbre) {
		getProduitDAO().decrementStock(produit, nbre);		
	}
	
}
