package desktop.deschamps.compta.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Deschamps Mathieu 
 * 
 * Une saisie représente un achat de la société 
 *
 */
@Entity
@Table(name="Saisie")
public class Saisie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="date_facture")
	private java.time.LocalDate dateFacture;
	
	@Column(name="date_paiement")
	private java.time.LocalDate datePaiement;
	
	@Column(name="quantity")
	private double quantity;
	
	@Column(name="prixHT")
	private double prixHT;
	
	@Column(name="TVA")
	private double tva;
	
	@Column(name="name",length=45)
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QuantityType getqType() {
		return qType;
	}

	public void setqType(QuantityType qType) {
		this.qType = qType;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Fournisseur_id")
	private Fournisseur fournisseur;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Product_id")
	private Product product;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="QuantityType_id")
	private QuantityType qType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.time.LocalDate getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(java.time.LocalDate dateFacture) {
		this.dateFacture = dateFacture;
	}

	public  java.time.LocalDate getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(java.time.LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public double getTva() {
		return tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	public Product getProduct() {
		return product;
	}

	public void setUnit(Product product) {
		this.product= product;
	}
}
