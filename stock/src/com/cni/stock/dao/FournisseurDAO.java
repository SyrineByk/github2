package com.cni.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.Fournisseur;

public class FournisseurDAO implements IFournisseurDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addFournisseur(Fournisseur fournisseur) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(fournisseur);
		tx.commit();
		session.close();
	}

	@Override
	public void updateFournisseur(Fournisseur fournisseur) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(fournisseur);
		tx.commit();
		session.close();		
	}

	@Override
	public void deleteFournisseur(Fournisseur fournisseur) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(fournisseur);
		tx.commit();
		session.close();		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Fournisseur findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Fournisseur where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();		
		return (Fournisseur)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fournisseur> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Fournisseur> list = session
				.createQuery("from Fournisseur").list();
		tx.commit();
		session.close();		
		return list;
	}

}
