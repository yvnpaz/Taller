package repository.frameworks.repositoryManagerImpl;

import repository.boundaries.implementManager.RepositoryCacheModelManager;
import repository.entities.ModelRepo;
import repository.frameworks.RepositoryManagerFactory;
import repository.frameworks.jdbc.managers.model.cacheModel.ManagerCacheModelService;

public class RepositoryCacheModelManagerImpl implements RepositoryCacheModelManager {

	private final ManagerCacheModelService managerCacheModelService;
	
	public RepositoryCacheModelManagerImpl() {
		this.managerCacheModelService = RepositoryManagerFactory.getManagerCacheModelService();
	}

	@Override
	public ModelRepo insertCacheModelRepoManager(ModelRepo modelRepo) {
		ModelRepo modelRepoToRet = managerCacheModelService.insertCacheModelRepoManage(modelRepo);
		return modelRepoToRet;
	}
}
