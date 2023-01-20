package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "rental")
@Getter
@Setter
public class Rental extends Audit {

    @Column(name = "rental_date")
    private Date rentalDate;

    @Column(name = "return_date")
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;


}
