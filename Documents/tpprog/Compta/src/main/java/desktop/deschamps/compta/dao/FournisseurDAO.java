package desktop.deschamps.compta.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import desktop.deschamps.compta.entities.Fournisseur;

/**
 * Implementation of the FournisseurDAO
 * @author DESCHAMPS Mathieu
 *
 */
public class FournisseurDAO implements IFournisseurDAO{

	private final Logger log = Logger.getLogger(FournisseurDAO.class);
	private EntityManagerFactory entityManagerFactory;

	public FournisseurDAO(){
		entityManagerFactory = Persistence.createEntityManagerFactory(DAO.ENTITY_NAME);
	}

	@Override
	public void store(Fournisseur fournisseur) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tx  = em.getTransaction();

		try{
			tx.begin();
			em.merge(fournisseur);
			tx.commit();
			log.info("store transaction commited");
		}catch(Exception e){
			tx.rollback();
			log.error("Error during the store, transaction is cancelled");
			throw e;

		}finally{
			em.close();
		}

	}

	@Override
	public void remove(Fournisseur fournisseur) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tx  = em.getTransaction();

		try{
			tx.begin();
			fournisseur = em.merge(fournisseur);
			em.remove(fournisseur);
			tx.commit();
			log.info("remove transaction is commited");
		}catch(Exception e){
			tx.rollback();
			log.error("An error has occured during the removal, transaction cancelled");
			throw e;
		}finally{
			em.close();
		}

	}

	@Override
	public Fournisseur findById(int id) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {

			Fournisseur fournisseur =manager.find(Fournisseur.class, id);
			log.info("found a fournisseur of id : "+ id);
			return fournisseur;
		}catch(Exception e){
			log.error("Can't find a fournisseurt with id : "+id);
			return null;

		} finally {
			manager.close();
		}
	}

	@Override
	public Fournisseur finByName(String name) {
		EntityManager em  = entityManagerFactory.createEntityManager();

		return (Fournisseur) em.createQuery(
				"SELECT f FROM Fournisseur f WHERE f.name LIKE :name")
				.setParameter("name", name).getSingleResult();
	}

}
