package app.Rest.RestFullApiExample.InventoryData.Service;

import app.Rest.RestFullApiExample.InventoryData.Model.City;
import app.Rest.RestFullApiExample.InventoryData.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }
}
