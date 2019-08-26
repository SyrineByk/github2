package com.cni.stock.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.Invite;
import com.cni.stock.service.IInviteService;

@ManagedBean(name = "inviteBean")
@ViewScoped
public class InviteBean {
	@ManagedProperty(value = "#{InviteService}")
	IInviteService inviteService;
	
	private List<Invite> inviteList;
	private List<Invite> selectedInviteList;

	private Invite selectedInviteDisplay;
	private Invite selectedInviteDelete;
	private Invite selectedInviteUpdate;
	private Invite selectedInviteAdd;

	public InviteBean() {
		this.selectedInviteDisplay = new Invite();
		this.selectedInviteDelete = new Invite();
		this.selectedInviteUpdate = new Invite();
		this.selectedInviteAdd = new Invite();
	}

	@PostConstruct
	public void init() {
		if (getInviteService() != null)
			inviteList = getInviteService().findAll();
	}

	public IInviteService getInviteService() {
		return inviteService;
	}

	public void setInviteService(IInviteService inviteService) {
		this.inviteService = inviteService;
	}

	public List<Invite> getInviteList() {
		return inviteList;
	}

	public void setInviteList(List<Invite> inviteList) {
		this.inviteList = inviteList;
	}

	public List<Invite> getSelectedInviteList() {
		return selectedInviteList;
	}

	public void setSelectedInviteList(List<Invite> selectedInviteList) {
		this.selectedInviteList = selectedInviteList;
	}

	public Invite getSelectedInviteDisplay() {
		return selectedInviteDisplay;
	}

	public void setSelectedInviteDisplay(Invite selectedInviteDisplay) {
		this.selectedInviteDisplay = selectedInviteDisplay;
	}

	public Invite getSelectedInviteDelete() {
		return selectedInviteDelete;
	}

	public void setSelectedInviteDelete(Invite selectedInviteDelete) {
		this.selectedInviteDelete = selectedInviteDelete;
	}

	public Invite getSelectedInviteUpdate() {
		return selectedInviteUpdate;
	}

	public void setSelectedInviteUpdate(Invite selectedInviteUpdate) {
		this.selectedInviteUpdate = selectedInviteUpdate;
	}

	public Invite getSelectedInviteAdd() {
		return selectedInviteAdd;
	}

	public void setSelectedInviteAdd(Invite selectedInviteAdd) {
		this.selectedInviteAdd = selectedInviteAdd;
	}

	public void deleteInvite() {
		System.out.println("fonction deleteInviteBean begin");
		boolean error = true;
		try {
			getInviteService().deleteInvite(selectedInviteDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteInviteBean end");
	}

	public void updateInvite() {
		System.out.println("fonction updateBean begin");
		try {
			getInviteService().updateInvite(selectedInviteUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addInvite() {
		System.out.println("fonction addBean begin");
		try {
			getInviteService().addInvite(selectedInviteAdd);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

}
