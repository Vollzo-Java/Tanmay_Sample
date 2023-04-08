package test.code.assignment.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RewardPoints {
	private Integer custId;
	private String custName;  
	private Integer totalRewardPoints;	
}
