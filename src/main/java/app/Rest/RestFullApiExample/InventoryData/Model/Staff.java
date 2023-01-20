package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

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

}
