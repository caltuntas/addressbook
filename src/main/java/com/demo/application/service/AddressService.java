package com.demo.application.service;

import com.demo.application.service.model.CreateAddressRequest;
import com.demo.data.repository.IGenericDao;
import com.demo.domain.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {


    private IGenericDao<Address> addressDao;

    @Autowired
    public AddressService(IGenericDao<Address> addressDao) {
        this.addressDao = addressDao;
        addressDao.setDaoType(Address.class);
    }

    public void CreateAddress(CreateAddressRequest request) {

        Address address = new Address();
        address.setCity(request.city);
        address.setFullAddress(request.fullAddress);
        address.setUserId(request.userId);

        addressDao.save(address);
    }
}
