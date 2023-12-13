package com.picpay.controller;

import com.picpay.controller.mapper.CustomerMapper;
import com.picpay.controller.request.CustomerRequest;
import com.picpay.controller.response.CustomerResponse;
import com.picpay.domain.Customer;
import com.picpay.ports.in.DeleteCustomerBuIdInputPort;
import com.picpay.ports.in.FindCustomerByIdInputPort;
import com.picpay.ports.in.InsertCustomerInputPort;
import com.picpay.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerBuIdInputPort deleteCustomerBuIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findByID(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerBuIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
