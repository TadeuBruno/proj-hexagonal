package com.picpay.usecase;

import com.picpay.ports.in.UpdateCpfInputPort;
import com.picpay.ports.out.FindCustomerByCpfOutputPort;
import com.picpay.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UpdateCpfUseCase implements UpdateCpfInputPort {

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    private final FindCustomerByCpfOutputPort findCustomerByCpfOutputPort;

    @Override
    public void update(String cpf, Boolean isValid) {
        var findCustomer = findCustomerByCpfOutputPort.find(cpf).orElseThrow(() -> new RuntimeException("Deu erro"));
        findCustomer.setIsValidCpf(isValid);
        updateCustomerOutputPort.update(findCustomer);

    }
}
