package app.Rest.RestFullApiExample.InventoryData.Repository;

import app.Rest.RestFullApiExample.InventoryData.Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepostory extends JpaRepository<Film,Long> {
}
