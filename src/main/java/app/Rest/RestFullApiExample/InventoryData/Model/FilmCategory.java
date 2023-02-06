package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import app.Rest.RestFullApiExample.MasterData.Model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film_category")
@Getter
@Setter
public class FilmCategory extends Audit {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmCategory)) return false;

        FilmCategory that = (FilmCategory) o;

        return getCategory() != null ? getCategory().equals(that.getCategory()) : that.getCategory() == null;
    }

    @Override
    public int hashCode() {
        return getCategory() != null ? getCategory().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "category=" + category +
                '}';
    }
}
