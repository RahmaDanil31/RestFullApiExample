package app.Rest.RestFullApiExample.InventoryData.Controller;

import app.Rest.RestFullApiExample.InventoryData.Model.FilmCategory;
import app.Rest.RestFullApiExample.InventoryData.Service.FilmCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/film-category")
public class FilmCategoryController {

    @Autowired
    private FilmCategoryService service;

    @GetMapping
    public List<FilmCategory> getData(){
        return service.getAllFilmCategories();
    }
}
