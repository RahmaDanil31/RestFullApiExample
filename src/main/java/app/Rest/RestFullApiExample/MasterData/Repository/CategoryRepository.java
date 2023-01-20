package app.Rest.RestFullApiExample.MasterData.Repository;

import app.Rest.RestFullApiExample.MasterData.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
