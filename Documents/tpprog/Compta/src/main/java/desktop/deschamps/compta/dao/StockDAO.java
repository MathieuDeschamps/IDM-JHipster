package desktop.deschamps.compta.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

import desktop.deschamps.compta.entities.Stock;

public class StockDAO implements IStockDAO {
	
	private Logger log = Logger.getLogger(StockDAO.class);
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public StockDAO() {
		
		emf = Persistence.createEntityManagerFactory(DAO.ENTITY_NAME);
	}

	@Override
	public void store(Stock stock) {
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try{
			
			tx.begin();
			em.merge(stock);
			log.info("New stock "+stock.getName()+" created");
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			log.error("Error during store operation of Stock");
			
		}finally{
			em.close();
		}
	}

	@Override
	public void remove(Stock stock) {
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try{
			tx.begin();
			em.remove(stock);
			log.info("Stock id: "+stock.getId()+" has been removed");
		}catch(Exception e){
			
			log.error("Error during remove operation on stock id: "+stock.getId());
			tx.rollback();
			
		}finally{
			em.close();
		}
		
	}

	@Override
	public Stock finbyId(int id) {
		em = emf.createEntityManager();
		Stock stock = em.find(Stock.class, id);
				
		return stock;
	}

}
