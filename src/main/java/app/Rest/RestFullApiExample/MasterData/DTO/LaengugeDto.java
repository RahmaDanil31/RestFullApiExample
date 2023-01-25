package app.Rest.RestFullApiExample.MasterData.DTO;

import app.Rest.RestFullApiExample.Helper.Model.AuditDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LaengugeDto extends AuditDto {

    @NotBlank
    @Size(min = 3)
    private String name;

}
