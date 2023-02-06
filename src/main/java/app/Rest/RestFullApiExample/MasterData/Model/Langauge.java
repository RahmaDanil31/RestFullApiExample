package app.Rest.RestFullApiExample.MasterData.Model;

import app.Rest.RestFullApiExample.Helper.Model.Audit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "language")
@Getter
@Setter
public class Langauge extends Audit {

    @NotBlank
    @Size(min = 3)
    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Langauge)) return false;

        Langauge langauge = (Langauge) o;

        return getName() != null ? getName().equals(langauge.getName()) : langauge.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Langauge{" +
                "name='" + name + '\'' +
                '}';
    }
}
