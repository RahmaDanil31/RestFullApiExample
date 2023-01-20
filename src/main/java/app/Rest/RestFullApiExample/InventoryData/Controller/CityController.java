package app.Rest.RestFullApiExample.InventoryData.Controller;

import app.Rest.RestFullApiExample.InventoryData.Model.City;
import app.Rest.RestFullApiExample.InventoryData.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping
    public List<City> getData(){
        return service.getAllCities();
    }

}
