package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer extends Audit {

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

    @Column(name = "active_bool")
    private boolean activeBool;

    @Column(name = "active")
    private Integer active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    @CreatedDate
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

}
