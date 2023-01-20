package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.MasterData.Model.Langauge;
import app.Rest.RestFullApiExample.MasterData.Service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    @Autowired
    private LanguageService service;

    @GetMapping()
    private List<Langauge> getData(){
        return service.getAllLanguages();
    }
}
