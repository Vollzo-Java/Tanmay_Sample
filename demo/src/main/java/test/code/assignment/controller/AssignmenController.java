package test.code.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import test.code.assignment.entity.PaymentTransactionEntity;
import test.code.assignment.service.RewardCalculationServie;
import test.code.assignment.vo.CustomerRegister;
import test.code.assignment.vo.RewardPoints;

@RestController
@RequestMapping("/api/v2/tnx")
@Slf4j
public class AssignmenController {
    @Autowired
	RewardCalculationServie rewardCalculationServie;
	
	@GetMapping(value="/allcustomer")
	@ResponseBody
	public List<CustomerRegister> getCustomer(){
		log.info("Inside getCustomer () "+rewardCalculationServie);
		return rewardCalculationServie.getAllCustomer();
	}
	
	@GetMapping(value="/customer/{custId}")
	@ResponseBody
	public CustomerRegister getCustomerById(@PathVariable Integer custId){
		 
		return rewardCalculationServie.getCustomerById(custId);
	}
	
	
	@GetMapping(value="/getreward/{custId}")
	@ResponseBody
	public RewardPoints getRewardPoints(@PathVariable Integer custId){
		log.info("Inside getRewardPoints ()");
		return rewardCalculationServie.getRewardPoints(custId);
	}
	
	
	@PostMapping(value="/payment")
	@ResponseBody
	public String makePaymentTransaction(@RequestBody PaymentTransactionEntity paymentTransaction){
		log.info("Inside makePaymentTransaction ()");
		Integer id = rewardCalculationServie.makePaymentTransaction(paymentTransaction);
				
		return "Payment Transaction ID :"+id;
	}
	

}
