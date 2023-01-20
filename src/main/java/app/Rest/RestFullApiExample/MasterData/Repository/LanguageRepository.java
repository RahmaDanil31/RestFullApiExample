package app.Rest.RestFullApiExample.MasterData.Repository;

import app.Rest.RestFullApiExample.MasterData.Model.Langauge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Langauge,Long> {
}
