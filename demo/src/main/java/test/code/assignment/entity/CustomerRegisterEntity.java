package test.code.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CUSTOMER_DETAIL")
public class CustomerRegisterEntity {
	@Id
	@Column(name = "CUST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer custId;
	
	@Column(name="CUST_NAME")
	private String custName;
	
	@Column(name="CUST_ADD")
	private String custAdd;  

}
