package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.Helper.Mapper.ObjectHelper;
import app.Rest.RestFullApiExample.MasterData.DTO.CategoryDto;
import app.Rest.RestFullApiExample.MasterData.Model.Category;
import app.Rest.RestFullApiExample.MasterData.Service.CategoryService;
import app.Rest.RestFullApiExample.Validation.ErrorHandling.ResponseData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping()
    public List<Category> getData(){
        return service.getAllCategories();
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody CategoryDto dto, Errors errors){

        ResponseData<Category> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            responseData.setDefaultMessage(errors.getFieldError().getDefaultMessage());
            responseData.setStatus(false);
            return new ResponseEntity(responseData, HttpStatus.BAD_REQUEST);
        }

        responseData.setPayload(service.save(ObjectHelper.convert(dto,Category.class)));

        return ResponseEntity.ok(responseData);
    }
}
