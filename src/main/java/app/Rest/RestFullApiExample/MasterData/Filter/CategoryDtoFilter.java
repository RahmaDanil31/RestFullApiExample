package app.Rest.RestFullApiExample.MasterData.Filter;

import app.Rest.RestFullApiExample.Helper.Util.PaginationUtil;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CategoryDtoFilter extends PaginationUtil {
    private Long id;

    private String lastUpdate;

    @Pattern(regexp = "[a-zA-Z]+", message = "Name must contain only letters")
    private String name;

}
