package app.Rest.RestFullApiExample.InventoryData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
@Getter
@Setter
public class Inventory extends Audit {

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;

        Inventory inventory = (Inventory) o;

        if (getFilm() != null ? !getFilm().equals(inventory.getFilm()) : inventory.getFilm() != null) return false;
        return getStore() != null ? getStore().equals(inventory.getStore()) : inventory.getStore() == null;
    }

    @Override
    public int hashCode() {
        int result = getFilm() != null ? getFilm().hashCode() : 0;
        result = 31 * result + (getStore() != null ? getStore().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "film=" + film +
                ", store=" + store +
                '}';
    }
}
