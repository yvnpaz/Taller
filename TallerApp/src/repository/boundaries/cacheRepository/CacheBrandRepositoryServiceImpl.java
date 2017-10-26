package repository.boundaries.cacheRepository;

import domain.boundaries.ManagerRepositoryCache.CacheBrandRepositoryService;
import domain.configurations.Conversion;
import domain.entities.Brand;
import repository.boundaries.implementManager.RepositoryCacheBrandManager;
import repository.entities.BrandRepo;
import repository.frameworks.RepositoryManagerFactory;

public class CacheBrandRepositoryServiceImpl implements CacheBrandRepositoryService {


	private final RepositoryCacheBrandManager repositoryCacheBrandManager;
	
	public CacheBrandRepositoryServiceImpl() {
		this.repositoryCacheBrandManager = RepositoryManagerFactory.getRepositoryManagerCacheBrandService();
	}

	@Override
	public Brand insertCacheClientRepo(Brand brand) {
		BrandRepo brandRepo = Conversion.toBrandRepo(brand);
		BrandRepo brandRepoToRet = repositoryCacheBrandManager.insertCacheBrandRepoManager(brandRepo);
		Brand brandToRet = Conversion.toBrand(brandRepoToRet);
		
		return brandToRet;
	}
	
}
