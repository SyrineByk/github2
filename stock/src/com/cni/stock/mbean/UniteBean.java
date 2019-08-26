package com.cni.stock.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.Unite;
import com.cni.stock.service.IProduitService;
import com.cni.stock.service.IUniteService;

@ManagedBean(name = "uniteBean")
@ViewScoped
public class UniteBean {
	@ManagedProperty(value = "#{UniteService}")
	IUniteService uniteService;
	@ManagedProperty(value = "#{ProduitService}")
	IProduitService produitService;
	
	private List<Unite> uniteList;
	private List<Unite> selectedUniteList;

	private Unite selectedUniteDisplay;
	private Unite selectedUniteDelete;
	private Unite selectedUniteUpdate;
	private Unite selectedUniteAdd;

	public UniteBean() {
		this.selectedUniteDisplay = new Unite();
		this.selectedUniteDelete = new Unite();
		this.selectedUniteUpdate = new Unite();
		this.selectedUniteAdd = new Unite();
	}

	@PostConstruct
	public void init() {
		if (getUniteService() != null)
			uniteList = getUniteService().findAll();
	}
	
	public IUniteService getUniteService() {
		return uniteService;
	}

	public void setUniteService(IUniteService uniteService) {
		this.uniteService = uniteService;
	}

	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	public List<Unite> getUniteList() {
		return uniteList;
	}

	public void setUniteList(List<Unite> uniteList) {
		this.uniteList = uniteList;
	}

	public List<Unite> getSelectedUniteList() {
		return selectedUniteList;
	}

	public void setSelectedUniteList(List<Unite> selectedUniteList) {
		this.selectedUniteList = selectedUniteList;
	}

	public Unite getSelectedUniteDisplay() {
		return selectedUniteDisplay;
	}

	public void setSelectedUniteDisplay(Unite selectedUniteDisplay) {
		this.selectedUniteDisplay = selectedUniteDisplay;
	}

	public Unite getSelectedUniteDelete() {
		return selectedUniteDelete;
	}

	public void setSelectedUniteDelete(Unite selectedUniteDelete) {
		this.selectedUniteDelete = selectedUniteDelete;
	}

	public Unite getSelectedUniteUpdate() {
		return selectedUniteUpdate;
	}

	public void setSelectedUniteUpdate(Unite selectedUniteUpdate) {
		this.selectedUniteUpdate = selectedUniteUpdate;
	}

	public Unite getSelectedUniteAdd() {
		return selectedUniteAdd;
	}

	public void setSelectedUniteAdd(Unite selectedUniteAdd) {
		this.selectedUniteAdd = selectedUniteAdd;
	}

	public void deleteUnite() {
		System.out.println("fonction deleteUniteBean begin");
		boolean error = true;
		try {
			getUniteService().deleteUnite(selectedUniteDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteUniteBean end");
	}

	public void updateUnite() {
		System.out.println("fonction updateBean begin");
		try {
			getUniteService().updateUnite(selectedUniteUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addUnite() {
		System.out.println("fonction addBean begin");
		try {
			getUniteService().addUnite(selectedUniteAdd);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

}
