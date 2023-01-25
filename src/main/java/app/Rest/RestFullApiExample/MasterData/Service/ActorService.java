package app.Rest.RestFullApiExample.MasterData.Service;

import app.Rest.RestFullApiExample.Helper.Exception.NoDataFoundException;
import app.Rest.RestFullApiExample.Helper.Implement.ServiceImpl;
import app.Rest.RestFullApiExample.Helper.Mapper.ObjectHelper;
import app.Rest.RestFullApiExample.MasterData.DTO.ActorDto;
import app.Rest.RestFullApiExample.MasterData.Model.Actor;
import app.Rest.RestFullApiExample.MasterData.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActorService implements ServiceImpl<ActorDto> {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }

    @Override
    public ActorDto saveOrUpdate(ActorDto object) {
        Actor actor = ObjectHelper.convert(object,Actor.class);
        return ObjectHelper.convert(actorRepository.save(actor),ActorDto.class);
    }

    @Override
    public ActorDto loadById(Long id) {
        return ObjectHelper.convert(actorRepository.findById(id).orElseThrow(()-> new NoDataFoundException()),ActorDto.class);
    }

    @Override
    public ActorDto loadByUUID(UUID uuid) {
        return null;
    }

    @Override
    public void delete(Long id) {
        actorRepository.deleteById(id);
    }

    @Override
    public void deleteByUUID(UUID uuid) {

    }
}
