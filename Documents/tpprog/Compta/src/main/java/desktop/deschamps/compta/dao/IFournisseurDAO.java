package desktop.deschamps.compta.dao;

import desktop.deschamps.compta.entities.Fournisseur;

/**
 * 
 * Interfce of the FournisseurDAO
 * @author DESCHAMPS Mathieu
 *
 */
public interface IFournisseurDAO extends DAO {

	/**
	 * Store a Fournisseur in the db
	 * @param fournisseur the fournisseur to store
	 */
	public void store(Fournisseur fournisseur);
	
	/**
	 * Remove a fournisseur from the db
	 * @param fournisseur the fournisseur to remove
	 */
	public void remove(Fournisseur fournisseur);
	
	/**
	 * Find a fournisseur by it id
	 * @param id the id of the fournisseur
	 * @return a fournisseur if exist null otherwise
	 */
	public Fournisseur findById(int id);
	
	/**
	 * Find a fournisseur by it name
	 * @param name the name of the fournisseur
	 * @return a fournisseur named :name if exist null otherwise
	 */
	public Fournisseur finByName(String name);
	
}
