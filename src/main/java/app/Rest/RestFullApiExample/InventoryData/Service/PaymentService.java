package app.Rest.RestFullApiExample.InventoryData.Service;

import app.Rest.RestFullApiExample.InventoryData.Model.Payment;
import app.Rest.RestFullApiExample.InventoryData.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getData(){
        return paymentRepository.findAll();
    }

}
