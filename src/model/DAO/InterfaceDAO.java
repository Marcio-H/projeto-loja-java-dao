package model.DAO;

import java.util.List;

public interface InterfaceDAO<T> {
    
    abstract void create(T objeto);
    abstract List<T> read();
    abstract T read(int codigo);
    abstract void update(T objeto);
    abstract void delete(T objeto);
}
