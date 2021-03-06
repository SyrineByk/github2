package com.cni.stock.mbean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import com.cni.stock.model.Commande;
import com.cni.stock.model.Fournisseur;
import com.cni.stock.model.LigneCommande;
import com.cni.stock.model.Produit;
import com.cni.stock.model.Vendre;
import com.cni.stock.service.ICommandeService;
import com.cni.stock.service.IFournisseurService;
import com.cni.stock.service.ILigneCommandeService;
import com.cni.stock.service.IProduitService;
import com.cni.stock.service.IVendreService;

@ManagedBean(name = "achatBean")
@ViewScoped
public class AchatBean {
	@ManagedProperty(value = "#{CommandeService}")
	ICommandeService commandeService;
	@ManagedProperty(value = "#{LigneCommandeService}")
	ILigneCommandeService ligneCommandeService;
	@ManagedProperty(value = "#{ProduitService}")
	IProduitService produitService;
	@ManagedProperty(value = "#{FournisseurService}")
	IFournisseurService fournisseurService;
	@ManagedProperty(value = "#{VendreService}")
	IVendreService vendreService;

	private String type = "Achat";
	private String libJour;
	private Date jour;
	private Integer idFournisseur;
	private String description;
	
	private Integer idProduit;
	private Integer quantite;
	private Integer prixTotal;	
	
	private Fournisseur fournisseur;
	private Produit produit;
	private Vendre vendre;
	private LigneCommande ligneCommande;
	
	private List<Commande> commandeList;
	private List<Commande> selectedCommandeList;
	private List<LigneCommande> commandeLigneCommandeList;
	private List<Produit> produitByFournisseur;
	
	private Commande selectedCommandeDisplay;
	private Commande selectedCommandeDelete;
	private Commande selectedCommandeUpdate;
	private Commande selectedCommandeAdd;

	public AchatBean() {
		this.selectedCommandeDisplay = new Commande();
		this.selectedCommandeDisplay.setType("Achat");
		this.selectedCommandeDelete = new Commande();
		this.selectedCommandeDelete.setType("Achat");
		this.selectedCommandeUpdate = new Commande();
		this.selectedCommandeUpdate.setType("Achat");
		this.selectedCommandeAdd = new Commande();
		this.selectedCommandeAdd.setType("Achat");
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

	public ILigneCommandeService getLigneCommandeService() {
		return ligneCommandeService;
	}

	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLibJour() {
		return libJour;
	}

	public void setLibJour(String libJour) {
		this.libJour = libJour;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public Integer getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Integer idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Integer getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Integer prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Vendre getVendre() {
		return vendre;
	}

	public void setVendre(Vendre vendre) {
		this.vendre = vendre;
	}

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	public List<LigneCommande> getCommandeLigneCommandeList() {
		return commandeLigneCommandeList;
	}

	public void setCommandeLigneCommandeList(
			List<LigneCommande> commandeLigneCommandeList) {
		this.commandeLigneCommandeList = commandeLigneCommandeList;
	}

	public List<Commande> getCommandeList() {
		return commandeList;
	}

	public void setCommandeList(List<Commande> commandeList) {
		this.commandeList = commandeList;
	}

	public List<Commande> getSelectedCommandeList() {
		return selectedCommandeList;
	}

	public void setSelectedCommandeList(List<Commande> selectedCommandeList) {
		this.selectedCommandeList = selectedCommandeList;
	}

	public List<Produit> getProduitByFournisseur() {
		return produitByFournisseur;
	}

	public void setProduitByFournisseur(List<Produit> produitByFournisseur) {
		this.produitByFournisseur = produitByFournisseur;
	}
	
	public void setProduitByFournisseur(Fournisseur fournisseur) {
		System.out.println("setProduitByFournisseurBean begin");
		this.produitByFournisseur = getProduitService().findProduitByFournisseur(fournisseur);
		System.out.println("setProduitByFournisseur end");
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

	public void loadProduitByFournisseur(){
		System.out.println("loadProduitByFournisseur begin");
		Fournisseur fournisseur = getFournisseurService().findById(idFournisseur);
		setProduitByFournisseur(fournisseur);
		System.out.println("loadProduitByFournisseur end");
	}
	
	public void addCommande(){	
		System.out.println("addCommande begin");
		fournisseur = getFournisseurService().findById(idFournisseur);
		Commande com = findCommandeByDateFournisseur(jour, fournisseur);
		if(com == null){
			System.out.println("Commande Null");
			Commande commande = new Commande();				
			
			commande.setType(type);
			commande.setLibJour(libJour);
			commande.setJour(jour);
			commande.setFournisseur(fournisseur);
			
			getCommandeService().addCommande(commande);	
		}
		System.out.println("addCommande end");
	}
	
	public Commande findCommandeByDateFournisseur(Date jour, Fournisseur fournisseur){
		return getCommandeService().findCommandeByDateFournisseur(jour, fournisseur); // � v�rifier
	}
		
	public void addLigneCommande(){		
		produit = getProduitService().findById(idProduit);
	    LigneCommande ligneCommande = new LigneCommande();
		ligneCommande.setCommande(findCommandeByDateFournisseur(jour,fournisseur));
		ligneCommande.setProduit(produit);
		ligneCommande.setQuantite(quantite);
		
		Vendre vendre = getVendreService().findByProduitFournisseur(produit, fournisseur);
		ligneCommande.setPrixTotal(vendre.getPrix()*quantite);
		
		getLigneCommandeService().addLigneCommande(ligneCommande);
		getProduitService().incrementStock(produit, quantite);
	}
	
	public void addFacture(){
		addCommande();		
		addLigneCommande();
	}
	
	
}
