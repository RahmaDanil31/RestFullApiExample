package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.MasterData.Model.Category;
import app.Rest.RestFullApiExample.MasterData.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping()
    public List<Category> getData(){
        return service.getAllCategories();
    }
}
