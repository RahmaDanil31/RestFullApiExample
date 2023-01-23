package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import app.Rest.RestFullApiExample.Helper.Converter.StringListConverter;
import app.Rest.RestFullApiExample.MasterData.Model.Actor;
import app.Rest.RestFullApiExample.MasterData.Model.Langauge;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "film")
@Getter
@Setter
public class Film extends Audit {

    @NotBlank
    @Size(min = 3)
    @Column(name = "title")
    private String title;

    @Size(min = 3)
    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    @Column(name = "length")
    private Integer length;

    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;

    @Column(name = "rating")
    private String rating;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Langauge langauge;

    @Convert(converter = StringListConverter.class)
    private List<String> specialFeatures;

    @Column(name = "fulltext")
    private String fullText;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @JsonManagedReference
    Set<Actor> actors;
}
