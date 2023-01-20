package app.Rest.RestFullApiExample.MasterData.Controller;

import app.Rest.RestFullApiExample.MasterData.Model.Contacts;
import app.Rest.RestFullApiExample.MasterData.Service.ContactsService;
import app.Rest.RestFullApiExample.MasterData.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {

    @Autowired
    private ContactsService service;

    @GetMapping()
    public List<Contacts> getData(){
        return service.getAllContacts();
    }
}
