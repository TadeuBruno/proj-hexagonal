package com.picpay.adapter;


import com.picpay.adapter.client.FindAddressByZipCodeClient;
import com.picpay.adapter.client.mapper.AddressResponseMapper;
import com.picpay.domain.Address;
import com.picpay.ports.out.FindAddressByZipCodeOutpuPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutpuPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;
    @Override
    public Address find(String zipcode) {
        var addressResponse = findAddressByZipCodeClient.find(zipcode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
