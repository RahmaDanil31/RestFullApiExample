package app.Rest.RestFullApiExample.MasterData.Repository;

import app.Rest.RestFullApiExample.MasterData.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
