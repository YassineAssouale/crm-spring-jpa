package crm.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@NamedQuery(name = "Order.findByTypeAndStatus", query = "SELECE o FROM MyOrder WHERE o.type = :type AND o.status = :status")
public class MyOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100) 
	private String label;
	
	@Column(name = "adr_et", columnDefinition = "DECIMAL") 
	private Double adrEt;
	
	@Column(name = "number_of_days", columnDefinition = "DECIMAL") 
	private Double numberOfDays;
	
	@Column(columnDefinition = "DECIMAL") 
	private Double tva;
	
	@Column(length = 30) 
	private String status;
	
	@Column(length = 30) 
	private String type;
	
	@Column(lengtg = 255) 
	private String notes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public MyOrder() {
		// TODO Auto-generated constructor stub
	}

	public MyOrder(Integer id, String label, Double adrEt, Double numberOfDays, Double tva, String status, String type,
			String notes, Customer customer) {
		super();
		this.id = id;
		this.label = label;
		this.adrEt = adrEt;
		this.numberOfDays = numberOfDays;
		this.tva = tva;
		this.status = status;
		this.type = type;
		this.notes = notes;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getAdrEt() {
		return adrEt;
	}

	public void setAdrEt(Double adrEt) {
		this.adrEt = adrEt;
	}

	public Double getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(Double numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public Double getTva() {
		return tva;
	}

	public void setTva(Double tva) {
		this.tva = tva;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "MyOrder [id=" + id + ", label=" + label + ", adrEt=" + adrEt + ", numberOfDays=" + numberOfDays
				+ ", tva=" + tva + ", status=" + status + ", type=" + type + ", notes=" + notes + ", customer="
				+ customer + "]";
	}
	
	

}
