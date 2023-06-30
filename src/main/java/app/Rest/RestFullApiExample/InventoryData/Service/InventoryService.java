package app.Rest.RestFullApiExample.InventoryData.Service;

import app.Rest.RestFullApiExample.InventoryData.DTO.InventoryReportDto;
import app.Rest.RestFullApiExample.InventoryData.Filter.InventoryFilter;
import app.Rest.RestFullApiExample.InventoryData.Model.Inventory;
import app.Rest.RestFullApiExample.InventoryData.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getData(){
        return inventoryRepository.findAll();
    }

    public List<InventoryReportDto> report(InventoryFilter filter){
        return inventoryRepository.report(filter);
    }
}
