package domain.usecases.commons;

import domain.boundaries.RepositoryService.Repository;
import domain.usecases.UseCase;

public class Insert<E> implements UseCase<E> {
	
	@Override
	public void execute(Repository<E> repository, E entity)
	{
		repository.guardar(entity);
	}

}
