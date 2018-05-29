package desktop.deschamps.compta.dao;

import java.util.List;

import desktop.deschamps.compta.entities.Saisie;

/**
 * 
 * 
 * @author DESCHAMPS Mathieu
 *
 *Interface for the SaisieDao
 */
public interface ISaisieDAO {

	/**
	 * 
	 * @param saisie the saisie we wanna store
	 */
	public void store(Saisie saisie);
	
	/**
	 * Remove a Saisie from the db
	 * 
	 * @param saisie the saisie to remove
	 */
	public void remove(Saisie saisie);
	
	/**
	 * 
	 * 
	 * @param id
	 * @return The Saisie with id :id
	 */
	public Saisie finbyId(int id);
	
	
	/**
	 * 
	 * @param month the nulber of the month in the year
	 * @return
	 */
	public List<Saisie> findByMonth(int month);

}
