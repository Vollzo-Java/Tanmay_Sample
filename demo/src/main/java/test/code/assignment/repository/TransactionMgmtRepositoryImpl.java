package test.code.assignment.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

 
import lombok.extern.slf4j.Slf4j;
import test.code.assignment.entity.CustomerRegisterEntity;
import test.code.assignment.entity.PaymentTransactionEntity;
import test.code.assignment.utils.CONTSTANT;
import test.code.assignment.utils.LocalDateFormat;
import test.code.assignment.vo.CustomerRegister;
import test.code.assignment.vo.PaymentTransaction;
import test.code.assignment.vo.RewardPoints;

@Repository
@Slf4j
public class TransactionMgmtRepositoryImpl implements TransactionMgmtRepository{
	
	@PersistenceContext
	EntityManager entityManager;

	private static final String CLASS_NAME = TransactionMgmtRepositoryImpl.class.getName();
	 
	
	@Override
	public boolean registerCustomer(CustomerRegister custmer) {
		// TODO Auto-generated method stub
		return false;
	}
	
	 @Override
	public List<CustomerRegisterEntity> getAllCustomer() {
		 List<CustomerRegisterEntity> allCustomerList = entityManager.createQuery("SELECT c FROM CustomerRegisterEntity c").getResultList();
		return allCustomerList;
	}
	 
	 @Override
	public CustomerRegisterEntity getCustomerById(Integer custId) {
		    CustomerRegisterEntity customerList = (CustomerRegisterEntity)entityManager.createQuery("SELECT c FROM CustomerRegisterEntity c WHERE c.custId="+custId).getSingleResult();
			return customerList;
	}
	 
	 @Override
	public List<PaymentTransactionEntity> getRewardPoints(Integer custId, Timestamp startTs, Timestamp endTs) {
		 //SELECT * FROM PAYMENT_TRANSACTION WHERE trans_timestamp BETWEEN '08-Mar-2023' AND '07-Apr-2023';
		 
		  
			List<PaymentTransactionEntity> rewardList = entityManager.createQuery("SELECT p FROM PaymentTransactionEntity p WHERE"
			 		+ " p.custId="+custId +" AND p.transTs BETWEEN '"+LocalDateFormat.dateFormatString(startTs) +"' AND '"+LocalDateFormat.dateFormatString(endTs)+"'").getResultList();
		 
		return rewardList;
	}
	 
	@Override
	public Integer makePaymentTransaction(PaymentTransactionEntity paymentTransaction) {
		 entityManager.persist(paymentTransaction);
		 Integer id = paymentTransaction.getTransId();
		return id;
	}
	 
}
