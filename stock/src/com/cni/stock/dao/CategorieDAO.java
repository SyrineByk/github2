package com.cni.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.Categorie;

public class CategorieDAO implements ICategorieDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addCategorie(Categorie categorie) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(categorie);
		tx.commit();
		session.close();		
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(categorie);
		tx.commit();
		session.close();		
	}

	@Override
	public void deleteCategorie(Categorie categorie) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(categorie);
		tx.commit();
		session.close();		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Categorie findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Categorie where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();		
		return (Categorie)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Categorie> list = session
				.createQuery("from Categorie").list();
		tx.commit();
		session.close();		
		return list;
	}

}
