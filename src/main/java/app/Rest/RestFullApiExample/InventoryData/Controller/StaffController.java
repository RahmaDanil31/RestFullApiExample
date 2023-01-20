package app.Rest.RestFullApiExample.InventoryData.Controller;

import app.Rest.RestFullApiExample.InventoryData.Model.Staff;
import app.Rest.RestFullApiExample.InventoryData.Model.Store;
import app.Rest.RestFullApiExample.InventoryData.Service.StaffService;
import app.Rest.RestFullApiExample.InventoryData.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService service;

    @GetMapping
    public List<Staff> getData(){
        return service.gatData();
    }

}
