package app.Rest.RestFullApiExample.Helper.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class AuditDto {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime lastUpdate;

}
