package desktop.deschamps.compta.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import desktop.deschamps.compta.entities.Product;

public class ProductDAO implements IProductDAO{

	private Logger log = Logger.getLogger(this.getClass());
	private EntityManagerFactory emf;
	private EntityManager em;

	public ProductDAO() {
		emf = Persistence.createEntityManagerFactory(DAO.ENTITY_NAME);
	}
	@Override
	public void store(Product product) {
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{

			tx.begin();
			em.merge(product);
			log.info("New product "+product.getName()+" created");
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			log.error("Error during store operation of product");

		}finally{
			em.close();
		}

	}

	@Override
	public void remove(Product product) {

		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try{
			tx.begin();
			em.remove(product);
			log.info("Stock id: "+product.getId()+" has been removed");
		}catch(Exception e){

			log.error("Error during remove operation on product id: "+product.getId());
			tx.rollback();

		}finally{
			em.close();
		}

	}

	@Override
	public Product finbyId(int id) {

		em = emf.createEntityManager();
		Product product = em.find(Product.class, id);

		return product;
	}

}
