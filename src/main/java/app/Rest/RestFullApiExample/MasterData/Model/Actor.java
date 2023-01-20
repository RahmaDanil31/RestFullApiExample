package app.Rest.RestFullApiExample.MasterData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import app.Rest.RestFullApiExample.InventoryData.Model.Film;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

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
