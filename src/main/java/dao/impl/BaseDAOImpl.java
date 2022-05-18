package dao.impl;

import java.util.List;

import dao.BaseDAO;

public abstract class BaseDAOImpl<T, ID> implements BaseDAO<T, ID> {

	@Override
	public T create(T object) {
        return null;
    }

	@Override
	public List<T> read() {
		return null;
	}
	
	@Override
    public T read(ID id) {
		return null;
	}
	
	@Override
    public T update(T objeto) {
		return null;
	}
	
	@Override
    public void delete(T objeto) {
		
	}
}
