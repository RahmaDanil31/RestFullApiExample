package app.Rest.RestFullApiExample.InventoryData.Repository;

import app.Rest.RestFullApiExample.InventoryData.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
