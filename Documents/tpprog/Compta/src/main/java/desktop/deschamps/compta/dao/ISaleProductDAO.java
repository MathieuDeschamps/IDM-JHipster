package desktop.deschamps.compta.dao;

import desktop.deschamps.compta.entities.SaleProduct;

public interface ISaleProductDAO extends DAO {
	
	/**
	 * 
	 * @param stock the stock we wanna store
	 */
	public void store(SaleProduct saleProduct);
	
	/**
	 * Remove a Stock from the db
	 * 
	 * @param stock the stock to remove
	 */
	public void remove(SaleProduct saleProduct);
	
	/**
	 * 
	 * 
	 * @param id
	 * @return The Stock with id :id if exist null otherwise
	 */
	public SaleProduct finbyId(int id);

}
