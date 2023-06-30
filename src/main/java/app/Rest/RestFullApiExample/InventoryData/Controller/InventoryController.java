package app.Rest.RestFullApiExample.InventoryData.Controller;

import app.Rest.RestFullApiExample.InventoryData.DTO.InventoryReportDto;
import app.Rest.RestFullApiExample.InventoryData.Filter.InventoryFilter;
import app.Rest.RestFullApiExample.InventoryData.Model.Film;
import app.Rest.RestFullApiExample.InventoryData.Model.Inventory;
import app.Rest.RestFullApiExample.InventoryData.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping
    public List<Inventory> getData(){
        return service.getData();
    }

    @GetMapping("/report")
    public List<InventoryReportDto> report(InventoryFilter filter){

        return service.report(filter);
    }
}
