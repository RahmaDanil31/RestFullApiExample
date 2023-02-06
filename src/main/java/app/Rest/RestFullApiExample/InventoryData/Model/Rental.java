package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rental)) return false;

        Rental rental = (Rental) o;

        if (getRentalDate() != null ? !getRentalDate().equals(rental.getRentalDate()) : rental.getRentalDate() != null)
            return false;
        if (getReturnDate() != null ? !getReturnDate().equals(rental.getReturnDate()) : rental.getReturnDate() != null)
            return false;
        if (getInventory() != null ? !getInventory().equals(rental.getInventory()) : rental.getInventory() != null)
            return false;
        if (getCustomer() != null ? !getCustomer().equals(rental.getCustomer()) : rental.getCustomer() != null)
            return false;
        return getStaff() != null ? getStaff().equals(rental.getStaff()) : rental.getStaff() == null;
    }

    @Override
    public int hashCode() {
        int result = getRentalDate() != null ? getRentalDate().hashCode() : 0;
        result = 31 * result + (getReturnDate() != null ? getReturnDate().hashCode() : 0);
        result = 31 * result + (getInventory() != null ? getInventory().hashCode() : 0);
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        result = 31 * result + (getStaff() != null ? getStaff().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", customer=" + customer +
                '}';
    }
}
