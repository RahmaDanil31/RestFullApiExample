package app.Rest.RestFullApiExample.Validation.ErrorHandling;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseData<T> {

    private String message = "succees";
    private HttpStatus status = HttpStatus.OK;
    private T data;

}
