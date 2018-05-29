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

@Entity
@Table(name="Ventes")
public class Ventes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="debutPeriode")
	private java.util.Date debutPeriode;
	
	@Column(name="finPeriode")
	private java.util.Date finPeriode;
	

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Unit_id")
	private Category unit;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getDebutPeriode() {
		return debutPeriode;
	}

	public void setDebutPeriode(java.util.Date debutPeriode) {
		this.debutPeriode = debutPeriode;
	}

	public java.util.Date getFinPeriode() {
		return finPeriode;
	}

	public void setFinPeriode(java.util.Date finPeriode) {
		this.finPeriode = finPeriode;
	}

	public Category getUnit() {
		return unit;
	}

	public void setUnit(Category unit) {
		this.unit = unit;
	}

}
