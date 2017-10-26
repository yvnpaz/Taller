package domain.usecases.brand.cacheBrand;

import domain.boundaries.ManagerRepositoryCache.CacheBrandRepositoryService;
import domain.boundaries.Services.CacheService.CacheBrandService;
import domain.entities.Brand;
import repository.boundaries.RepositoryFactory;

public class CacheBrandServiceImpl implements CacheBrandService {

	private final CacheBrandRepositoryService cacheBrandRepository;
	
	public CacheBrandServiceImpl() {
		this.cacheBrandRepository = RepositoryFactory.getCacheBrandRepositoryService();
	}
	
	@Override
	public Brand insertBrand(Brand brand) {
		return this.cacheBrandRepository.insertCacheClientRepo(brand);
	}

}
