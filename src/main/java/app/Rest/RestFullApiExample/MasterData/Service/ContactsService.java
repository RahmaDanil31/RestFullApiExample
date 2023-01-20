package app.Rest.RestFullApiExample.MasterData.Service;

import app.Rest.RestFullApiExample.MasterData.Model.Contacts;
import app.Rest.RestFullApiExample.MasterData.Repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

    public List<Contacts> getAllContacts(){
        return contactsRepository.findAll();
    }
}
