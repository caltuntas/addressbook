package com.demo.application.service;

import com.demo.application.service.model.CreateAddressRequest;
import com.demo.data.repository.IGenericDao;
import com.demo.domain.model.Address;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressService implements IAddressService {

    @Autowired
    private IGenericDao<Address> addressDao;

    public void CreateAddress(CreateAddressRequest request) {

        Address address = new Address();
        address.setCity(request.city);
        address.setFullAddress(request.fullAddress);
        address.setUserId(request.userId);

        addressDao.save(address);
    }
}
