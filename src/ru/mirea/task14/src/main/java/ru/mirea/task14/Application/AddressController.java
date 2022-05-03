package ru.mirea.task14.Application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class AddressController {
    private ArrayList<Address> addresses = new ArrayList<>();

    @PostMapping(value = "/add_address")
    @ResponseBody
    public String addAddress(@RequestParam("text") String addressText, @RequestParam("zip") String zipCode) {
        Address address = new Address(addressText, zipCode);
        addresses.add(address);
        return address.toString();
    }

    @GetMapping(value = "/get_addresses")
    @ResponseBody
    public String getAddresses() {
        String result = "[";

        for (Address address : addresses) {
            result += address.toString() + ',';
        }
        if(addresses.size() > 0)
            result = result.substring(0, result.length() - 1);

        result+="]";
        return result;
    }

    @DeleteMapping(value = "/delete_addresses")
    @ResponseBody
    public boolean deleteAddresses() {
        addresses.clear();
        return addresses.size() == 0;
    }
}
