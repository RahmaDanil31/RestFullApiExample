package app.Rest.RestFullApiExample.MasterData.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
    @Size(min = 3)
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(min = 3)
    @Column(name = "phone")
    private String phone;

}
