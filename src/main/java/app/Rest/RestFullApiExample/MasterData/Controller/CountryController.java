package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.MasterData.DTO.ContactDto;
import app.Rest.RestFullApiExample.MasterData.DTO.CountryDto;
import app.Rest.RestFullApiExample.MasterData.Model.Country;
import app.Rest.RestFullApiExample.MasterData.Service.CountryService;
import app.Rest.RestFullApiExample.Validation.ErrorHandling.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping()
    public List<Country> getData(){
        return service.getAllCountres();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CountryDto dto, Errors errors){

        ResponseData<CountryDto> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            responseData.setMessage(errors.getFieldError().getDefaultMessage());
            responseData.setStatus(HttpStatus.BAD_REQUEST);
            return new ResponseEntity(responseData, HttpStatus.BAD_REQUEST);
        }

        responseData.setData(service.saveOrUpdate(dto));

        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        ResponseData<CountryDto> responseData = new ResponseData<>();

        responseData.setData(service.loadById(id));

        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
