package dao;

import java.util.List;

public interface BaseDAO<T, ID> {
    
    public T create(T objeto);
    public List<T> read();
    public T read(ID id) ;
    public T update(T objeto);
    public void delete(T objeto);
}
