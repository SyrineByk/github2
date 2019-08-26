package com.cni.stock.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.Utilisateur;
import com.cni.stock.service.IUtilisateurService;

@ManagedBean(name = "utilisateurBean")
@ViewScoped
public class UtilisateurBean {
	@ManagedProperty(value = "#{UtilisateurService}")
	IUtilisateurService utilisateurService;
	
	private List<Utilisateur> utilisateurList;
	private List<Utilisateur> selectedUtilisateurList;

	private Utilisateur selectedUtilisateurDisplay;
	private Utilisateur selectedUtilisateurDelete;
	private Utilisateur selectedUtilisateurUpdate;
	private Utilisateur selectedUtilisateurAdd;

	public UtilisateurBean() {
		this.selectedUtilisateurDisplay = new Utilisateur();
		this.selectedUtilisateurDelete = new Utilisateur();
		this.selectedUtilisateurUpdate = new Utilisateur();
		this.selectedUtilisateurAdd = new Utilisateur();
	}

	@PostConstruct
	public void init() {
		if (getUtilisateurService() != null)
			utilisateurList = getUtilisateurService().findAll();
	}

	public IUtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateurService(IUtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public List<Utilisateur> getUtilisateurList() {
		return utilisateurList;
	}

	public void setUtilisateurList(List<Utilisateur> utilisateurList) {
		this.utilisateurList = utilisateurList;
	}

	public List<Utilisateur> getSelectedUtilisateurList() {
		return selectedUtilisateurList;
	}

	public void setSelectedUtilisateurList(List<Utilisateur> selectedUtilisateurList) {
		this.selectedUtilisateurList = selectedUtilisateurList;
	}

	public Utilisateur getSelectedUtilisateurDisplay() {
		return selectedUtilisateurDisplay;
	}

	public void setSelectedUtilisateurDisplay(Utilisateur selectedUtilisateurDisplay) {
		this.selectedUtilisateurDisplay = selectedUtilisateurDisplay;
	}

	public Utilisateur getSelectedUtilisateurDelete() {
		return selectedUtilisateurDelete;
	}

	public void setSelectedUtilisateurDelete(Utilisateur selectedUtilisateurDelete) {
		this.selectedUtilisateurDelete = selectedUtilisateurDelete;
	}

	public Utilisateur getSelectedUtilisateurUpdate() {
		return selectedUtilisateurUpdate;
	}

	public void setSelectedUtilisateurUpdate(Utilisateur selectedUtilisateurUpdate) {
		this.selectedUtilisateurUpdate = selectedUtilisateurUpdate;
	}

	public Utilisateur getSelectedUtilisateurAdd() {
		return selectedUtilisateurAdd;
	}

	public void setSelectedUtilisateurAdd(Utilisateur selectedUtilisateurAdd) {
		this.selectedUtilisateurAdd = selectedUtilisateurAdd;
	}

	public void deleteUtilisateur() {
		System.out.println("fonction deleteUtilisateurBean begin");
		boolean error = true;
		try {
			getUtilisateurService().deleteUtilisateur(selectedUtilisateurDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteUtilisateurBean end");
	}

	public void updateUtilisateur() {
		System.out.println("fonction updateBean begin");
		try {
			getUtilisateurService().updateUtilisateur(selectedUtilisateurUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addUtilisateur() {
		System.out.println("fonction addBean begin");
		try {
			getUtilisateurService().addUtilisateur(selectedUtilisateurAdd);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

}
