package com.picpay.usecase;


import com.picpay.domain.Customer;
import com.picpay.ports.in.InsertCustomerInputPort;
import com.picpay.ports.out.FindAddressByZipCodeOutpuPort;
import com.picpay.ports.out.FindCustomerByCpfOutputPort;
import com.picpay.ports.out.InsertCustomerOutpuPort;
import com.picpay.ports.in.ValidationCPFInputPort;
import com.picpay.ports.out.SendCpfOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Service
@RequiredArgsConstructor
public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort;

    private final InsertCustomerOutpuPort insertCustomerOutpuPort;

    private  final ValidationCPFInputPort sendCpfForValidationOutputPort;

    private final SendCpfOutputPort sendCpfOutputPort;

    private final FindCustomerByCpfOutputPort findCustomerByCpfOutputPort;


    @Override
    public void insert(Customer customer, String zipCode ){
        var isPresent = findCustomerByCpfOutputPort.findCustomerByCpf(customer.getCpf()).isPresent();
        if(isPresent){
           throw new RuntimeException("Outro usuário já tem esse cpf");

        }
        var address = findAddressByZipCodeOutpuPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutpuPort.insert(customer);
        sendCpfOutputPort.send(customer.getCpf());

    }

}
