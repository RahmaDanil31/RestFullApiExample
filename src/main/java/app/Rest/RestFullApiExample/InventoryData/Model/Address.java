package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address extends Audit {

    @Size(min = 3)
    @Column(name = "address")
    private String address;

    @Size(min = 3)
    @Column(name = "address2")
    private String address2;

    @Size(min = 3)
    @Column(name = "district")
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Size(min = 3)
    @Column(name = "postal_code")
    private String postalCode;

    @Size(min = 3)
    @Column(name = "phone")
    private String phone;

}
