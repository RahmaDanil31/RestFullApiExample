package app.Rest.RestFullApiExample.MasterData.Service;

import app.Rest.RestFullApiExample.Helper.Exception.NoDataFoundException;
import app.Rest.RestFullApiExample.Helper.Implement.ServiceImpl;
import app.Rest.RestFullApiExample.Helper.Mapper.ObjectHelper;
import app.Rest.RestFullApiExample.MasterData.DTO.LaengugeDto;
import app.Rest.RestFullApiExample.MasterData.Model.Langauge;
import app.Rest.RestFullApiExample.MasterData.Repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LanguageService implements ServiceImpl<LaengugeDto> {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Langauge> getAllLanguages(){
        return languageRepository.findAll();
    }

    @Override
    public LaengugeDto saveOrUpdate(LaengugeDto object) {
        Langauge langauge = ObjectHelper.convert(object,Langauge.class);
        return ObjectHelper.convert(languageRepository.save(langauge), LaengugeDto.class);
    }

    @Override
    public LaengugeDto loadById(Long id) {
        return ObjectHelper.convert(languageRepository.findById(id).orElseThrow(()->new NoDataFoundException()), LaengugeDto.class);
    }

    @Override
    public LaengugeDto loadByUUID(UUID uuid) {
        return null;
    }

    @Override
    public void delete(Long id) {
        languageRepository.deleteById(id);
    }

    @Override
    public void deleteByUUID(UUID uuid) {

    }
}
