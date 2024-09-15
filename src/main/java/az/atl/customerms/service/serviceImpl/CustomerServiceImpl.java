package az.atl.customerms.service.serviceImpl;

import az.atl.customerms.dao.entity.CustomerEntity;
import az.atl.customerms.dao.repository.CustomerRepository;
import az.atl.customerms.exception.NotFoundException;
import az.atl.customerms.model.request.SaveCustomerDto;
import az.atl.customerms.model.response.CustomerResponseDto;
import az.atl.customerms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static az.atl.customerms.mapper.CustomerMapper.CUSTOMER_MAPPER;
import static az.atl.customerms.model.enums.ErrorMessage.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void saveCustomer(SaveCustomerDto dto) {
        var entity = CUSTOMER_MAPPER.buildCustomerEntity(dto);
        customerRepository.save(entity);
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        var entity = fetchCustomerIfExist(id);
        return CUSTOMER_MAPPER.buildCustomerResponse(entity);
    }

    @Override
    public void reduceBalance(Long id, BigDecimal totalAmount) {
        var entity = fetchCustomerIfExist(id);
        var updatedBalance = entity.getBalance().subtract(totalAmount);
        entity.setBalance(updatedBalance);
        customerRepository.save(entity);
    }

    private CustomerEntity fetchCustomerIfExist(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new NotFoundException(CUSTOMER_NOT_FOUND.format(id))
        );
    }
}
