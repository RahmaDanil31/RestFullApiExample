package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.MasterData.DTO.ActorDto;
import app.Rest.RestFullApiExample.MasterData.DTO.CategoryDto;
import app.Rest.RestFullApiExample.MasterData.Model.Actor;
import app.Rest.RestFullApiExample.MasterData.Service.ActorService;
import app.Rest.RestFullApiExample.Validation.ErrorHandling.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {

    @Autowired
    private ActorService service;

    @GetMapping
    public List<Actor> getData(){
        return service.getAllActors();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ActorDto dto, Errors errors){

        ResponseData<ActorDto> responseData = new ResponseData<>();

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

        ResponseData<ActorDto> responseData = new ResponseData<>();
        responseData.setData(service.loadById(id));

        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
