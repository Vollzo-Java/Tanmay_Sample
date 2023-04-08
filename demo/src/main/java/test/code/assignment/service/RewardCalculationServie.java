package test.code.assignment.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import lombok.extern.slf4j.Slf4j;
import test.code.assignment.entity.CustomerRegisterEntity;
import test.code.assignment.entity.PaymentTransactionEntity;
import test.code.assignment.repository.BaseRepository;
import test.code.assignment.utils.CONTSTANT;
import test.code.assignment.vo.CustomerRegister;
import test.code.assignment.vo.RewardPoints;

@Service
@Slf4j
public class RewardCalculationServie {

	@Autowired
	BaseRepository baseRepository;
	
	
	private static final String CLASS_NAME = RewardCalculationServie.class.getName();
			
	 
	
	public List<CustomerRegister> getAllCustomer() {
		 List<CustomerRegisterEntity> allCustomerList = baseRepository.getAllCustomer();
		 List<CustomerRegister> objList = new ArrayList<CustomerRegister>();		 
		 allCustomerList.forEach(entityBean ->{
			 //if any additional logic needs to be set within the vo class
				 CustomerRegister custObj = new CustomerRegister();
				 custObj.setCustId(entityBean.getCustId());
				 custObj.setCustName(entityBean.getCustName());
				 custObj.setCustAdd(entityBean.getCustAdd());
				 objList.add(custObj);
				 
		 });
		return objList;
	}
	
	public CustomerRegister getCustomerById(Integer custId) {
		 CustomerRegisterEntity customerObject = baseRepository.getCustomerById(custId);
		   
			 //if any additional logic needs to be set within the vo class
				 CustomerRegister custObj = new CustomerRegister();
				 custObj.setCustId(customerObject.getCustId());
				 custObj.setCustName(customerObject.getCustName());
				 custObj.setCustAdd(customerObject.getCustAdd());
				  
		  
		return custObj;
	}
	
	 
		public RewardPoints getRewardPoints(Integer custId) {
			int totalRewards = 0;
			Timestamp month1 = Timestamp.valueOf(LocalDateTime.now().minusDays(CONTSTANT.EVERY_MONTH_REWARD));
			Timestamp month2 = Timestamp.valueOf(LocalDateTime.now().minusDays(2*CONTSTANT.EVERY_MONTH_REWARD));
			Timestamp month3 = Timestamp.valueOf(LocalDateTime.now().minusDays(3*CONTSTANT.EVERY_MONTH_REWARD));
			
			List<PaymentTransactionEntity> firstRewardList =  baseRepository.getRewardPoints(custId, month1,  Timestamp.from(Instant.now())); 
			List<PaymentTransactionEntity> secondRewardList =  baseRepository.getRewardPoints(custId, month2,  month1);
			List<PaymentTransactionEntity> thirdRewardList =  baseRepository.getRewardPoints(custId, month3,  month2);
			
			RewardPoints rewardObj = new RewardPoints();
			totalRewards += firstRewardList.stream().map(obj->calcRewardPoint(obj)).collect(Collectors.summingInt(p -> p.intValue()));
			totalRewards += secondRewardList.stream().map(obj->calcRewardPoint(obj)).collect(Collectors.summingInt(p -> p.intValue()));
			totalRewards += thirdRewardList.stream().map(obj->calcRewardPoint(obj)).collect(Collectors.summingInt(p -> p.intValue()));
			 
			//Get Customer details
			CustomerRegister customerObject =  getCustomerById(custId);
			
			 rewardObj.setCustId(custId);
			 rewardObj.setCustName(customerObject.getCustName());
			 rewardObj.setTotalRewardPoints(totalRewards);
			  
			 return rewardObj;
		}
		 
		@Transactional		
		public Integer makePaymentTransaction(PaymentTransactionEntity paymentTransaction) {	
			
			Integer id = baseRepository.makePaymentTransaction(paymentTransaction);			
			
			return id;
		}
		
		
		private Integer calcRewardPoint(PaymentTransactionEntity obj) {
			if (obj.getAmount() > CONTSTANT.SINGLE_REWARD_LIMIT && obj.getAmount() <= CONTSTANT.DOUBLE_REWARD_LIMIT) {
				return (int) (obj.getAmount() - CONTSTANT.SINGLE_REWARD_LIMIT);
			} else if (obj.getAmount() > CONTSTANT.DOUBLE_REWARD_LIMIT) {
				return (int) (obj.getAmount() - CONTSTANT.DOUBLE_REWARD_LIMIT) * 2
						+ (CONTSTANT.DOUBLE_REWARD_LIMIT - CONTSTANT.SINGLE_REWARD_LIMIT);
			} else
				return 0;

		}
}
