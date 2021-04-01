package com.tranhuudat.shoppping.repository;

import com.tranhuudat.shoppping.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<PaymentModel,Long> {
}
