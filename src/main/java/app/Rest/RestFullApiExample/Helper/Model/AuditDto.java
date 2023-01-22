package app.Rest.RestFullApiExample.Helper.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AuditDto {
    private Long id;
    private Date updatedAt;
}
