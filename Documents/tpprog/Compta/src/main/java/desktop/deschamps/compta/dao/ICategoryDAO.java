package desktop.deschamps.compta.dao;

import desktop.deschamps.compta.entities.Category;

public interface ICategoryDAO extends DAO{
	
	/**
	 * 
	 * @param stock the stock we wanna store
	 */
	public void store(Category category);
	
	/**
	 * Remove a Stock from the db
	 * 
	 * @param stock the stock to remove
	 */
	public void remove(Category category);
	
	/**
	 * 
	 * 
	 * @param id
	 * @return The Stock with id :id if exist null otherwise
	 */
	public Category finbyId(int id);

}
