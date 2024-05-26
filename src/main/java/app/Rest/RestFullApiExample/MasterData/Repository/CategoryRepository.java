package app.Rest.RestFullApiExample.MasterData.Repository;

import app.Rest.RestFullApiExample.MasterData.Filter.CategoryDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Model.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT COUNT(c) FROM Category c WHERE c.id IS NOT NULL " +
            "AND (:#{#filter.name} IS NULL OR c.name LIKE %:#{#filter.name}%) " +
            "AND (:#{#filter.id} IS NULL OR c.id = :#{#filter.id}) " +
            "AND (:#{#filter.lastUpdate} IS NULL OR FUNCTION('TO_CHAR', c.lastUpdate, 'YYYY-MM-DD') LIKE %:#{#filter.lastUpdate}%)")
    int count(@Param("filter")CategoryDtoFilter filter);


    @Query("SELECT c FROM Category c WHERE " +
            "(:#{#filter.name} IS NULL OR c.name LIKE %:#{#filter.name}%) " +
            "AND (:#{#filter.id} IS NULL OR c.id = :#{#filter.id}) " +
            "AND (:#{#filter.lastUpdate} IS NULL OR FUNCTION('TO_CHAR', c.lastUpdate, 'YYYY-MM-DD') LIKE %:#{#filter.lastUpdate}%)")
    List<Category> view(@Param("filter")CategoryDtoFilter filter,Pageable pageable);

}
