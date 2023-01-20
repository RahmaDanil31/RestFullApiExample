package app.Rest.RestFullApiExample.InventoryData.Service;

import app.Rest.RestFullApiExample.InventoryData.Model.Customer;
import app.Rest.RestFullApiExample.InventoryData.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getData(){
        return customerRepository.findAll();
    }
}
