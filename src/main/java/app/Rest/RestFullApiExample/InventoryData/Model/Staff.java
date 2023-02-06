package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "staff")
@Getter
@Setter
public class Staff extends Audit {

    @NotBlank
    @Size(min = 3)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 3)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(min = 3)
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(min = 3)
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(min = 3)
    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy="staff")
    private Set<Store> stores;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;

        Staff staff = (Staff) o;

        if (isActive() != staff.isActive()) return false;
        if (getFirstName() != null ? !getFirstName().equals(staff.getFirstName()) : staff.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(staff.getLastName()) : staff.getLastName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(staff.getEmail()) : staff.getEmail() != null) return false;
        if (getUsername() != null ? !getUsername().equals(staff.getUsername()) : staff.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(staff.getPassword()) : staff.getPassword() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(staff.getAddress()) : staff.getAddress() != null) return false;
        return getStores() != null ? getStores().equals(staff.getStores()) : staff.getStores() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getStores() != null ? getStores().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
