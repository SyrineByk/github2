package com.cni.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.Unite;

public class UniteDAO implements IUniteDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addUnite(Unite unite) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(unite);
		tx.commit();
		session.close();		
	}

	@Override
	public void updateUnite(Unite unite) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(unite);
		tx.commit();
		session.close();		
	}

	@Override
	public void deleteUnite(Unite unite) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(unite);
		tx.commit();
		session.close();		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Unite findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Unite where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();		
		return (Unite)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Unite> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Unite> list = session
				.createQuery("from Unite").list();
		tx.commit();
		session.close();		
		return list;
	}

}
