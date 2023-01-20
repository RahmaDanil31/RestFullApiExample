package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import app.Rest.RestFullApiExample.MasterData.Model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "store")
@Getter
@Setter
public class Store extends Audit {

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "manager_staff_id")
    private Staff staff;

}
