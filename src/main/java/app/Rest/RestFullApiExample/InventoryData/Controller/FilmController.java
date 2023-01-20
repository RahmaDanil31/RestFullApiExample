package app.Rest.RestFullApiExample.InventoryData.Controller;

import app.Rest.RestFullApiExample.InventoryData.Model.Film;
import app.Rest.RestFullApiExample.InventoryData.Model.FilmCategory;
import app.Rest.RestFullApiExample.InventoryData.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    @Autowired
    private FilmService service;

    @GetMapping
    public List<Film> getData(){
        return service.getData();
    }
}
