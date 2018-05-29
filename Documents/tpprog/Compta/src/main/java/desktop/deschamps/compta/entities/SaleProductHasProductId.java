package desktop.deschamps.compta.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class SaleProductHasProductId implements Serializable {
	
	
	
	private static final long serialVersionUID = -3246308113715494651L;

	@Column(name="saleProduct")
	private double saleProduct;
	
	@Column(name="product")
	private double product;
	
	public SaleProductHasProductId(){
		
	}
	
	public  SaleProductHasProductId(int saleProduct, int product){
		this.saleProduct = saleProduct;
		this.product = product;
	}

}
