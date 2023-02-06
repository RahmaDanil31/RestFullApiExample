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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;

        Film film = (Film) o;

        if (getTitle() != null ? !getTitle().equals(film.getTitle()) : film.getTitle() != null) return false;
        if (getDescription() != null ? !getDescription().equals(film.getDescription()) : film.getDescription() != null)
            return false;
        if (getReleaseYear() != null ? !getReleaseYear().equals(film.getReleaseYear()) : film.getReleaseYear() != null)
            return false;
        if (getRentalDuration() != null ? !getRentalDuration().equals(film.getRentalDuration()) : film.getRentalDuration() != null)
            return false;
        if (getRentalRate() != null ? !getRentalRate().equals(film.getRentalRate()) : film.getRentalRate() != null)
            return false;
        if (getLength() != null ? !getLength().equals(film.getLength()) : film.getLength() != null) return false;
        if (getReplacementCost() != null ? !getReplacementCost().equals(film.getReplacementCost()) : film.getReplacementCost() != null)
            return false;
        if (getRating() != null ? !getRating().equals(film.getRating()) : film.getRating() != null) return false;
        if (getLangauge() != null ? !getLangauge().equals(film.getLangauge()) : film.getLangauge() != null)
            return false;
        if (getSpecialFeatures() != null ? !getSpecialFeatures().equals(film.getSpecialFeatures()) : film.getSpecialFeatures() != null)
            return false;
        if (getFullText() != null ? !getFullText().equals(film.getFullText()) : film.getFullText() != null)
            return false;
        return getActors() != null ? getActors().equals(film.getActors()) : film.getActors() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getReleaseYear() != null ? getReleaseYear().hashCode() : 0);
        result = 31 * result + (getRentalDuration() != null ? getRentalDuration().hashCode() : 0);
        result = 31 * result + (getRentalRate() != null ? getRentalRate().hashCode() : 0);
        result = 31 * result + (getLength() != null ? getLength().hashCode() : 0);
        result = 31 * result + (getReplacementCost() != null ? getReplacementCost().hashCode() : 0);
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        result = 31 * result + (getLangauge() != null ? getLangauge().hashCode() : 0);
        result = 31 * result + (getSpecialFeatures() != null ? getSpecialFeatures().hashCode() : 0);
        result = 31 * result + (getFullText() != null ? getFullText().hashCode() : 0);
        result = 31 * result + (getActors() != null ? getActors().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
