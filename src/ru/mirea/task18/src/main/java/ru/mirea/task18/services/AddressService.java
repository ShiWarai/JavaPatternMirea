package ru.mirea.task18.services;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.task18.repositories.AddressRepository;
import ru.mirea.task18.tables.Address;
import ru.mirea.task18.tables.Address;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements TableService<Address>{
    private AddressRepository addressRepository;

    @Autowired
    AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressService() {
    }

    public void createEntity(Address address) {
        addressRepository.save(address);
    }


    public List<Address> readAllEntity() {
        return addressRepository.findAll();
    }

    public boolean deleteAllEntity() {
        addressRepository.deleteAll();
        return true;
    }

    public List<Address> filterBy(String text, String zip) {
        if(text != null && zip != null)
            return addressRepository.findAllByTextAndZip(text, zip);
        else if (text != null) {
            return addressRepository.findAllByText(text);
        } else if (zip != null) {
            return addressRepository.findAllByZip(zip);
        }

        return null;
    }
}
