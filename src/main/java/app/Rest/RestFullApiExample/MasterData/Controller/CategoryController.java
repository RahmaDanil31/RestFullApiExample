package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.Helper.Util.ResponseItem;
import app.Rest.RestFullApiExample.MasterData.DTO.CategoryDto;
import app.Rest.RestFullApiExample.MasterData.Filter.CategoryDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Model.Category;
import app.Rest.RestFullApiExample.MasterData.Service.CategoryService;
import app.Rest.RestFullApiExample.Validation.ErrorHandling.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController{

    private final CategoryService service;

    @GetMapping()
    public ResponseEntity<?> get(@Valid @ModelAttribute CategoryDtoFilter filter, BindingResult bindingResult){

        ResponseData<ResponseItem> responseData = new ResponseData<>();

        if(bindingResult.hasErrors()) {
            responseData.setMessage(bindingResult.getFieldError().getDefaultMessage());
            responseData.setStatus(HttpStatus.BAD_REQUEST);

            return ResponseEntity.badRequest().body(responseData);
        }
        try {
            ResponseItem responseItem = service.get(filter);
            List<CategoryDto> items = (List<CategoryDto>) responseItem.getItems();

            List<EntityModel<CategoryDto>> result= items.stream().map(categoryDto -> EntityModel.of(categoryDto,
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
                                    .findById(categoryDto.getId())).withSelfRel()))
                    .toList();
            responseItem.setItems(result);

            responseData.setData(responseItem);
            responseData.setStatus(HttpStatus.OK);

            return ResponseEntity.ok(responseData);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @ModelAttribute CategoryDto dto, BindingResult bindingResult){

        ResponseData<CategoryDto> responseData = new ResponseData<>();

        if(bindingResult.hasErrors()) {
            responseData.setMessage(bindingResult.getFieldError().getDefaultMessage());
            responseData.setStatus(HttpStatus.BAD_REQUEST);
            return new ResponseEntity(responseData, HttpStatus.BAD_REQUEST);
        }

        responseData.setData(service.saveOrUpdate(dto));

        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        ResponseData<EntityModel<CategoryDto>> responseData = new ResponseData<>();

        CategoryDto categoryDto = service.loadById(id);

        EntityModel<CategoryDto> categories = EntityModel.of(categoryDto,
                linkTo(methodOn(this.getClass()).get(null, null)).withRel("categories"));

        responseData.setData(categories);

        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
