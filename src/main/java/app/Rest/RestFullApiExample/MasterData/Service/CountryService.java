package app.Rest.RestFullApiExample.MasterData.Service;

import app.Rest.RestFullApiExample.MasterData.Model.Country;
import app.Rest.RestFullApiExample.MasterData.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountres(){
        return countryRepository.findAll();
    }
}
