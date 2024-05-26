package app.Rest.RestFullApiExample.Helper.Util;

import lombok.Builder;
import lombok.Data;

@Data
public class ResponseItem {

    private Meta meta;
    private Object items;

    @Data
    @Builder
    public static class Meta {
        private int totalItems;
        private int itemsPerPage;
        private int currentPage;
        private int totalPages;
    }

}
