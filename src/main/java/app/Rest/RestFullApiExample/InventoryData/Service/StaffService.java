package app.Rest.RestFullApiExample.InventoryData.Service;

import app.Rest.RestFullApiExample.InventoryData.Model.Staff;
import app.Rest.RestFullApiExample.InventoryData.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> gatData(){
        return staffRepository.findAll();
    }

}
