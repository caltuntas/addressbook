package com.demo.restapi;

import com.demo.application.service.IAddressService;
import com.demo.application.service.model.CreateAddressRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {


    IAddressService addressService;

    @Autowired
    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/address/create")
    boolean create(@RequestBody CreateAddressRequest model) {

        addressService.CreateAddress(model);
        return true;
    }
}
