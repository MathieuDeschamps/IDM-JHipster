package desktop.deschamps.compta.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import desktop.deschamps.compta.entities.SaleProduct;


public class SaleProductDAO implements ISaleProductDAO{
	
	private Logger log = Logger.getLogger(this.getClass());
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public SaleProductDAO(){
		emf = Persistence.createEntityManagerFactory(DAO.ENTITY_NAME);
	}

	@Override
	public void store(SaleProduct saleProduct) {
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{

			tx.begin();
			em.merge(saleProduct);
			log.info("New saleproduct created");
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			log.error("Error during store operation of product");

		}finally{
			em.close();
		}


	}

	@Override
	public void remove(SaleProduct saleProduct) {
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try{
			tx.begin();
			em.remove(saleProduct);
			log.info("Stock id: "+saleProduct.getId()+" has been removed");
		}catch(Exception e){

			log.error("Error during remove operation on product id: "+saleProduct.getId());
			tx.rollback();

		}finally{
			em.close();
		}
		
	}

	@Override
	public SaleProduct finbyId(int id) {
		
		em = emf.createEntityManager();
		SaleProduct saleProduct = em.find(SaleProduct.class, id);

		return saleProduct;
	}



}
