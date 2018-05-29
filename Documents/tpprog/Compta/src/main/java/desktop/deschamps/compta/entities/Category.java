package desktop.deschamps.compta.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author DESCHAMPS Mathieu
 * Definit une catégorie de bien (alccool, d.alim.,...)
 *
 */

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name",length=45)
	private String name;
	
	@ManyToMany(mappedBy="categoryList",fetch=FetchType.LAZY)
	private Set<Product> products;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="category")
	private Set<SaleProduct> saleProducts;
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<SaleProduct> getSaleProducts() {
		return saleProducts;
	}

	public void setSaleProducts(Set<SaleProduct> saleProducts) {
		this.saleProducts = saleProducts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
