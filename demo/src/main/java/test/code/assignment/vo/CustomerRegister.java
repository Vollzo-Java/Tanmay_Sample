package test.code.assignment.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRegister {
   
    private Integer custId;
	 
	private String custName;
	 
	private String custAdd;  
}
