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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address1 = (Address) o;

        if (getAddress() != null ? !getAddress().equals(address1.getAddress()) : address1.getAddress() != null)
            return false;
        if (getAddress2() != null ? !getAddress2().equals(address1.getAddress2()) : address1.getAddress2() != null)
            return false;
        if (getDistrict() != null ? !getDistrict().equals(address1.getDistrict()) : address1.getDistrict() != null)
            return false;
        if (getCity() != null ? !getCity().equals(address1.getCity()) : address1.getCity() != null) return false;
        if (getPostalCode() != null ? !getPostalCode().equals(address1.getPostalCode()) : address1.getPostalCode() != null)
            return false;
        return getPhone() != null ? getPhone().equals(address1.getPhone()) : address1.getPhone() == null;
    }

    @Override
    public int hashCode() {
        int result = getAddress() != null ? getAddress().hashCode() : 0;
        result = 31 * result + (getAddress2() != null ? getAddress2().hashCode() : 0);
        result = 31 * result + (getDistrict() != null ? getDistrict().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getPostalCode() != null ? getPostalCode().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' +
                '}';
    }
}
