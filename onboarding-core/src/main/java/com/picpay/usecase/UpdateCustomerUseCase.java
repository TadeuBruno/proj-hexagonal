package com.picpay.usecase;


import com.picpay.domain.Customer;
import com.picpay.ports.in.FindCustomerByIdInputPort;
import com.picpay.ports.in.UpdateCustomerInputPort;
import com.picpay.ports.out.FindAddressByZipCodeOutpuPort;
import com.picpay.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

   private final FindCustomerByIdInputPort findCustomerByIdInputPort;

   private final FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort;

   private final UpdateCustomerOutputPort updateCustomerOutputPort;

    @Override
    public void update(Customer customer, String zipCode){
       findCustomerByIdInputPort.find(customer.getId());
       var address = findAddressByZipCodeOutpuPort.find(zipCode);
       customer.setAddress(address);
       updateCustomerOutputPort.update(customer);

    }
}
