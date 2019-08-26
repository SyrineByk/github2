package com.cni.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.Utilisateur;

public class UtilisateurDAO implements IUtilisateurDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addUtilisateur(Utilisateur utilisateur) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(utilisateur);
		tx.commit();
		session.close();
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(utilisateur);
		tx.commit();
		session.close();		
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(utilisateur);
		tx.commit();
		session.close();		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Utilisateur findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Utilisateur where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();		
		return (Utilisateur)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Utilisateur> list = session
				.createQuery("from Utilisateur").list();
		tx.commit();
		session.close();		
		return list;
	}

}
