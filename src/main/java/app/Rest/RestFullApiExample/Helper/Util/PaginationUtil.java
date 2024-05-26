package app.Rest.RestFullApiExample.Helper.Util;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Min;
import java.util.Arrays;

@Data
public class PaginationUtil{

    @Min(value = 1, message = "Current page must be greater than or equal to 1")
    private int currentPage = 1;

    @Min(value = 1, message = "Items per page must be greater than or equal to 1")
    private int itemsPerPage = 10;

    private String sortBy = "id";
    private SortDirection sortDirection = SortDirection.ASC;

    public Pageable buildPage(boolean natifQuery){
        Sort sort= Sort.by(sortDirection.equals(SortDirection.ASC)? Sort.Direction.ASC: Sort.Direction.DESC,getSortBy(natifQuery));

        return PageRequest.of(this.currentPage - 1, this.itemsPerPage, sort);
    }

    public String getSortBy(boolean natifQuery) {

        boolean fieldExists;

        if(!natifQuery) {
          fieldExists = Arrays.stream(super.getClass().getDeclaredFields())
                    .anyMatch(field -> field.getName().equals(sortBy));
        }else
            fieldExists = Arrays.stream(super.getClass().getDeclaredFields())
                    .anyMatch(field -> StringUtil.convertCamelCaseToSnakeCase(field.getName()).equals(StringUtil.convertCamelCaseToSnakeCase(sortBy)));

        if (fieldExists) {
            return sortBy;
        } else {
            throw new IllegalArgumentException("Field " + sortBy + " does not exist in superclass.");
        }
    }
}
