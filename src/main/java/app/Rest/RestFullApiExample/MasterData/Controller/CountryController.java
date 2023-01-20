package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.MasterData.Model.Country;
import app.Rest.RestFullApiExample.MasterData.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping()
    public List<Country> getData(){
        return service.getAllCountres();
    }
}
