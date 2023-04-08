package test.code.assignment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.code.assignment.entity.PaymentTransactionEntity;
import test.code.assignment.vo.PaymentTransaction;

@Repository
public interface BaseRepository extends JpaRepository<PaymentTransactionEntity, Long>, TransactionMgmtRepository{

}
