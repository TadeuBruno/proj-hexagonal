package com.picpay.usecase;


import com.picpay.ports.in.ValidationCPFInputPort;
import com.picpay.ports.out.SendResultCpfValidationOutputPort;
import com.picpay.utils.ValidaCpfUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidationCpfUseCase implements ValidationCPFInputPort {


    private final SendResultCpfValidationOutputPort sendResultCpfValidationOutputPort;
    @Override
    public void validation(String cpf) {
        boolean isValid =  ValidaCpfUtils.validaCPF(cpf);
        sendResultCpfValidationOutputPort.sendCpfResult(cpf,isValid);
    }
}
