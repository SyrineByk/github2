package com.cni.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.Invite;

public class InviteDAO implements IInviteDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addInvite(Invite invite) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(invite);
		tx.commit();
		session.close();		
	}

	@Override
	public void updateInvite(Invite invite) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(invite);
		tx.commit();
		session.close();		
	}

	@Override
	public void deleteInvite(Invite invite) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(invite);
		tx.commit();
		session.close();		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Invite findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Invite where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();		
		return (Invite)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invite> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Invite> list = session
				.createQuery("from Invite").list();
		tx.commit();
		session.close();
		
		return list;
	}

}
