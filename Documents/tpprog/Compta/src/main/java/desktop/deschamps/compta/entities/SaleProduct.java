package desktop.deschamps.compta.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SaleProduct")
public class SaleProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name",length=45)
	private String name;
	
	@Column(name="prixHT")
	Double prixHT;
	
	@Column(name="TVA")
	Double tva;
	

	@ManyToOne
	Category category;
	
	
	@JoinTable(name="SaleProduct_has_SaleProduct", joinColumns={
	@JoinColumn(name = "MenuId", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
	@JoinColumn(name = "ItemId", referencedColumnName = "id", nullable = false)})	
	@ManyToMany
	private Set<SaleProduct> menuItems = new HashSet<>();
	
	@OneToMany(mappedBy="saleProduct",fetch= FetchType.LAZY,
				cascade=CascadeType.ALL)
	private Set<SaleProductHasProduct> saleProductHasProductSet = new HashSet<>();
	
	
	public void addSaleProductHasProduct(SaleProductHasProduct item){
		saleProductHasProductSet.add(item);
	}
	
	public Set<SaleProductHasProduct> getSaleProductHasProductSet() {
		return saleProductHasProductSet;
	}

	public void setSaleProductHasProductSet(Set<SaleProductHasProduct> saleProductHasProductSet) {
		this.saleProductHasProductSet = saleProductHasProductSet;
	}

	public Set<SaleProduct> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(Set<SaleProduct> menuItems) {
		this.menuItems = menuItems;
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

	public Double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(Double prixHT) {
		this.prixHT = prixHT;
	}

	public Double getTva() {
		return tva;
	}

	public void setTva(Double tva) {
		this.tva = tva;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
