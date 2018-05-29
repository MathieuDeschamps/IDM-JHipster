package desktop.deschamps.compta.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="quantity")
	private double quantity;
	
	@Column(name="date")
	private java.time.LocalDate date;

	public java.time.LocalDate getDate() {
		return date;
	}

	public void setDate(java.time.LocalDate date) {
		this.date = date;
	}

	@Column(length=45,name="name")
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Product product;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private QuantityType quantityType;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QuantityType getQuantityType() {
		return quantityType;
	}

	public void setQuantityType(QuantityType quantityType) {
		this.quantityType = quantityType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	

}
