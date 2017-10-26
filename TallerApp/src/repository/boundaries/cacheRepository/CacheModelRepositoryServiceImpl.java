package repository.boundaries.cacheRepository;

import domain.boundaries.ManagerRepositoryCache.CacheModelRepositoryService;
import domain.configurations.Conversion;
import domain.entities.Model;
import repository.boundaries.implementManager.RepositoryCacheModelManager;
import repository.entities.ModelRepo;
import repository.frameworks.RepositoryManagerFactory;

public class CacheModelRepositoryServiceImpl implements CacheModelRepositoryService {
	
	private final RepositoryCacheModelManager repositoryCacheModelManager;
	
	public CacheModelRepositoryServiceImpl() {
		this.repositoryCacheModelManager = RepositoryManagerFactory.getRepositoryManagerCacheModelService();
	}

	@Override
	public Model insertCacheClientRepo(Model model) {
		ModelRepo modelRepo = Conversion.toModelRepo(model);
		ModelRepo modelRepoToRet = repositoryCacheModelManager.insertCacheModelRepoManager(modelRepo);
		Model modelToRet = Conversion.toModel(modelRepoToRet);
		
		return modelToRet;
	}

}
