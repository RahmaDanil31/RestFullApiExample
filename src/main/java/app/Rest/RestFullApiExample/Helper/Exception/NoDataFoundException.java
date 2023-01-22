package app.Rest.RestFullApiExample.Helper.Exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {

        super("No data found");
    }
}
