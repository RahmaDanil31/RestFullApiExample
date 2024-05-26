package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.Helper.Util.ResponseItem;
import app.Rest.RestFullApiExample.MasterData.DTO.CategoryDto;
import app.Rest.RestFullApiExample.MasterData.DTO.ContactDto;
import app.Rest.RestFullApiExample.MasterData.DTO.CountryDto;
import app.Rest.RestFullApiExample.MasterData.Filter.CountryDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Model.Country;
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
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping()
    public ResponseEntity<?> get(@ModelAttribute CountryDtoFilter filter, BindingResult bindingResult){
        ResponseData<ResponseItem> responseData = new ResponseData<>();

        if(bindingResult.hasErrors()) {
            responseData.setMessage(bindingResult.getFieldError().getDefaultMessage());
            responseData.setStatus(HttpStatus.BAD_REQUEST);

            return ResponseEntity.badRequest().body(responseData);
        }

        try {
            ResponseItem responseItem = service.get(filter);
            List<CountryDto> items = (List<CountryDto>) responseItem.getItems();

            List<EntityModel<CountryDto>> result= items.stream().map(country -> EntityModel.of(country,
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
                                    .findById(country.getId())).withSelfRel()))
                    .toList();
            responseItem.setItems(result);

            responseData.setData(responseItem);
            responseData.setStatus(HttpStatus.OK);

            return ResponseEntity.ok(responseData);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ResponseData<EntityModel<CountryDto>> responseData = new ResponseData<>();

        CountryDto countryDto = service.loadById(id);

        EntityModel<CountryDto> categories = EntityModel.of(countryDto,
                linkTo(methodOn(this.getClass()).get(null, null)).withRel("countries"));

        responseData.setData(categories);

        return ResponseEntity.ok(responseData);
    }

}
