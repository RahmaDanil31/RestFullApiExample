package app.Rest.RestFullApiExample.InventoryData.Repository;

import app.Rest.RestFullApiExample.InventoryData.Model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Long> {
}
