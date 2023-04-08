package test.code.assignment.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table; 

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PAYMENT_TRANSACTION")
public class PaymentTransactionEntity {
	@Id
	@Column(name = "TRANS_ID")
	 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAB_CUSTOMER_SEQ")
	@SequenceGenerator(name="TAB_CUSTOMER_SEQ", sequenceName="TAB_CUSTOMER_SEQ", allocationSize=1)
	private Integer transId;
	
	@Column(name="CUST_ID")
	private Integer custId;
	
	@Column(name="AMOUNT")
	private Double amount;
	
	 
	@Column(name="TRANS_TIMESTAMP", insertable = false, updatable = false)
	@CreationTimestamp
	private Timestamp transTs;
	
	@Column(name="TRANS_STATUS")
	private String status;
	
}
