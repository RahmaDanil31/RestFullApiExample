package app.Rest.RestFullApiExample.Helper.Implement;

import java.util.UUID;

public interface ServiceImplForUUID <T>{

    default public T loadByUUID(UUID uuid) {
        return null;
    }

    default public void deleteByUUID(UUID uuid) {}
}
