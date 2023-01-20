package app.Rest.RestFullApiExample.InventoryData.Service;

import app.Rest.RestFullApiExample.InventoryData.Model.FilmCategory;
import app.Rest.RestFullApiExample.InventoryData.Repository.FilmCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmCategoryService {

    @Autowired
    private FilmCategoryRepository filmCategoryRepository;

    public List<FilmCategory> getAllFilmCategories(){
        return filmCategoryRepository.findAll();
    }

}
