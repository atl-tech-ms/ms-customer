package az.atl.customerms.service;

import az.atl.customerms.model.request.SaveCustomerDto;
import az.atl.customerms.model.response.CustomerResponseDto;

import java.math.BigDecimal;

public interface CustomerService {
    void saveCustomer(SaveCustomerDto dto);

    CustomerResponseDto getCustomerById(Long id);

    void reduceBalance(Long id, BigDecimal totalAmount);
}
