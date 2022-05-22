package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.BaseDAO;

public abstract class BaseDAOImpl<T, ID> implements BaseDAO<T, ID> {

	protected Class<T> claz;
	protected EntityManager entityManager;
	
	public BaseDAOImpl(Class<T> claz) {
		entityManager = getEntityManager();
		this.claz = claz;
	}

	@Override
	public T create(T object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.flush();
        return object;
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
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifsc");
		
		return factory.createEntityManager();
	}
}
