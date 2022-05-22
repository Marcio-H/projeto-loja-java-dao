package dao.impl;

import java.util.List;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import dao.BaseDAO;

public abstract class BaseDAOImpl<T, ID> implements BaseDAO<T, ID> {

	private Class<T> claz;
	protected EntityManager entityManager;
	private Function<T, ID> getId;
	
	BaseDAOImpl(Class<T> claz, Function<T, ID> getId) {
		entityManager = getEntityManager();
		this.claz = claz;
		this.getId = getId;
	}

	@Override
	public T create(T object) {
		try {
	        entityManager.getTransaction().begin();
	        entityManager.persist(object);
	        entityManager.flush();
	        entityManager.clear();
	        entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
            entityManager.getTransaction().rollback();
		}
        return object;
    }

	@Override
	public List<T> read() {
		CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(claz);

		criteria.select(criteria.from(claz));
		return entityManager.createQuery(criteria).getResultList();
	}
	
	@Override
    public T read(ID id) {
		return entityManager.find(claz, id);
	}
	
	@Override
    public T update(T objeto) {
		try {
			entityManager.getTransaction().begin();
	        objeto = entityManager.merge(objeto);
	        entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
        return objeto;
	}
	
	@Override
    public void delete(T objet) {
		entityManager.getTransaction().begin();
        objet = entityManager.find(claz, getId.apply(objet));
        entityManager.remove(objet);
        entityManager.getTransaction().commit();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifsc");
		
		return factory.createEntityManager();
	}
}
