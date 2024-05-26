package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.Helper.Util.ResponseItem;
import app.Rest.RestFullApiExample.MasterData.DTO.CategoryDto;
import app.Rest.RestFullApiExample.MasterData.DTO.ContactDto;
import app.Rest.RestFullApiExample.MasterData.DTO.CountryDto;
import app.Rest.RestFullApiExample.MasterData.Filter.ContactsDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Model.Contacts;
import app.Rest.RestFullApiExample.MasterData.Service.ContactsService;
import app.Rest.RestFullApiExample.MasterData.Service.CountryService;
import app.Rest.RestFullApiExample.Validation.ErrorHandling.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {

    @Autowired
    private ContactsService service;

    @GetMapping()
    public ResponseEntity<?> get(@ModelAttribute ContactsDtoFilter filter, BindingResult bindingResult){
        ResponseData<ResponseItem> responseData = new ResponseData<>();

        if(bindingResult.hasErrors()) {
            responseData.setMessage(bindingResult.getFieldError().getDefaultMessage());
            responseData.setStatus(HttpStatus.BAD_REQUEST);

            return ResponseEntity.badRequest().body(responseData);
        }

        try {
            ResponseItem responseItem = service.get(filter);
            List<ContactDto> items = (List<ContactDto>) responseItem.getItems();

            List<EntityModel<ContactDto>> result= items.stream().map(contactDto -> EntityModel.of(contactDto,
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
                                    .findById(contactDto.getId())).withSelfRel()))
                    .toList();
            responseItem.setItems(result);

            responseData.setData(responseItem);
            responseData.setStatus(HttpStatus.OK);

            return ResponseEntity.ok(responseData);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {

        ResponseData<EntityModel<ContactDto>> responseData = new ResponseData<>();

        ContactDto contactDto = service.loadByUUID(id);

        EntityModel<ContactDto> contacts = EntityModel.of(contactDto,
                linkTo(methodOn(this.getClass()).get(null, null)).withRel("contacts"));

        responseData.setData(contacts);

        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  delete(@PathVariable UUID id){
        service.deleteByUUID(id);
        return ResponseEntity.noContent().build();
    }
}
