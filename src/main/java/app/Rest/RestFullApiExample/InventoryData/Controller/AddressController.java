package app.Rest.RestFullApiExample.InventoryData.Controller;

import app.Rest.RestFullApiExample.InventoryData.Model.Address;
import app.Rest.RestFullApiExample.InventoryData.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public List<Address> getData(){
        return service.getAllAddreas();
    }
}
