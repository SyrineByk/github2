package com.cni.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cni.stock.dao.IInviteDAO;
import com.cni.stock.model.Invite;



@Service("inviteService")
@Transactional(readOnly = true)
public class InviteService implements IInviteService {

	IInviteDAO inviteDAO;
	
	
	@Transactional(readOnly = false)
	@Override
	public void addInvite(Invite invite) {
		getInviteDAO().addInvite(invite);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateInvite(Invite invite) {
		getInviteDAO().updateInvite(invite);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteInvite(Invite invite) {
		getInviteDAO().deleteInvite(invite);
	}

	@Override
	public Invite findById(int id) {
		return getInviteDAO().findById(id);
	}

	@Override
	public List<Invite> findAll() {
		return getInviteDAO().findAll();
	}
	
	public IInviteDAO getInviteDAO() {
		return inviteDAO;
	}
	
	public void setInviteDAO(IInviteDAO inviteDAO) {
		this.inviteDAO = inviteDAO;
	}
	
}
