package app.Rest.RestFullApiExample.InventoryData.Service;

import app.Rest.RestFullApiExample.InventoryData.Model.Film;
import app.Rest.RestFullApiExample.InventoryData.Repository.FilmRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepostory filmRepostory;

    public List<Film> getData(){
        return filmRepostory.findAll();
    }

}
