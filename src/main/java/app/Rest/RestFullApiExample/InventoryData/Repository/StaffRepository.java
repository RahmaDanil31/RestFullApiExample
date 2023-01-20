package app.Rest.RestFullApiExample.InventoryData.Repository;

import app.Rest.RestFullApiExample.InventoryData.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
