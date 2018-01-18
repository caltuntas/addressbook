package com.demo.application.service;

import com.demo.application.service.model.CreateAddressRequest;
import com.demo.data.repository.IGenericDao;
import com.demo.domain.model.Address;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressService {

    @Autowired
    private IGenericDao<Address> addressDao;

    public void CreateAddess(CreateAddressRequest request) {

        Address addres = new Address();
        addres.setCity(request.city);
        addres.setFullAddress(request.fullAddress);
        addres.setUserId(request.userId);

        addressDao.save(addres);
    }
}
