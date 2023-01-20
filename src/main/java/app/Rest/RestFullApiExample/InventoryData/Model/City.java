package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import app.Rest.RestFullApiExample.MasterData.Model.Category;
import app.Rest.RestFullApiExample.MasterData.Model.Country;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "city")
@Getter
@Setter
public class City extends Audit {

    @NotBlank
    @Size(min = 3)
    @Column(name = "city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
