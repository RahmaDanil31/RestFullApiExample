package app.Rest.RestFullApiExample.MasterData.Repository;

import app.Rest.RestFullApiExample.MasterData.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
