package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inventory")
@Getter
@Setter
public class Inventory extends Audit {

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

}
