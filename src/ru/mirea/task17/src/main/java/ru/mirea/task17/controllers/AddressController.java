package ru.mirea.task17.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task17.services.AddressService;
import ru.mirea.task17.services.TableService;
import ru.mirea.task17.tables.Address;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {

    private final TableService<Address> serviceTableService;

    @Autowired
    public AddressController(TableService<Address> serviceTableService) {
        this.serviceTableService = serviceTableService;
    }

    @PostMapping(value = "/add_address", consumes = {"application/json"})
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        serviceTableService.createEntity(address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/get_addresses")
    public ResponseEntity<List<Address>> readAddresses() {
        final List<Address> addresses = serviceTableService.readAllEntity();
        return addresses != null && !addresses.isEmpty()
                ? new ResponseEntity<>(addresses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/get_addresses/by")
    public ResponseEntity<List<Address>> getAddressBy(@RequestParam(value = "text", required = false) String text,
                                                      @RequestParam(value = "zip", required = false) String zip) {
        List<Address> addresses = null;

        if(text != null && zip != null) {
            addresses = ((AddressService) serviceTableService).filterByText(text);
            for (Address address : addresses) {
                if (address.getZip() != zip)
                    addresses.remove(address);
            }
        }
        else if(text != null)
            addresses = ((AddressService)serviceTableService).filterByText(text);
        else if (zip != null)
            addresses = ((AddressService)serviceTableService).filterByZip(zip);

        return addresses != null && !addresses.isEmpty()
                ? new ResponseEntity<>(addresses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/delete_addresses")
    public ResponseEntity<?> deleteBuildings() {
        final boolean isDeleted = serviceTableService.deleteAllEntity();
        return isDeleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
