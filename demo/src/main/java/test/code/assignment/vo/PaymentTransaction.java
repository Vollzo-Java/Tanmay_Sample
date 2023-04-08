package test.code.assignment.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentTransaction {

    private Integer transId; 
	private Integer custId;  
	private Double amount;
	private String transTs;
	private String status;
}
