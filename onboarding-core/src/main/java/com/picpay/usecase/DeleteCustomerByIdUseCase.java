package com.picpay.usecase;


import com.picpay.ports.in.DeleteCustomerBuIdInputPort;
import com.picpay.ports.in.FindCustomerByIdInputPort;
import com.picpay.ports.out.DeleteCustomerByIdOutPutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//asdf

@Service
@RequiredArgsConstructor
public class DeleteCustomerByIdUseCase implements DeleteCustomerBuIdInputPort {

    private final DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort;


    private  final FindCustomerByIdInputPort findCustomerByIdInputPort;


    @Override
    public void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutPutPort.delete(id);

    }
}
