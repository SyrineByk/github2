package com.cni.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.Facture;

public class FactureDAO implements IFactureDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addFacture(Facture facture) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(facture);
		tx.commit();
		session.close();		
	}

	@Override
	public void updateFacture(Facture facture) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(facture);
		tx.commit();
		session.close();		
	}

	@Override
	public void deleteFacture(Facture facture) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(facture);
		tx.commit();
		session.close();		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Facture findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Facture where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();
		return (Facture)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Facture> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Facture> list = session
				.createQuery("from Facture").list();
		tx.commit();
		session.close();		
		return list;
	}

}
