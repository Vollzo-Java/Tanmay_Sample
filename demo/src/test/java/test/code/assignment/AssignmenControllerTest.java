package test.code.assignment;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension; 
import org.springframework.test.web.servlet.MockMvc; 
import test.code.assignment.controller.AssignmenController; 
import test.code.assignment.vo.CustomerRegister;
import test.code.assignment.vo.RewardPoints;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AssignmenController.class)
public class AssignmenControllerTest {
	 @Autowired
	 private MockMvc mvc;
	 
	 @MockBean
	 private AssignmenController assignmenController;
	 
	@Test
	public void  getCustomer(){
		 List<CustomerRegister> testObj = new ArrayList<>();
		 CustomerRegister beanObj = new CustomerRegister();
		 beanObj.setCustId(1);
		 beanObj.setCustName("Tanmay");
		 beanObj.setCustAdd("Coppell");
		 testObj.add(beanObj);
		 
		 given(assignmenController.getCustomer()).willReturn(testObj);
		 
		 try {
			mvc.perform(get("http://localhost:8088/api/v2/tnx/allcustomer"))
			           .andExpect(status().isOk());
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
	  
	}
	 
	@Test
	public void  getRewardPoints(){
		 
		RewardPoints beanObj = new RewardPoints();
		 beanObj.setCustId(1);
		 beanObj.setCustName("Stephen"); 
		 beanObj.setTotalRewardPoints(340); 
		 
		 given(assignmenController.getRewardPoints(1)).willReturn(beanObj);
		 
		 try {
			mvc.perform(get("http://localhost:8088/api/v2/tnx/getreward/1"))
			           .andExpect(status().isOk());
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
	  
	}
	 
	

}
