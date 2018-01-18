package com.demo.test;


import com.demo.application.service.IAddressService;
import com.demo.application.service.model.CreateAddressRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {

    @Autowired
    IAddressService addressService;

    @Test
    public void  testAddressCreation()

    {


        CreateAddressRequest request=new CreateAddressRequest();
                request.city="Ankara";
                request.fullAddress="full mulll";
                request.userId=1;
                addressService.CreateAddress(request);


        assert(true);

    }
}
