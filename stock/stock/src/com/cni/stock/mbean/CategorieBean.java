package com.cni.stock.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.Categorie;
import com.cni.stock.service.ICategorieService;
import com.cni.stock.service.IProduitService;
import com.cni.stock.service.ITypeService;

@ManagedBean(name = "categorieBean")
@ViewScoped
public class CategorieBean {
	@ManagedProperty(value = "#{CategorieService}")
	ICategorieService categorieService;
	@ManagedProperty(value = "#{ProduitService}")
	IProduitService produitService;
	@ManagedProperty(value = "#{TypeService}")
	ITypeService typeService;

	private Integer idTypeAdd;
	private Integer idTypeUpdate;
	
	private List<Categorie> categorieList;
	private List<Categorie> selectedCategorieList;

	private Categorie selectedCategorieDisplay;
	private Categorie selectedCategorieDelete;
	private Categorie selectedCategorieUpdate;
	private Categorie selectedCategorieAdd;

	public CategorieBean() {
		this.selectedCategorieDisplay = new Categorie();
		this.selectedCategorieDelete = new Categorie();
		this.selectedCategorieUpdate = new Categorie();
		this.selectedCategorieAdd = new Categorie();
	}

	@PostConstruct
	public void init() {
		if (getCategorieService() != null)
			categorieList = getCategorieService().findAll();
	}

	public ICategorieService getCategorieService() {
		return categorieService;
	}

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	public ITypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(ITypeService typeService) {
		this.typeService = typeService;
	}

	public Integer getIdTypeAdd() {
		return idTypeAdd;
	}

	public void setIdTypeAdd(Integer idTypeAdd) {
		this.idTypeAdd = idTypeAdd;
	}

	public Integer getIdTypeUpdate() {
		return idTypeUpdate;
	}

	public void setIdTypeUpdate(Integer idTypeUpdate) {
		this.idTypeUpdate = idTypeUpdate;
	}

	public List<Categorie> getCategorieList() {
		return categorieList;
	}

	public void setCategorieList(List<Categorie> categorieList) {
		this.categorieList = categorieList;
	}

	public List<Categorie> getSelectedCategorieList() {
		return selectedCategorieList;
	}

	public void setSelectedCategorieList(List<Categorie> selectedCategorieList) {
		this.selectedCategorieList = selectedCategorieList;
	}

	public Categorie getSelectedCategorieDisplay() {
		return selectedCategorieDisplay;
	}

	public void setSelectedCategorieDisplay(Categorie selectedCategorieDisplay) {
		this.selectedCategorieDisplay = selectedCategorieDisplay;
	}

	public Categorie getSelectedCategorieDelete() {
		return selectedCategorieDelete;
	}

	public void setSelectedCategorieDelete(Categorie selectedCategorieDelete) {
		this.selectedCategorieDelete = selectedCategorieDelete;
	}

	public Categorie getSelectedCategorieUpdate() {
		return selectedCategorieUpdate;
	}

	public void setSelectedCategorieUpdate(Categorie selectedCategorieUpdate) {
		this.selectedCategorieUpdate = selectedCategorieUpdate;
	}

	public Categorie getSelectedCategorieAdd() {
		return selectedCategorieAdd;
	}

	public void setSelectedCategorieAdd(Categorie selectedCategorieAdd) {
		this.selectedCategorieAdd = selectedCategorieAdd;
	}

	public void deleteCategorie() {
		System.out.println("fonction deleteCategorieBean begin");
		boolean error = true;
		try {
			getCategorieService().deleteCategorie(selectedCategorieDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteCategorieBean end");
	}

	public void updateCategorie() {
		System.out.println("fonction updateBean begin");
		selectedCategorieUpdate.setType(getTypeService().findById(idTypeUpdate));
		try {
			getCategorieService().updateCategorie(selectedCategorieUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addCategorie() {
		System.out.println("fonction addBean begin");
		selectedCategorieAdd.setType(getTypeService().findById(idTypeAdd));
		try {
			getCategorieService().addCategorie(selectedCategorieAdd);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

}
