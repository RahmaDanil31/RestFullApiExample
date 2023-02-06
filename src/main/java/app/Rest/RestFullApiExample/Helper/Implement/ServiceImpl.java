package app.Rest.RestFullApiExample.Helper.Implement;

public interface ServiceImpl<T> extends ServiceImplForUUID<T>{
    public T saveOrUpdate(T object);
    public T loadById(Long id);
    public void delete(Long id);

}
