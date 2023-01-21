package app.Rest.RestFullApiExample.MasterData.DTO;

import app.Rest.RestFullApiExample.Helper.Model.DtoId;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CategoryDto extends DtoId {

    @NotEmpty(message = "name cannot empty")
    @Size(min=3,message = "category name minimum 3 character ")
    private String name;
}
