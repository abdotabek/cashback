package org.example.cashback.service;

import lombok.RequiredArgsConstructor;
import org.example.cashback.dto.CustomerDTO;
import org.example.cashback.entity.Customer;
import org.example.cashback.exception.ExceptionUtil;
import org.example.cashback.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setMarketType(customerDTO.getMarketType());
        return toDTO(customerRepository.save(customer));
    }

    public CustomerDTO get(Long id) {
        return toDTO(customerRepository.findById(id).orElseThrow(
                () -> ExceptionUtil.throwNotFoundException("customer with id does not exist!")));
    }

    public List<CustomerDTO> getList() {
        return customerRepository.findAll().stream().map(this::toDTO).toList();
    }

    public CustomerDTO update(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> ExceptionUtil.throwNotFoundException("customer with id does not exist!"));
        customer.setName(customerDTO.getName());
        customer.setMarketType(customerDTO.getMarketType());
        return toDTO(customerRepository.save(customer));
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setMarketType(customer.getMarketType());
        return customerDTO;
    }
}
