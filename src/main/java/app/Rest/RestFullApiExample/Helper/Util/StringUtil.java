package app.Rest.RestFullApiExample.Helper.Util;

public class StringUtil {

    public static String convertCamelCaseToSnakeCase(String str) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";

        return str!=null ? str.replaceAll(regex, replacement).toLowerCase():null;
    }

}
