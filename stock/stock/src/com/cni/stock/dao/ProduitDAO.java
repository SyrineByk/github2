package com.cni.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.Fournisseur;
import com.cni.stock.model.Produit;
import com.cni.stock.model.Vendre;

public class ProduitDAO implements IProduitDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addProduit(Produit produit) {
		produit.setStock(0);
		produit.setPrix(0);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(produit);
		tx.commit();
		session.close();
	}

	@Override
	public void updateProduit(Produit produit) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(produit);
		tx.commit();
		session.close();
		
	}
	
	@Override
	public void deleteProduit(Produit produit) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(produit);
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Produit findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Produit where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();		
		return (Produit)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Produit> list = session
				.createQuery("from Produit").list();
		tx.commit();
		session.close();		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> findProduitByFournisseur(Fournisseur fournisseur) {
		System.out.println("setProduitByFournisseurDAO begin");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Produit> list = session
				.createQuery("select p from Produit p , Vendre v where p = v.produit and v.fournisseur = ?")
				.setParameter(0, fournisseur).list();
		tx.commit();
		session.close();		
		return list;
	}

	@Override
	public void incrementStock(Produit produit, int nbre) {
		Integer newStock = produit.getStock() + nbre;
		produit.setStock(newStock);
		updateProduit(produit);		
	}
	
	@Override
	public void decrementStock(Produit produit, int nbre) {
		Integer newStock = produit.getStock() - nbre;
		produit.setStock(new Integer(newStock));
		updateProduit(produit);
	}
	
}
