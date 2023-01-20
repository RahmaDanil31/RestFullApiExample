package app.Rest.RestFullApiExample.InventoryData.Controller;

import app.Rest.RestFullApiExample.InventoryData.Model.Rental;
import app.Rest.RestFullApiExample.InventoryData.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rental")
public class RentalController {

    @Autowired
    private RentalService service;

    @GetMapping
    public List<Rental> getData(){
        return service.getData();
    }
}
