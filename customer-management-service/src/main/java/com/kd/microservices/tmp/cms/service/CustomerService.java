package com.kd.microservices.tmp.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kd.microservices.tmp.cms.config.Performance;
import com.kd.microservices.tmp.cms.constants.Constants;
import com.kd.microservices.tmp.cms.dto.CustomerDto;
import com.kd.microservices.tmp.cms.model.Customer;
import com.kd.microservices.tmp.cms.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String saveCustomer(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setAddress(dto.getAddress());
        customer.setCreatedDate(new Date());
        customer.setEmailId(dto.getEmailId());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setMobileNumber(dto.getMobileNumber());
        customer.setPinCode(dto.getPinCode());
        customer.setUserName(dto.getUserName());
        customer.setUpdatedDate(new Date());
        customer.setPassword(dto.getPassword());
        customerRepository.save(customer);

        return Constants.CUST_REG_SUCCESS;
    }

    @Performance
    public CustomerDto getCustomerByCustId(Long custId) {
        return convertEntityIntoDTO(customerRepository.getCustomerByCustId(custId));
    }

    @Performance
    public CustomerDto getCustomerByUserName(String userName) {
        return convertEntityIntoDTO(customerRepository.getCustomerByUserName(userName));
    }

    @Performance
    public String saveCustomerList(List<Customer> customers) {
        customerRepository.saveAll(customers);
        return Constants.CUST_REG_SUCCESS;
    }

    @Performance
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public String customerLogin(CustomerDto dto) {
        Customer customer = customerRepository.getCustomerByUserName(dto.getUserName());
        if (customer != null)
            if (dto.getPassword() != null && dto.getPassword().equals(customer.getPassword()))
                return Constants.SUCCESS;
            else
                return Constants.INVALID_CUSTOMER;
        else
            return Constants.INVALID_USERNAME;
    }

    private CustomerDto convertEntityIntoDTO(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setAddress(customer.getAddress());
        dto.setEmailId(customer.getEmailId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setMobileNumber(customer.getMobileNumber());
        dto.setPinCode(customer.getPinCode());
        dto.setUserName(customer.getUserName());
        dto.setPassword(customer.getPassword());

        return dto;
    }
}
