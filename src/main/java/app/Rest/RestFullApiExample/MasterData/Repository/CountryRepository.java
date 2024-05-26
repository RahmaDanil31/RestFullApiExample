package app.Rest.RestFullApiExample.MasterData.Repository;

import app.Rest.RestFullApiExample.MasterData.Filter.CategoryDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Filter.CountryDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Model.Category;
import app.Rest.RestFullApiExample.MasterData.Model.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query(value = "SELECT COUNT(c) FROM Country c WHERE c.id IS NOT NULL " +
            "AND (:#{#filter.country} IS NULL OR c.country LIKE %:#{#filter.country}%) " +
            "AND (:#{#filter.id} IS NULL OR c.id = :#{#filter.id}) " +
            "AND (:#{#filter.lastUpdate} IS NULL OR FUNCTION('TO_CHAR', c.lastUpdate, 'YYYY-MM-DD') LIKE %:#{#filter.lastUpdate}%)")
    int count(@Param("filter") CountryDtoFilter filter);


    @Query("SELECT c FROM Country c WHERE " +
            "(:#{#filter.country} IS NULL OR c.country LIKE %:#{#filter.country}%) " +
            "AND (:#{#filter.id} IS NULL OR c.id = :#{#filter.id}) " +
            "AND (:#{#filter.lastUpdate} IS NULL OR FUNCTION('TO_CHAR', c.lastUpdate, 'YYYY-MM-DD') LIKE %:#{#filter.lastUpdate}%)")
    List<Country> view(@Param("filter")CountryDtoFilter filter, Pageable pageable);

}
