package com.cni.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.Commande;
import com.cni.stock.model.Fournisseur;
import com.cni.stock.model.Produit;
import com.cni.stock.model.Vendre;

public class VendreDAO implements IVendreDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addVendre(Vendre vendre) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.createSQLQuery("insert into Vendre (id_produit,id_fournisseur,prix) values (?,?,?)")
		.setParameter(0, vendre.getProduit().getIdProduit())
		.setParameter(1, vendre.getFournisseur().getIdFournisseur())
		.setParameter(2, vendre.getPrix()).executeUpdate();
		tx.commit();
		session.close();	
	}

	@Override
	public void updateVendre(Vendre vendre) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(vendre);
		tx.commit();
		session.close();		
	}

	@Override
	public void deleteVendre(Vendre vendre) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(vendre);
		tx.commit();
		session.close();		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Vendre findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Vendre where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();		
		return (Vendre)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendre> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Vendre> list = session
				.createQuery("from Vendre").list();
		tx.commit();
		session.close();		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendre> getVendreListByFournisseur(Fournisseur fournisseur){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Vendre> list = session
				.createQuery("from Vendre where fournisseur = ?").setParameter(0, fournisseur).list();
		tx.commit();
		session.close();		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getOtherProduitByFournisseur(Fournisseur fournisseur){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Produit> list = session
				.createQuery("from Produit").list();
		tx.commit(); 
		session.close();		
		return list;
	}
	
	@Override
	public Vendre findByProduitFournisseur(Produit produit,
			Fournisseur fournisseur) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Vendre where produit=? and fournisseur=?")
				.setParameter(0, produit).setParameter(1, fournisseur).list();
		tx.commit();
		session.close();
		if((Vendre)list.get(0)!=null){
			return (Vendre)list.get(0);
		}else{
			return null;
		}
	}
}
