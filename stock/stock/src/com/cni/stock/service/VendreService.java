package com.cni.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.IVendreDAO;
import com.cni.stock.model.Fournisseur;
import com.cni.stock.model.Produit;
import com.cni.stock.model.Vendre;



@Service("vendreService")
@Transactional(readOnly = true)
public class VendreService implements IVendreService {

	IVendreDAO vendreDAO;
	
	
	@Transactional(readOnly = false)
	@Override
	public void addVendre(Vendre vendre) {
		getVendreDAO().addVendre(vendre);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateVendre(Vendre vendre) {
		getVendreDAO().updateVendre(vendre);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteVendre(Vendre vendre) {
		getVendreDAO().deleteVendre(vendre);
	}

	@Override
	public Vendre findById(int id) {
		return getVendreDAO().findById(id);
	}

	@Override
	public List<Vendre> findAll() {
		return getVendreDAO().findAll();
	}
	
	public IVendreDAO getVendreDAO() {
		return vendreDAO;
	}
	
	public void setVendreDAO(IVendreDAO vendreDAO) {
		this.vendreDAO = vendreDAO;
	}
	
	@Override
	public List<Vendre> getVendreListByFournisseur(Fournisseur fournisseur){
		return getVendreDAO().getVendreListByFournisseur(fournisseur);
	}

	@Override
	public Vendre findByProduitFournisseur(Produit produit,
			Fournisseur fournisseur) {
		return getVendreDAO().findByProduitFournisseur(produit, fournisseur);
	}

	@Override
	public List<Produit> getOtherProduitByFournisseur(Fournisseur fournisseur) {
		return getVendreDAO().getOtherProduitByFournisseur(fournisseur);
	}
}
