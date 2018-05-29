package desktop.deschamps.compta.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="name", length=45)
	String name;

	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	List<Stock> stockList = new ArrayList<>();
	
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	List<Saisie> saisies = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
			name="Product_has_Category",
			joinColumns=@JoinColumn(name="Product_id",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="Category_id",referencedColumnName="id"))
	Set<Category> categoryList;
	
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY,
				cascade=javax.persistence.CascadeType.ALL)
	private Set<SaleProductHasProduct> saleProductHasProductSet = new HashSet<>();
	
	public void addSaisie(Saisie saisie){
		saisies.add(saisie);
	}
	
	public void addStock(Stock stock){
		stockList.add(stock);
	}
	
	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	public List<Saisie> getSaisies() {
		return saisies;
	}

	public void setSaisies(List<Saisie> saisie) {
		this.saisies = saisie;
	}

	public Set<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(Set<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Set<SaleProductHasProduct> getSaleProductHasProductSet() {
		return saleProductHasProductSet;
	}

	public void setSaleProductHasProductSet(Set<SaleProductHasProduct> saleProductHasProductSet) {
		this.saleProductHasProductSet = saleProductHasProductSet;
	}

	public void addSaleProductHasProduct(SaleProductHasProduct item){
		saleProductHasProductSet.add(item);
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
