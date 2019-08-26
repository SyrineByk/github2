package com.cni.stock.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.Produit;
import com.cni.stock.service.ICategorieService;
import com.cni.stock.service.ILigneCommandeService;
import com.cni.stock.service.IProduitService;
import com.cni.stock.service.IUniteService;
import com.cni.stock.service.IVendreService;

@ManagedBean(name = "produitBean")
@ViewScoped
public class ProduitBean {
	@ManagedProperty(value = "#{ProduitService}")
	IProduitService produitService;
	@ManagedProperty(value = "#{CategorieService}")
	ICategorieService categorieService;
	@ManagedProperty(value = "#{VendreService}")
	IVendreService vendreService;
	@ManagedProperty(value = "#{LigneCommandeService}")
	ILigneCommandeService ligneCommandeService;
	@ManagedProperty(value = "#{UniteService}")
	IUniteService uniteService;
	
	private List<Produit> produitList;
	private List<Produit> selectedProduitList;

	private Integer idCategorieAdd;
	private Integer idCategorieUpdate;
	
	private Integer idUniteAdd;
	private Integer idUniteUpdate;
	
	private Produit selectedProduitDisplay;
	private Produit selectedProduitDelete;
	private Produit selectedProduitUpdate;
	private Produit selectedProduitAdd;

	public ProduitBean() {
		this.selectedProduitDisplay = new Produit();
		this.selectedProduitDelete = new Produit();
		this.selectedProduitUpdate = new Produit();
		this.selectedProduitAdd = new Produit();
	}

	@PostConstruct
	public void init() {
		if (getProduitService() != null)
			produitList = getProduitService().findAll();
	}

	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	public ICategorieService getCategorieService() {
		return categorieService;
	}

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	public IVendreService getVendreService() {
		return vendreService;
	}

	public void setVendreService(IVendreService vendreService) {
		this.vendreService = vendreService;
	}

	public ILigneCommandeService getLigneCommandeService() {
		return ligneCommandeService;
	}

	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	public IUniteService getUniteService() {
		return uniteService;
	}

	public void setUniteService(IUniteService uniteService) {
		this.uniteService = uniteService;
	}

	public Integer getIdCategorieAdd() {
		return idCategorieAdd;
	}

	public void setIdCategorieAdd(Integer idCategorieAdd) {
		this.idCategorieAdd = idCategorieAdd;
	}

	public Integer getIdCategorieUpdate() {
		return idCategorieUpdate;
	}

	public void setIdCategorieUpdate(Integer idCategorieUpdate) {
		this.idCategorieUpdate = idCategorieUpdate;
	}

	public Integer getIdUniteAdd() {
		return idUniteAdd;
	}

	public void setIdUniteAdd(Integer idUniteAdd) {
		this.idUniteAdd = idUniteAdd;
	}

	public Integer getIdUniteUpdate() {
		return idUniteUpdate;
	}

	public void setIdUniteUpdate(Integer idUniteUpdate) {
		this.idUniteUpdate = idUniteUpdate;
	}

	public List<Produit> getProduitList() {
		return produitList;
	}

	public void setProduitList(List<Produit> produitList) {
		this.produitList = produitList;
	}

	public List<Produit> getSelectedProduitList() {
		return selectedProduitList;
	}

	public void setSelectedProduitList(List<Produit> selectedProduitList) {
		this.selectedProduitList = selectedProduitList;
	}

	public Produit getSelectedProduitDisplay() {
		return selectedProduitDisplay;
	}

	public void setSelectedProduitDisplay(Produit selectedProduitDisplay) {
		this.selectedProduitDisplay = selectedProduitDisplay;
	}

	public Produit getSelectedProduitDelete() {
		return selectedProduitDelete;
	}

	public void setSelectedProduitDelete(Produit selectedProduitDelete) {
		this.selectedProduitDelete = selectedProduitDelete;
	}

	public Produit getSelectedProduitUpdate() {
		return selectedProduitUpdate;
	}

	public void setSelectedProduitUpdate(Produit selectedProduitUpdate) {
		this.selectedProduitUpdate = selectedProduitUpdate;
	}

	public Produit getSelectedProduitAdd() {
		return selectedProduitAdd;
	}

	public void setSelectedProduitAdd(Produit selectedProduitAdd) {
		this.selectedProduitAdd = selectedProduitAdd;
	}

	public void deleteProduit() {
		System.out.println("fonction deleteProduitBean begin");
		boolean error = true;
		try {
			getProduitService().deleteProduit(selectedProduitDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteProduitBean end");
	}

	public void updateProduit() {
		System.out.println("fonction updateBean begin");
		selectedProduitUpdate.setCategorie(getCategorieService().findById(idCategorieUpdate));
		try {
			getProduitService().updateProduit(selectedProduitUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addProduit() {
		System.out.println("fonction addBean begin");
		selectedProduitAdd.setCategorie(getCategorieService().findById(idCategorieAdd));
		try {
			getProduitService().addProduit(selectedProduitAdd);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

}
