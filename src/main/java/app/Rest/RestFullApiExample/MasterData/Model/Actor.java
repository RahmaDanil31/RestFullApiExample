package app.Rest.RestFullApiExample.MasterData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import app.Rest.RestFullApiExample.InventoryData.Model.Film;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "actor")
@Getter
@Setter
public class Actor extends Audit {

    @NotBlank
    @Size(min = 3)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 3)
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(mappedBy = "actors" , cascade = { CascadeType.ALL })
    @JsonBackReference
    private Set<Film> films;
}
