package com.cni.stock.service;

import java.util.List;

import com.cni.stock.model.Invite;

public interface IInviteService {
	
	public void addInvite(Invite invite);
	
	public void updateInvite(Invite invite);
	
	public void deleteInvite(Invite invite);
	
	public Invite findById(int id);
	
	public List<Invite> findAll();

}


