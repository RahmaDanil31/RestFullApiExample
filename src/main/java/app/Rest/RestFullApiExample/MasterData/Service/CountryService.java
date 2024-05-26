package app.Rest.RestFullApiExample.MasterData.Service;

import app.Rest.RestFullApiExample.Helper.Exception.NoDataFoundException;
import app.Rest.RestFullApiExample.Helper.Implement.ServiceImpl;
import app.Rest.RestFullApiExample.Helper.Mapper.ObjectHelper;
import app.Rest.RestFullApiExample.Helper.Util.ResponseItem;
import app.Rest.RestFullApiExample.MasterData.DTO.CategoryDto;
import app.Rest.RestFullApiExample.MasterData.DTO.CountryDto;
import app.Rest.RestFullApiExample.MasterData.Filter.CountryDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Model.Country;
import app.Rest.RestFullApiExample.MasterData.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CountryService{

    @Autowired
    private CountryRepository countryRepository;

    public ResponseItem get(CountryDtoFilter filter){
        int count = countryRepository.count(filter);
        ResponseItem responseItem = new ResponseItem();

        responseItem.setMeta(ResponseItem.Meta.builder()
                .totalItems(count)
                .currentPage(filter.getCurrentPage())
                .itemsPerPage(filter.getItemsPerPage())
                .totalPages((int) Math.ceil((float) count / filter.getItemsPerPage()))
                .build());

        List<CountryDto> countryDtos = ObjectHelper.convertList(countryRepository.view(filter,filter.buildPage(false)), CountryDto.class);

        responseItem.setItems(countryDtos);

        return responseItem;
    }

    public CountryDto loadById(Long id) {
        return ObjectHelper.convert(countryRepository.findById(id).orElseThrow(()->new NoDataFoundException()),CountryDto.class);
    }
}
