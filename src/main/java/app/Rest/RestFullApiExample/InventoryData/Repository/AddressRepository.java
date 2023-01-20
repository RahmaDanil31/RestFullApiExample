package app.Rest.RestFullApiExample.InventoryData.Repository;

import app.Rest.RestFullApiExample.InventoryData.Model.Address;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
