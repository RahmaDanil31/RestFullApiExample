package app.Rest.RestFullApiExample.Validation.ErrorHandling;

import lombok.*;

@Getter
@Setter
public class ResponseData<T> {

    public static final String message = "succees";

    private String defaultMessage = message;
    private boolean status = true;
    private T payload;

}
