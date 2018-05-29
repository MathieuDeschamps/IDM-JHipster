package desktop.deschamps.compta.entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SaleProduct_has_Product")
public class SaleProductHasProduct {
	
	@EmbeddedId
	SaleProductHasProductId id;

	@Column(name="quantity")
	private double quantity;

	@ManyToOne
	private QuantityType quantityType;
	
	@ManyToOne
	@JoinColumn(name="product",insertable=false,updatable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="saleProduct",insertable=false,updatable=false)
	private SaleProduct saleProduct;
	
	
	public SaleProductHasProduct(Product product, SaleProduct saleProduct, double quantity, QuantityType type){
		this.id = new SaleProductHasProductId(saleProduct.getId(), product.getId());
		this.quantity = quantity;
		this.quantityType = type;
		
		product.getSaleProductHasProductSet().add(this);
		saleProduct.getSaleProductHasProductSet().add(this);
		
	}


	

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public QuantityType getQuantityType() {
		return quantityType;
	}

	public void setQuantityType(QuantityType quantityType) {
		this.quantityType = quantityType;
	}
	
}
