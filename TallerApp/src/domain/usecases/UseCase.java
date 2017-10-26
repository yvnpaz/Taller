package domain.usecases;

import domain.boundaries.RepositoryService.Repository;

public interface UseCase<E> {

    void execute(Repository<E> repository, E entity);
    	
}
