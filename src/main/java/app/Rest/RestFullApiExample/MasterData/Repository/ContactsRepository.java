package app.Rest.RestFullApiExample.MasterData.Repository;

import app.Rest.RestFullApiExample.MasterData.Filter.CategoryDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Filter.ContactsDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Model.Category;
import app.Rest.RestFullApiExample.MasterData.Model.Contacts;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, UUID> {

    @Query(value = "SELECT COUNT(c) FROM Contacts c WHERE c.id IS NOT NULL " +
            "AND (:#{#filter.firstName} IS NULL OR UPPER(CAST(c.firstName AS string)) LIKE CONCAT('%', UPPER(CAST(:#{#filter.firstName} AS string)), '%')) " +
            "AND (:#{#filter.lastName} IS NULL OR UPPER(CAST(c.lastName AS string)) LIKE CONCAT('%', UPPER(CAST(:#{#filter.lastName} AS string)), '%')) " +
            "AND (:#{#filter.email} IS NULL OR UPPER(CAST(c.email AS string)) LIKE CONCAT('%', UPPER(CAST(:#{#filter.email} AS string)), '%')) " +
            "AND (:#{#filter.phone} IS NULL OR UPPER(CAST(c.phone AS string)) LIKE CONCAT('%', UPPER(CAST(:#{#filter.phone} AS string)), '%')) " +
            "AND (:#{#filter.id} IS NULL OR c.id = :#{#filter.id})")
    int count(@Param("filter") ContactsDtoFilter filter);


    @Query(value = "SELECT c FROM Contacts c WHERE c.id IS NOT NULL " +
            "AND (:#{#filter.firstName} IS NULL OR UPPER(CAST(c.firstName AS string)) LIKE CONCAT('%', UPPER(CAST(:#{#filter.firstName} AS string)), '%')) " +
            "AND (:#{#filter.lastName} IS NULL OR UPPER(CAST(c.lastName AS string)) LIKE CONCAT('%', UPPER(CAST(:#{#filter.lastName} AS string)), '%')) " +
            "AND (:#{#filter.email} IS NULL OR UPPER(CAST(c.email AS string)) LIKE CONCAT('%', UPPER(CAST(:#{#filter.email} AS string)), '%')) " +
            "AND (:#{#filter.phone} IS NULL OR UPPER(CAST(c.phone AS string)) LIKE CONCAT('%', UPPER(CAST(:#{#filter.phone} AS string)), '%')) " +
            "AND (:#{#filter.id} IS NULL OR c.id = :#{#filter.id})")
    List<Contacts> view(@Param("filter")ContactsDtoFilter filter, Pageable pageable);

}
