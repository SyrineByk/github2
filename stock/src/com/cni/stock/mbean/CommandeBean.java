package com.cni.stock.mbean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.Commande;
import com.cni.stock.model.Fournisseur;
import com.cni.stock.service.ICommandeService;

@ManagedBean(name = "commandeBean")
@ViewScoped
public class CommandeBean {
	@ManagedProperty(value = "#{CommandeService}")
	ICommandeService commandeService;
	
	private Integer idFournisseur;
	private String type;
	private Date jour;
	private String libJour;
	private String description;
	
	private List<Commande> commandeList;
	
	private Commande selectedCommandeDisplay;
	private Commande selectedCommandeDelete;
	private Commande selectedCommandeUpdate;
	private Commande selectedCommandeAdd;

	public CommandeBean() {
		this.selectedCommandeDisplay = new Commande();
		this.selectedCommandeDelete = new Commande();
		this.selectedCommandeUpdate = new Commande();
		this.selectedCommandeAdd = new Commande();
	}

	@PostConstruct
	public void init() {
		if (getCommandeService() != null)
			commandeList = getCommandeService().findAll();
	}

	public ICommandeService getCommandeService() {
		return commandeService;
	}

	public void setCommandeService(ICommandeService commandeService) {
		this.commandeService = commandeService;
	}

	public Integer getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Integer idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public String getLibJour() {
		return libJour;
	}

	public void setLibJour(String libJour) {
		this.libJour = libJour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Commande> getCommandeList() {
		return commandeList;
	}

	public void setCommandeList(List<Commande> commandeList) {
		this.commandeList = commandeList;
	}

	
	public Commande getSelectedCommandeDisplay() {
		return selectedCommandeDisplay;
	}

	public void setSelectedCommandeDisplay(Commande selectedCommandeDisplay) {
		this.selectedCommandeDisplay = selectedCommandeDisplay;
	}

	public Commande getSelectedCommandeDelete() {
		return selectedCommandeDelete;
	}

	public void setSelectedCommandeDelete(Commande selectedCommandeDelete) {
		this.selectedCommandeDelete = selectedCommandeDelete;
	}

	public Commande getSelectedCommandeUpdate() {
		return selectedCommandeUpdate;
	}

	public void setSelectedCommandeUpdate(Commande selectedCommandeUpdate) {
		this.selectedCommandeUpdate = selectedCommandeUpdate;
	}

	public Commande getSelectedCommandeAdd() {
		return selectedCommandeAdd;
	}

	public void setSelectedCommandeAdd(Commande selectedCommandeAdd) {
		this.selectedCommandeAdd = selectedCommandeAdd;
	}

	public void deleteCommande() {
		System.out.println("fonction deleteCommandeBean begin");
		boolean error = true;
		try {
			getCommandeService().deleteCommande(selectedCommandeDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteCommandeBean end");
	}
	
	public void deleteCommande(Commande commande) {
		System.out.println("fonction deleteCommandeBean begin");
		boolean error = true;
		try {
			getCommandeService().deleteCommande(commande);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteCommandeBean end");
	}

	public void updateCommande() {
		System.out.println("fonction updateBean begin");
		try {
			getCommandeService().updateCommande(selectedCommandeUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}
	
	public void updateCommande(Commande commande) {
		System.out.println("fonction updateBean begin");
		try {
			getCommandeService().updateCommande(commande);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addCommande() {
		System.out.println("fonction addBean begin");
		try {
			getCommandeService().addCommande(selectedCommandeAdd);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

	public void addCommande(Commande commande) {
		System.out.println("fonction addBean begin");
		try {
			getCommandeService().addCommande(commande);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}
}
