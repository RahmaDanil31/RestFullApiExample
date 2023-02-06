package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;

        Store store = (Store) o;

        if (getAddress() != null ? !getAddress().equals(store.getAddress()) : store.getAddress() != null) return false;
        return getStaff() != null ? getStaff().equals(store.getStaff()) : store.getStaff() == null;
    }

    @Override
    public int hashCode() {
        int result = getAddress() != null ? getAddress().hashCode() : 0;
        result = 31 * result + (getStaff() != null ? getStaff().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Store{" +
                "address=" + address +
                ", staff=" + staff +
                '}';
    }
}
