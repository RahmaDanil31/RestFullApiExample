package app.Rest.RestFullApiExample.MasterData.Filter;

import app.Rest.RestFullApiExample.Helper.Util.PaginationUtil;
import lombok.Data;
import java.util.UUID;

@Data
public class ContactsDtoFilter extends PaginationUtil {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
