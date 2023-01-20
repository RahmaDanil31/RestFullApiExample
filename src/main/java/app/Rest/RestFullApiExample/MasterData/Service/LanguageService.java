package app.Rest.RestFullApiExample.MasterData.Service;

import app.Rest.RestFullApiExample.MasterData.Model.Langauge;
import app.Rest.RestFullApiExample.MasterData.Repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Langauge> getAllLanguages(){
        return languageRepository.findAll();
    }

}
