package com.cni.stock.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.Fournisseur;
import com.cni.stock.service.IFactureService;
import com.cni.stock.service.IFournisseurService;
import com.cni.stock.service.IVendreService;

@ManagedBean(name = "fournisseurBean")
@ViewScoped
public class FournisseurBean {
	@ManagedProperty(value = "#{FournisseurService}")
	IFournisseurService fournisseurService;
	@ManagedProperty(value = "#{VendreService}")
	IVendreService vendreService;
	@ManagedProperty(value = "#{FactureService}")
	IFactureService factureService;
	
	private List<Fournisseur> fournisseurList;
	private List<Fournisseur> selectedFournisseurList;

	private Fournisseur selectedFournisseurDisplay;
	private Fournisseur selectedFournisseurDelete;
	private Fournisseur selectedFournisseurUpdate;
	private Fournisseur selectedFournisseurAdd;

	public FournisseurBean() {
		this.selectedFournisseurDisplay = new Fournisseur();
		this.selectedFournisseurDelete = new Fournisseur();
		this.selectedFournisseurUpdate = new Fournisseur();
		this.selectedFournisseurAdd = new Fournisseur();
	}

	@PostConstruct
	public void init() {
		if (getFournisseurService() != null)
			fournisseurList = getFournisseurService().findAll();
	}

	public IFournisseurService getFournisseurService() {
		return fournisseurService;
	}

	public void setFournisseurService(IFournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}

	public IVendreService getVendreService() {
		return vendreService;
	}

	public void setVendreService(IVendreService vendreService) {
		this.vendreService = vendreService;
	}

	public IFactureService getFactureService() {
		return factureService;
	}

	public void setFactureService(IFactureService factureService) {
		this.factureService = factureService;
	}

	public List<Fournisseur> getFournisseurList() {
		return fournisseurList;
	}

	public void setFournisseurList(List<Fournisseur> fournisseurList) {
		this.fournisseurList = fournisseurList;
	}

	public List<Fournisseur> getSelectedFournisseurList() {
		return selectedFournisseurList;
	}

	public void setSelectedFournisseurList(List<Fournisseur> selectedFournisseurList) {
		this.selectedFournisseurList = selectedFournisseurList;
	}

	public Fournisseur getSelectedFournisseurDisplay() {
		return selectedFournisseurDisplay;
	}

	public void setSelectedFournisseurDisplay(Fournisseur selectedFournisseurDisplay) {
		this.selectedFournisseurDisplay = selectedFournisseurDisplay;
	}

	public Fournisseur getSelectedFournisseurDelete() {
		return selectedFournisseurDelete;
	}

	public void setSelectedFournisseurDelete(Fournisseur selectedFournisseurDelete) {
		this.selectedFournisseurDelete = selectedFournisseurDelete;
	}

	public Fournisseur getSelectedFournisseurUpdate() {
		return selectedFournisseurUpdate;
	}

	public void setSelectedFournisseurUpdate(Fournisseur selectedFournisseurUpdate) {
		this.selectedFournisseurUpdate = selectedFournisseurUpdate;
	}

	public Fournisseur getSelectedFournisseurAdd() {
		return selectedFournisseurAdd;
	}

	public void setSelectedFournisseurAdd(Fournisseur selectedFournisseurAdd) {
		this.selectedFournisseurAdd = selectedFournisseurAdd;
	}

	public void deleteFournisseur() {
		System.out.println("fonction deleteFournisseurBean begin");
		boolean error = true;
		try {
			getFournisseurService().deleteFournisseur(selectedFournisseurDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteFournisseurBean end");
	}

	public void updateFournisseur() {
		System.out.println("fonction updateBean begin");
		try {
			getFournisseurService().updateFournisseur(selectedFournisseurUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addFournisseur() {
		System.out.println("fonction addBean begin");
		try {
			getFournisseurService().addFournisseur(selectedFournisseurAdd);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

}
