package com.cni.stock.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.Parametre;
import com.cni.stock.service.IParametreService;

@ManagedBean(name = "parametreBean")
@ViewScoped
public class ParametreBean {
	@ManagedProperty(value = "#{ParametreService}")
	IParametreService parametreService;
	
	private List<Parametre> parametreList;
	private List<Parametre> selectedParametreList;

	private Parametre selectedParametreDisplay;
	private Parametre selectedParametreDelete;
	private Parametre selectedParametreUpdate;
	private Parametre selectedParametreAdd;

	public ParametreBean() {
		this.selectedParametreDisplay = new Parametre();
		this.selectedParametreDelete = new Parametre();
		this.selectedParametreUpdate = new Parametre();
		this.selectedParametreAdd = new Parametre();
	}

	@PostConstruct
	public void init() {
		if (getParametreService() != null)
			parametreList = getParametreService().findAll();
	}

	public IParametreService getParametreService() {
		return parametreService;
	}

	public void setParametreService(IParametreService parametreService) {
		this.parametreService = parametreService;
	}

	public List<Parametre> getParametreList() {
		return parametreList;
	}

	public void setParametreList(List<Parametre> parametreList) {
		this.parametreList = parametreList;
	}

	public List<Parametre> getSelectedParametreList() {
		return selectedParametreList;
	}

	public void setSelectedParametreList(List<Parametre> selectedParametreList) {
		this.selectedParametreList = selectedParametreList;
	}

	public Parametre getSelectedParametreDisplay() {
		return selectedParametreDisplay;
	}

	public void setSelectedParametreDisplay(Parametre selectedParametreDisplay) {
		this.selectedParametreDisplay = selectedParametreDisplay;
	}

	public Parametre getSelectedParametreDelete() {
		return selectedParametreDelete;
	}

	public void setSelectedParametreDelete(Parametre selectedParametreDelete) {
		this.selectedParametreDelete = selectedParametreDelete;
	}

	public Parametre getSelectedParametreUpdate() {
		return selectedParametreUpdate;
	}

	public void setSelectedParametreUpdate(Parametre selectedParametreUpdate) {
		this.selectedParametreUpdate = selectedParametreUpdate;
	}

	public Parametre getSelectedParametreAdd() {
		return selectedParametreAdd;
	}

	public void setSelectedParametreAdd(Parametre selectedParametreAdd) {
		this.selectedParametreAdd = selectedParametreAdd;
	}

	public void deleteParametre() {
		System.out.println("fonction deleteParametreBean begin");
		boolean error = true;
		try {
			getParametreService().deleteParametre(selectedParametreDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteParametreBean end");
	}

	public void updateParametre() {
		System.out.println("fonction updateBean begin");
		try {
			getParametreService().updateParametre(selectedParametreUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addParametre() {
		System.out.println("fonction addBean begin");
		try {
			getParametreService().addParametre(selectedParametreAdd);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

}
