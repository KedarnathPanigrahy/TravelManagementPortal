package com.kd.microservices.tmp.cms.repository;

import com.kd.microservices.tmp.cms.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
Customer getCustomerByCustId(Long custId);
Customer getCustomerByUserName(String userName);
}
