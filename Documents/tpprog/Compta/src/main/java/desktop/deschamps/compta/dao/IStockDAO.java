package desktop.deschamps.compta.dao;

import desktop.deschamps.compta.entities.Saisie;
import desktop.deschamps.compta.entities.Stock;

/**
 * 
 * @author boby
 *
 */
public interface IStockDAO extends DAO {

	/**
	 * 
	 * @param stock the stock we wanna store
	 */
	public void store(Stock stock);
	
	/**
	 * Remove a Stock from the db
	 * 
	 * @param stock the stock to remove
	 */
	public void remove(Stock stock);
	
	/**
	 * 
	 * 
	 * @param id
	 * @return The Stock with id :id if exist null otherwise
	 */
	public Stock finbyId(int id);
}
