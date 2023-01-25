package app.Rest.RestFullApiExample.MasterData.Service;

import app.Rest.RestFullApiExample.Helper.Exception.NoDataFoundException;
import app.Rest.RestFullApiExample.Helper.Implement.ServiceImpl;
import app.Rest.RestFullApiExample.Helper.Mapper.ObjectHelper;
import app.Rest.RestFullApiExample.MasterData.DTO.CountryDto;
import app.Rest.RestFullApiExample.MasterData.Model.Country;
import app.Rest.RestFullApiExample.MasterData.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CountryService implements ServiceImpl<CountryDto> {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountres(){
        return countryRepository.findAll();
    }

    @Override
    public CountryDto saveOrUpdate(CountryDto object) {
        Country country = ObjectHelper.convert(object,Country.class);
        return ObjectHelper.convert(countryRepository.save(country),CountryDto.class);
    }

    @Override
    public CountryDto loadById(Long id) {
        return ObjectHelper.convert(countryRepository.findById(id).orElseThrow(()->new NoDataFoundException()),CountryDto.class);
    }

    @Override
    public CountryDto loadByUUID(UUID uuid) {
        return null;
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public void deleteByUUID(UUID uuid) {

    }
}
