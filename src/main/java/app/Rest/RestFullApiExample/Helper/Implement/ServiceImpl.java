package app.Rest.RestFullApiExample.Helper.Implement;

public interface ServiceImpl<T>{
    public T save(T object);
    public T edit(T object);
    public void delete(Long id);
}
