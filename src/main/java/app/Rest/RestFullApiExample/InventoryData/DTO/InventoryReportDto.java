package app.Rest.RestFullApiExample.InventoryData.DTO;

import app.Rest.RestFullApiExample.InventoryData.Model.Film;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryReportDto {

    @JsonIncludeProperties(value = { "title"})
    private Film film;

    private BigDecimal cost;
}
