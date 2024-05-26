package app.Rest.RestFullApiExample.MasterData.DTO;

import app.Rest.RestFullApiExample.Helper.Model.AuditDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@Setter
@Getter
public class CategoryDto extends AuditDto {

    @NotNull
    @NotEmpty(message = "name cannot empty")
    @Size(min=3,message = "category name minimum 3 character ")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryDto)) return false;

        CategoryDto that = (CategoryDto) o;

        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "name='" + name + '\'' +
                '}';
    }


}
