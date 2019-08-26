package com.cni.stock.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.LigneCommande;
import com.cni.stock.service.ICommandeService;
import com.cni.stock.service.ILigneCommandeService;
import com.cni.stock.service.IProduitService;

@ManagedBean(name = "ligneCommandeBean")
@ViewScoped
public class LigneCommandeBean {
	@ManagedProperty(value = "#{LigneCommandeService}")
	ILigneCommandeService ligneCommandeService;
	@ManagedProperty(value = "#{CommandeService}")
	ICommandeService commandeService;
	@ManagedProperty(value = "#{ProduitService}")
	IProduitService produitService;
	
	private Integer idProduit;
	private Integer idFournisseur;
	private Integer quantite;
	private Integer prixTotal;
	
	private List<LigneCommande> ligneCommandeList;
	private List<LigneCommande> ligneCommandeListAchat;
	private List<LigneCommande> ligneCommandeListAjout;
	private List<LigneCommande> ligneCommandeListRetrait;
	private List<LigneCommande> commandeLigneCommandeList;
	
	private LigneCommande selectedLigneCommandeDisplay;
	private LigneCommande selectedLigneCommandeDelete;
	private LigneCommande selectedLigneCommandeUpdate;
	private LigneCommande selectedLigneCommandeAdd;

	public LigneCommandeBean() {
		this.selectedLigneCommandeDisplay = new LigneCommande();
		this.selectedLigneCommandeDelete = new LigneCommande();
		this.selectedLigneCommandeUpdate = new LigneCommande();
		this.selectedLigneCommandeAdd = new LigneCommande();
	}

	@PostConstruct
	public void init() {
		if (getLigneCommandeService() != null){
			ligneCommandeList = getLigneCommandeService().findAll();
			ligneCommandeListAchat = getLigneCommandeService().findAllAchat();
			ligneCommandeListAjout = getLigneCommandeService().findAllAjout();
			ligneCommandeListRetrait = getLigneCommandeService().findAllRetrait();
		}
	}

	public ILigneCommandeService getLigneCommandeService() {
		return ligneCommandeService;
	}

	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	public ICommandeService getCommandeService() {
		return commandeService;
	}

	public void setCommandeService(ICommandeService commandeService) {
		this.commandeService = commandeService;
	}

	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	public Integer getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Integer idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Integer getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Integer prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

	public List<LigneCommande> getLigneCommandeList() {
		return ligneCommandeList;
	}

	public void setLigneCommandeList(List<LigneCommande> ligneCommandeList) {
		this.ligneCommandeList = ligneCommandeList;
	}

	
	public List<LigneCommande> getLigneCommandeListAchat() {
		return ligneCommandeListAchat;
	}

	public void setLigneCommandeListAchat(List<LigneCommande> ligneCommandeListAchat) {
		this.ligneCommandeListAchat = ligneCommandeListAchat;
	}

	public List<LigneCommande> getLigneCommandeListAjout() {
		return ligneCommandeListAjout;
	}

	public void setLigneCommandeListAjout(List<LigneCommande> ligneCommandeListAjout) {
		this.ligneCommandeListAjout = ligneCommandeListAjout;
	}

	public List<LigneCommande> getLigneCommandeListRetrait() {
		return ligneCommandeListRetrait;
	}

	public void setLigneCommandeListRetrait(
			List<LigneCommande> ligneCommandeListRetrait) {
		this.ligneCommandeListRetrait = ligneCommandeListRetrait;
	}

	public List<LigneCommande> getCommandeLigneCommandeList() {
		return commandeLigneCommandeList;
	}

	public void setCommandeLigneCommandeList(
			List<LigneCommande> commandeLigneCommandeList) {
		this.commandeLigneCommandeList = commandeLigneCommandeList;
	}

	public LigneCommande getSelectedLigneCommandeDisplay() {
		return selectedLigneCommandeDisplay;
	}

	public void setSelectedLigneCommandeDisplay(LigneCommande selectedLigneCommandeDisplay) {
		this.selectedLigneCommandeDisplay = selectedLigneCommandeDisplay;
	}

	public LigneCommande getSelectedLigneCommandeDelete() {
		return selectedLigneCommandeDelete;
	}

	public void setSelectedLigneCommandeDelete(LigneCommande selectedLigneCommandeDelete) {
		this.selectedLigneCommandeDelete = selectedLigneCommandeDelete;
	}

	public LigneCommande getSelectedLigneCommandeUpdate() {
		return selectedLigneCommandeUpdate;
	}

	public void setSelectedLigneCommandeUpdate(LigneCommande selectedLigneCommandeUpdate) {
		this.selectedLigneCommandeUpdate = selectedLigneCommandeUpdate;
	}

	public LigneCommande getSelectedLigneCommandeAdd() {
		return selectedLigneCommandeAdd;
	}

	public void setSelectedLigneCommandeAdd(LigneCommande selectedLigneCommandeAdd) {
		this.selectedLigneCommandeAdd = selectedLigneCommandeAdd;
	}

	public void deleteLigneCommande() {
		System.out.println("fonction deleteLigneCommandeBean begin");
		boolean error = true;
		try {
			getLigneCommandeService().deleteLigneCommande(selectedLigneCommandeDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteLigneCommandeBean end");
	}

	public void updateLigneCommande() {
		System.out.println("fonction updateBean begin");
		try {
			getLigneCommandeService().updateLigneCommande(selectedLigneCommandeUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addLigneCommande() {
		System.out.println("fonction addBean begin");
		try {
			getLigneCommandeService().addLigneCommande(selectedLigneCommandeAdd);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

}
