package desktop.deschamps.compta.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import desktop.deschamps.compta.entities.Category;
import desktop.deschamps.compta.entities.SaleProduct;

public class CategoryDAO implements ICategoryDAO {
	
	private Logger log = Logger.getLogger(this.getClass());
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CategoryDAO(){
		emf = Persistence.createEntityManagerFactory(DAO.ENTITY_NAME);

	}

	@Override
	public void store(Category category) {

		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{

			tx.begin();
			em.merge(category);
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
	public void remove(Category category) {
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try{
			tx.begin();
			em.remove(category);
			log.info("Stock id: "+category.getId()+" has been removed");
		}catch(Exception e){

			log.error("Error during remove operation on product id: "+category.getId());
			tx.rollback();

		}finally{
			em.close();
		}
	}

	@Override
	public Category finbyId(int id) {
		
		em = emf.createEntityManager();
		Category category = em.find(Category.class, id);

		return category;
	}

}
