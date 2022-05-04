package ru.mirea.task15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Address>> readBuildings() {
        final List<Address> addresses = serviceTableService.readAllEntity();
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
