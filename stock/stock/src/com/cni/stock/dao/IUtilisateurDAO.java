package com.cni.stock.dao;

import java.util.List;

import com.cni.stock.model.Utilisateur;

public interface IUtilisateurDAO {
	
	public void addUtilisateur(Utilisateur utilisateur);
	
	public void updateUtilisateur(Utilisateur utilisateur);
	
	public void deleteUtilisateur(Utilisateur utilisateur);
	
	public Utilisateur findById(int id);
	
	public List<Utilisateur> findAll();

}
