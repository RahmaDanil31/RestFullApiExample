package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.MasterData.DTO.CategoryDto;
import app.Rest.RestFullApiExample.MasterData.DTO.ContactDto;
import app.Rest.RestFullApiExample.MasterData.Model.Contacts;
import app.Rest.RestFullApiExample.MasterData.Service.ContactsService;
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
@RequestMapping("/api/contacts")
public class ContactsController {

    @Autowired
    private ContactsService service;

    @GetMapping()
    public List<Contacts> getData(){
        return service.getAllContacts();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ContactDto dto, Errors errors){

        ResponseData<ContactDto> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            responseData.setMessage(errors.getFieldError().getDefaultMessage());
            responseData.setStatus(HttpStatus.BAD_REQUEST);
            return new ResponseEntity(responseData, HttpStatus.BAD_REQUEST);
        }

        responseData.setData(service.saveOrUpdate(dto));

        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {

        ResponseData<ContactDto> responseData = new ResponseData<>();

        responseData.setData(service.loadByUUID(id));

        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.deleteByUUID(id);
    }
}
