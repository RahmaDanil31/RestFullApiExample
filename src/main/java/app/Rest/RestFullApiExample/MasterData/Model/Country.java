package app.Rest.RestFullApiExample.MasterData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country extends Audit {

    @NotBlank
    @Size(min = 3)
    @Column(name = "country")
    private String country;

}
