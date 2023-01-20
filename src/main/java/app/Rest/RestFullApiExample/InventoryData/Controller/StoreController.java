package app.Rest.RestFullApiExample.InventoryData.Controller;

import app.Rest.RestFullApiExample.InventoryData.Model.Film;
import app.Rest.RestFullApiExample.InventoryData.Model.Store;
import app.Rest.RestFullApiExample.InventoryData.Service.FilmService;
import app.Rest.RestFullApiExample.InventoryData.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    private StoreService service;

    @GetMapping
    public List<Store> getData(){
        return service.getData();
    }
}
