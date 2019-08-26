package com.cni.stock.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.Facture;
import com.cni.stock.service.IFactureService;
import com.cni.stock.service.IFournisseurService;

@ManagedBean(name = "factureBean")
@ViewScoped
public class FactureBean {
	@ManagedProperty(value = "#{FactureService}")
	IFactureService factureService;
	@ManagedProperty(value = "#{FournisseurService}")
	IFournisseurService fournisseurService;

	private List<Facture> factureList;
	private List<Facture> selectedFactureList;

	private Facture selectedFactureDisplay;
	private Facture selectedFactureDelete;
	private Facture selectedFactureUpdate;
	private Facture selectedFactureAdd;

	public FactureBean() {
		this.selectedFactureDisplay = new Facture();
		this.selectedFactureDelete = new Facture();
		this.selectedFactureUpdate = new Facture();
		this.selectedFactureAdd = new Facture();
	}

	@PostConstruct
	public void init() {
		if (getFactureService() != null)
			factureList = getFactureService().findAll();
	}

	public IFactureService getFactureService() {
		return factureService;
	}

	public void setFactureService(IFactureService factureService) {
		this.factureService = factureService;
	}

	public IFournisseurService getFournisseurService() {
		return fournisseurService;
	}

	public void setFournisseurService(IFournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}

	public List<Facture> getFactureList() {
		return factureList;
	}

	public void setFactureList(List<Facture> factureList) {
		this.factureList = factureList;
	}

	public List<Facture> getSelectedFactureList() {
		return selectedFactureList;
	}

	public void setSelectedFactureList(List<Facture> selectedFactureList) {
		this.selectedFactureList = selectedFactureList;
	}

	public Facture getSelectedFactureDisplay() {
		return selectedFactureDisplay;
	}

	public void setSelectedFactureDisplay(Facture selectedFactureDisplay) {
		this.selectedFactureDisplay = selectedFactureDisplay;
	}

	public Facture getSelectedFactureDelete() {
		return selectedFactureDelete;
	}

	public void setSelectedFactureDelete(Facture selectedFactureDelete) {
		this.selectedFactureDelete = selectedFactureDelete;
	}

	public Facture getSelectedFactureUpdate() {
		return selectedFactureUpdate;
	}

	public void setSelectedFactureUpdate(Facture selectedFactureUpdate) {
		this.selectedFactureUpdate = selectedFactureUpdate;
	}

	public Facture getSelectedFactureAdd() {
		return selectedFactureAdd;
	}

	public void setSelectedFactureAdd(Facture selectedFactureAdd) {
		this.selectedFactureAdd = selectedFactureAdd;
	}

	public void deleteFacture() {
		System.out.println("fonction deleteFactureBean begin");
		boolean error = true;
		try {
			getFactureService().deleteFacture(selectedFactureDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteFactureBean end");
	}

	public void updateFacture() {
		System.out.println("fonction updateBean begin");
		try {
			getFactureService().updateFacture(selectedFactureUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addFacture() {
		System.out.println("fonction addBean begin");
		try {
			getFactureService().addFacture(selectedFactureAdd);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

}
