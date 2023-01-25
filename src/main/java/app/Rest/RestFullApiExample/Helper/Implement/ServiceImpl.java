package app.Rest.RestFullApiExample.Helper.Implement;

import java.util.UUID;

public interface ServiceImpl<T>{
    public T saveOrUpdate(T object);
    public T loadById(Long id);
    public T loadByUUID(UUID uuid);
    public void delete(Long id);
    public void deleteByUUID(UUID uuid);
}
