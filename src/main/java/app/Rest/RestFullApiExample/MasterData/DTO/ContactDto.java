package app.Rest.RestFullApiExample.MasterData.DTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
public class ContactDto {
    private UUID id;

    @NotBlank
    @Size(min = 3)
    private String firstName;

    @NotBlank
    @Size(min = 3)
    private String lastName;

    @NotBlank
    @Email(message="Please provide a valid email address")
    private String email;

    @NotBlank
    @Size(min = 3)
    private String phone;
}
