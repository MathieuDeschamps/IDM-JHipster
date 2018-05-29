package desktop.deschamps.compta.dao;

import java.util.List;
import org.apache.log4j.Logger;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import desktop.deschamps.compta.entities.Saisie;

public class SaisieDAO implements ISaisieDAO{

	private final Logger log = Logger.getLogger(SaisieDAO.class);
	private EntityManagerFactory emf;
	private EntityManager em;

	public SaisieDAO(){
		this.emf = Persistence.createEntityManagerFactory(DAO.ENTITY_NAME);
	}

	@Override
	public void store(Saisie saisie) {
		this. em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			em.persist(saisie);
			log.info("Saisie create");
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			log.error("Error during persistance operation");
			throw e;
		}finally{
			em.close();
		}

	}

	@Override
	public void remove(Saisie saisie) {
		EntityTransaction tx = em.getTransaction();
		this. em = emf.createEntityManager();

		try{
			tx.begin();
			em.refresh(saisie);
			log.info("Saisie id: "+saisie.getId()+" removed");


		}catch(Exception e){
			tx.rollback();
			log.error("Error during remove operation for saisie id: "+saisie.getId());
		}finally{

			em.close();

		}
	}

	@Override
	public Saisie finbyId(int id) {
		this. em = emf.createEntityManager();
		Saisie saisie = em.find(Saisie.class, id);

		if(saisie!= null){
			log.info("Saisie of id: "+id+" found");
		}else{
			log.info("Saisie of id: "+id+"does not exist");
		}
		return saisie;

	}

	@Override
	public List<Saisie> findByMonth(int month) {
		// TODO Auto-generated method stub
		return null;
	}

}
