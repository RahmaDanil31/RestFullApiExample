package app.Rest.RestFullApiExample.InventoryData.Service;

import app.Rest.RestFullApiExample.InventoryData.Model.Store;
import app.Rest.RestFullApiExample.InventoryData.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getData(){
        return storeRepository.findAll();
    }

}
