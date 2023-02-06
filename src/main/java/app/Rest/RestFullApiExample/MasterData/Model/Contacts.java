package app.Rest.RestFullApiExample.MasterData.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class Contacts {

    //menambahkan uuid
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "contact_id", updatable = false, nullable = false)
    private UUID id;

    @NotBlank
    @Size(min = 3)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 3)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Email(message="Please provide a valid email address")
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(min = 3)
    @Column(name = "phone")
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacts)) return false;

        Contacts contacts = (Contacts) o;

        if (getId() != null ? !getId().equals(contacts.getId()) : contacts.getId() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(contacts.getFirstName()) : contacts.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(contacts.getLastName()) : contacts.getLastName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(contacts.getEmail()) : contacts.getEmail() != null) return false;
        return getPhone() != null ? getPhone().equals(contacts.getPhone()) : contacts.getPhone() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
