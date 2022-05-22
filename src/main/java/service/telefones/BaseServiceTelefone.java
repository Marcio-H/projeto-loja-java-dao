package service.telefones;

import java.util.List;


public interface BaseServiceTelefone<T> {
	public void createOrUpdate(T objeto);
	public List<T> read();
	public T readById(Long id);
}
