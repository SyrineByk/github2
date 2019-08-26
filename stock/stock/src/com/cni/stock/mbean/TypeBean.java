package com.cni.stock.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cni.stock.model.Type;
import com.cni.stock.service.ICategorieService;
import com.cni.stock.service.ITypeService;

@ManagedBean(name = "typeBean")
@ViewScoped
public class TypeBean {
	@ManagedProperty(value = "#{TypeService}")
	ITypeService typeService;
	@ManagedProperty(value = "#{CategorieService}")
	ICategorieService categorieService;
	
	private List<Type> typeList;
	private List<Type> selectedTypeList;

	private Type selectedTypeDisplay;
	private Type selectedTypeDelete;
	private Type selectedTypeUpdate;
	private Type selectedTypeAdd;

	public TypeBean() {
		this.selectedTypeDisplay = new Type();
		this.selectedTypeDelete = new Type();
		this.selectedTypeUpdate = new Type();
		this.selectedTypeAdd = new Type();
	}

	@PostConstruct
	public void init() {
		if (getTypeService() != null)
			typeList = getTypeService().findAll();
	}

	public ITypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(ITypeService typeService) {
		this.typeService = typeService;
	}

	public ICategorieService getCategorieService() {
		return categorieService;
	}

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	public List<Type> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}

	public List<Type> getSelectedTypeList() {
		return selectedTypeList;
	}

	public void setSelectedTypeList(List<Type> selectedTypeList) {
		this.selectedTypeList = selectedTypeList;
	}

	public Type getSelectedTypeDisplay() {
		return selectedTypeDisplay;
	}

	public void setSelectedTypeDisplay(Type selectedTypeDisplay) {
		this.selectedTypeDisplay = selectedTypeDisplay;
	}

	public Type getSelectedTypeDelete() {
		return selectedTypeDelete;
	}

	public void setSelectedTypeDelete(Type selectedTypeDelete) {
		this.selectedTypeDelete = selectedTypeDelete;
	}

	public Type getSelectedTypeUpdate() {
		return selectedTypeUpdate;
	}

	public void setSelectedTypeUpdate(Type selectedTypeUpdate) {
		this.selectedTypeUpdate = selectedTypeUpdate;
	}

	public Type getSelectedTypeAdd() {
		return selectedTypeAdd;
	}

	public void setSelectedTypeAdd(Type selectedTypeAdd) {
		this.selectedTypeAdd = selectedTypeAdd;
	}

	public void deleteType() {
		System.out.println("fonction deleteTypeBean begin");
		boolean error = true;
		try {
			getTypeService().deleteType(selectedTypeDelete);
		} catch (Exception ex) {
			error = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		if (!error) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Data deleted successfuly", "OK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction deleteTypeBean end");
	}

	public void updateType() {
		System.out.println("fonction updateBean begin");
		try {
			getTypeService().updateType(selectedTypeUpdate);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction updateBean end");
	}

	public void addType() {
		System.out.println("fonction addBean begin");
		try {
			getTypeService().addType(selectedTypeAdd);
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating data", "NOK!!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		System.out.println("fonction addBean end");
	}

}
