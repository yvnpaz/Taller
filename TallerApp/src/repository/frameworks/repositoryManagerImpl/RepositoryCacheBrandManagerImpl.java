package repository.frameworks.repositoryManagerImpl;

import repository.boundaries.implementManager.RepositoryCacheBrandManager;
import repository.entities.BrandRepo;
import repository.frameworks.RepositoryManagerFactory;
import repository.frameworks.jdbc.managers.brand.cacheBrand.ManagerCacheBrandService;

public class RepositoryCacheBrandManagerImpl implements RepositoryCacheBrandManager {

	private final ManagerCacheBrandService managerCacheBrandService;
	
	public RepositoryCacheBrandManagerImpl() {
		this.managerCacheBrandService = RepositoryManagerFactory.getManagerCacheBrandService();
	}
	
	@Override
	public BrandRepo insertCacheBrandRepoManager(BrandRepo brandRepo) {
		BrandRepo brandRepoToRet = managerCacheBrandService.insertCacheBrandRepoManage(brandRepo);
		
		return brandRepoToRet;
	}

}
