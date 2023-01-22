package app.Rest.RestFullApiExample.Helper.Implement;

public interface ServiceImpl<T>{
    public T save(T object);
    public T loadById(Long id);
    public void delete(Long id);
}
