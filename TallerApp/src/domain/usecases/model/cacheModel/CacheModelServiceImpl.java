package domain.usecases.model.cacheModel;

import domain.boundaries.ManagerRepositoryCache.CacheModelRepositoryService;
import domain.boundaries.Services.CacheService.CacheModelService;
import domain.entities.Model;
import repository.boundaries.RepositoryFactory;

public class CacheModelServiceImpl implements CacheModelService {

	
	private final CacheModelRepositoryService cacheModelRepositoryService;
	
	public CacheModelServiceImpl() {
		this.cacheModelRepositoryService = RepositoryFactory.getCacheModelRepositoryService();
	}

	@Override
	public Model insertCache(Model model) {
		return this.cacheModelRepositoryService.insertCacheClientRepo(model);
	}
	
}
