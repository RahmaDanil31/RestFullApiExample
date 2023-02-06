package app.Rest.RestFullApiExample.MasterData.DTO;

import app.Rest.RestFullApiExample.Helper.Model.AuditDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CountryDto extends AuditDto {

    @NotBlank
    @Size(min = 3)
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryDto)) return false;

        CountryDto that = (CountryDto) o;

        return getCountry() != null ? getCountry().equals(that.getCountry()) : that.getCountry() == null;
    }

    @Override
    public int hashCode() {
        return getCountry() != null ? getCountry().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "country='" + country + '\'' +
                '}';
    }
}
