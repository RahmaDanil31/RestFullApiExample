package app.Rest.RestFullApiExample.MasterData.DTO;

import app.Rest.RestFullApiExample.Helper.Model.AuditDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Data
@Setter
@Getter
public class CategoryDto extends AuditDto {

    @NotNull
    @NotEmpty(message = "name cannot empty")
    @Size(min=3,message = "category name minimum 3 character ")
    private String name;
}
