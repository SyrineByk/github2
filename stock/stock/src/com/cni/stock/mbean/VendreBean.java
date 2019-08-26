package com.cni.stock.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.Fournisseur;
import com.cni.stock.model.Produit;
import com.cni.stock.model.Vendre;
import com.cni.stock.service.IFournisseurService;
import com.cni.stock.service.IParametreService;
import com.cni.stock.service.IVendreService;
import com.cni.stock.service.IProduitService;

@ManagedBean(name = "vendreBean")
@ViewScoped
public class VendreBean {
	@ManagedProperty(value = "#{VendreService}")
	IVendreService vendreService;
	@ManagedProperty(value = "#{ProduitService}")
	IProduitService produitService;
	@ManagedProperty(value = "#{FournisseurService}")
	IFournisseurService fournisseurService;
	@ManagedProperty(value = "#{ParametreService}")
	IParametreService parametreService;
	
	private Integer idFournisseur;
	private Integer idProduit;
	private Integer prix;
	
	private Vendre vendre;
	private Fournisseur fournisseur;
	
	private List<Vendre> vendreList;
	private List<Vendre> fournisseurProduitList = new ArrayList<Vendre>();
	//private List<Produit> otherProduitList = new ArrayList<Produit>();
	private List<Vendre> selectedVendreList; 
	
	private Vendre selectedVendreDisplay;
	private Vendre selectedVendreDelete;
	private Vendre selectedVendreUpdate;
	private Vendre selectedVendreAdd;

	public VendreBean() {
		this.selectedVendreDisplay = new Vendre();
		this.selectedVendreDelete = new Vendre();
		this.selectedVendreUpdate = new Vendre();
		this.selectedVendreAdd = new Vendre();	
		
	}

	@PostConstruct
	public void init() {
		if (getVendreService() != null)
			vendreList = getVendreService().findAll();		
	}

	public IVendreService getVendreService() {
		return vendreService;
	}

	public void setVendreService(IVendreService vendreService) {
		this.vendreService = vendreService;
	}

	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	public IFournisseurService getFournisseurService() {
		return fournisseurService;
	}

	public void setFournisseurService(IFournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}

	public IParametreService getParametreService() {
		return parametreService;
	}

	public void setParametreService(IParametreService parametreService) {
		this.parametreService = parametreService;
	}

	public Integer getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Integer idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Vendre getVendre() {
		return vendre;
	}

	public void setVendre(Vendre vendre) {
		this.vendre = vendre;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<Vendre> getVendreList() {
		return vendreList;
	}

	public void setVendreList(List<Vendre> vendreList) {
		this.vendreList = vendreList;
	}

	public List<Vendre> getFournisseurProduitList() {
		return fournisseurProduitList;
	}

	public void setFournisseurProduitList(List<Vendre> fournisseurProduitList) {
		this.fournisseurProduitList = fournisseurProduitList;
	}

//	public List<Produit> getOtherProduitList() {
//		return otherProduitList;
//	}
//
//	public void setOtherProduitList(List<Produit> otherProduitList) {
//		this.otherProduitList = otherProduitList;
//	}

	public List<Vendre> getSelectedVendreList() {
		return selectedVendreList;
	}

	public void setSelectedVendreList(List<Vendre> selectedVendreList) {
		this.selectedVendreList = selectedVendreList;
	}

	public Vendre getSelectedVendreDisplay() {
		return selectedVendreDisplay;
	}

	public void setSelectedVendreDisplay(Vendre selectedVendreDisplay) {
		this.selectedVendreDisplay = selectedVendreDisplay;
	}

	public Vendre getSelectedVendreDelete() {
		return selectedVendreDelete;
	}

	public void setSelectedVendreDelete(Vendre selectedVendreDelete) {
		this.selectedVendreDelete = selectedVendreDelete;
	}

	public Vendre getSelectedVendreUpdate() {
		return selectedVendreUpdate;
	}

	public void setSelectedVendreUpdate(Vendre selectedVendreUpdate) {
		this.selectedVendreUpdate = selectedVendreUpdate;
	}

	public Vendre getSelectedVendreAdd() {
		return selectedVendreAdd;
	}

	public void setSelectedVendreAdd(Vendre selectedVendreAdd) {
		this.selectedVendreAdd = selectedVendreAdd;
	}

	public void deleteVendre() {
		System.out.println("fonction deleteVendreBean begin");
		boolean error = true;
		try {
			getVendreService().deleteVendre(selectedVendreDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteVendreBean end");
	}

	public void updateVendre() {
		System.out.println("fonction updateBean begin");
		try {
			getVendreService().updateVendre(selectedVendreUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addVendre() {
		Vendre vendre = new Vendre();
		vendre.setProduit(getProduitService().findById(idProduit));
		vendre.setFournisseur(getFournisseurService().findById(idFournisseur));
		vendre.setPrix(prix);
		System.out.println("produit "+vendre.getProduit().getLibelle());
		System.out.println("fournisseur "+vendre.getFournisseur().getNom());
		System.out.println("produit "+vendre.getPrix());
		try {
			getVendreService().addVendre(vendre);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

	public void getVendreListByFournisseur(){
		fournisseur = getFournisseurService().findById(idFournisseur);
		setFournisseurProduitList(getVendreService().getVendreListByFournisseur(fournisseur));
	}
	
//	public void setOtherProduitList(){
//		fournisseur = getFournisseurService().findById(idFournisseur);
//		setOtherProduitList(getVendreService().getOtherProduitByFournisseur(fournisseur));
//	}
	
	public void fournisseurAction(){
		//setOtherProduitList();
		getVendreListByFournisseur();
	}
	
	public void addAction(){
		System.out.println("idProduit : "+getIdProduit());
		addVendre();
		getVendreListByFournisseur();
	}
}
