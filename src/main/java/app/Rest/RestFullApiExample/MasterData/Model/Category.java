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
@Table(name = "category")
@Getter
@Setter
public class Category extends Audit {

    @NotBlank
    @Size(min = 3)
    @Column(name = "name")
    private String name;
}
