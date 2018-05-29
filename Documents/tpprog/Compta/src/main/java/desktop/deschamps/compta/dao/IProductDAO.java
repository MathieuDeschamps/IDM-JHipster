package desktop.deschamps.compta.dao;

import desktop.deschamps.compta.entities.Product;
import desktop.deschamps.compta.entities.Stock;

public interface IProductDAO extends DAO{
	
	/**
	 * 
	 * @param stock the stock we wanna store
	 */
	public void store(Product product);
	
	/**
	 * Remove a Stock from the db
	 * 
	 * @param stock the stock to remove
	 */
	public void remove(Product product);
	
	/**
	 * 
	 * 
	 * @param id
	 * @return The Stock with id :id if exist null otherwise
	 */
	public Product finbyId(int id);
	
	

}
