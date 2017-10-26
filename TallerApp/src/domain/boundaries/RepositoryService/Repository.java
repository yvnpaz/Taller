package domain.boundaries.RepositoryService;

public interface Repository<E> {
	
	void guardar(E entity);
	
	void editar(E entity);
	
	void ver(E entity);

}
