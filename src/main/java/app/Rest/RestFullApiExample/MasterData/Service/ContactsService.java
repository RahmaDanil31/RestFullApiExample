package app.Rest.RestFullApiExample.MasterData.Service;

import app.Rest.RestFullApiExample.Helper.Exception.NoDataFoundException;
import app.Rest.RestFullApiExample.Helper.Implement.ServiceImpl;
import app.Rest.RestFullApiExample.Helper.Mapper.ObjectHelper;
import app.Rest.RestFullApiExample.Helper.Util.ResponseItem;
import app.Rest.RestFullApiExample.MasterData.DTO.ContactDto;
import app.Rest.RestFullApiExample.MasterData.DTO.CountryDto;
import app.Rest.RestFullApiExample.MasterData.Filter.ContactsDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Filter.CountryDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Model.Contacts;
import app.Rest.RestFullApiExample.MasterData.Repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactsService implements ServiceImpl<ContactDto> {

    @Autowired
    private ContactsRepository contactsRepository;

    public ResponseItem get(ContactsDtoFilter filter){
        int count = contactsRepository.count(filter);
        ResponseItem responseItem = new ResponseItem();

        responseItem.setMeta(ResponseItem.Meta.builder()
                .totalItems(count)
                .currentPage(filter.getCurrentPage())
                .itemsPerPage(filter.getItemsPerPage())
                .totalPages((int) Math.ceil((float) count / filter.getItemsPerPage()))
                .build());

        List<ContactDto> contactDtos = ObjectHelper.convertList(contactsRepository.view(filter,filter.buildPage(false)), ContactDto.class);

        responseItem.setItems(contactDtos);

        return responseItem;
    }

    @Override
    public ContactDto saveOrUpdate(ContactDto object) {
        Contacts contacts = ObjectHelper.convert(object,Contacts.class);
        return ObjectHelper.convert(contactsRepository.save(contacts),ContactDto.class);
    }

    @Override
    public ContactDto loadById(Long id) {
        return null;
    }

    @Override
    public ContactDto loadByUUID(UUID id) {
        return ObjectHelper.convert(contactsRepository.findById(id).orElseThrow(()-> new NoDataFoundException()),ContactDto.class);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteByUUID(UUID uuid) {
        contactsRepository.deleteById(uuid);
    }
}
