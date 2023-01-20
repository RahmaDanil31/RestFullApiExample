package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import app.Rest.RestFullApiExample.MasterData.Model.Category;
import app.Rest.RestFullApiExample.MasterData.Model.Country;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "film_category")
@Getter
@Setter
public class FilmCategory extends Audit {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
