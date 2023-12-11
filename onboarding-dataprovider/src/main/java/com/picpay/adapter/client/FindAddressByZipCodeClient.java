package com.picpay.adapter.client;

import com.picpay.adapter.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${jhonatas.client.address.url}"
)
public interface FindAddressByZipCodeClient {
    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable("zipCode") String zipcode);
}
