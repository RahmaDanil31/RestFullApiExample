package app.Rest.RestFullApiExample.InventoryData.Repository;

import app.Rest.RestFullApiExample.InventoryData.DTO.InventoryReportDto;
import app.Rest.RestFullApiExample.InventoryData.Filter.InventoryFilter;
import app.Rest.RestFullApiExample.InventoryData.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    @Query("SELECT new app.Rest.RestFullApiExample.InventoryData.DTO.InventoryReportDto(inv.film, SUM(inv.film.replacementCost)) FROM Inventory inv WHERE (:#{#filter.film} IS NULL OR inv.film.id = :#{#filter.film}) AND (:#{#filter.store} IS NULL OR inv.store.id = :#{#filter.store}) GROUP BY inv.film")
    List<InventoryReportDto> report(@Param("filter") InventoryFilter filter);

}
