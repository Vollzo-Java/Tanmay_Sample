package test.code.assignment.repository;

import java.sql.Timestamp;
import java.util.List;

import test.code.assignment.entity.CustomerRegisterEntity;

import test.code.assignment.entity.PaymentTransactionEntity;
import test.code.assignment.vo.CustomerRegister;
import test.code.assignment.vo.PaymentTransaction;
import test.code.assignment.vo.RewardPoints;

public interface TransactionMgmtRepository {
	
	public boolean registerCustomer(CustomerRegister custmer);

	public List<CustomerRegisterEntity> getAllCustomer();
	
	public CustomerRegisterEntity getCustomerById(Integer custId);
	
	public Integer makePaymentTransaction(PaymentTransactionEntity paymentTransaction);
	
	public List<PaymentTransactionEntity> getRewardPoints(Integer custId, Timestamp startTs, Timestamp endTs);
}
