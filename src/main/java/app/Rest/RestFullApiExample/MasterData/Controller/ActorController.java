package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.MasterData.Model.Actor;
import app.Rest.RestFullApiExample.MasterData.Service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
