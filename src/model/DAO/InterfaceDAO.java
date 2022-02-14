package model.DAO;

import java.util.List;

public interface InterfaceDAO<T> {
    
    abstract T create(T objeto);
    abstract List<T> read();
    abstract T read(Long codigo);
    abstract T update(T objeto);
    abstract void delete(T objeto);
}
