package app.Rest.RestFullApiExample.MasterData.Filter;

import app.Rest.RestFullApiExample.Helper.Util.PaginationUtil;
import lombok.Data;

@Data
public class CountryDtoFilter extends PaginationUtil {

    private Long id;

    private String lastUpdate;

    private String country;
}
