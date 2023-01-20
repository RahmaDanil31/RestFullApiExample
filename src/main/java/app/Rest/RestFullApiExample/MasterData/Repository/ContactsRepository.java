package app.Rest.RestFullApiExample.MasterData.Repository;

import app.Rest.RestFullApiExample.MasterData.Model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, UUID> {
}