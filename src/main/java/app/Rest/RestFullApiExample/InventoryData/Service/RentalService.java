package app.Rest.RestFullApiExample.InventoryData.Service;

import app.Rest.RestFullApiExample.InventoryData.Model.Rental;
import app.Rest.RestFullApiExample.InventoryData.Repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getData(){
        return rentalRepository.findAll();
    }
}
