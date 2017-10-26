package main.app.managers.brand.cacheBrand;

import domain.boundaries.Services.CacheService.CacheBrandService;
import domain.configurations.TallerFactory;
import domain.entities.Brand;
import main.app.boundaries.servicesMain.cachesMain.CacheBrandMainService;

public class ManagerCacheBrandMainServiceImpl implements CacheBrandMainService {

	private final CacheBrandService cacheBrandMainService;
	
	public ManagerCacheBrandMainServiceImpl() {
		this.cacheBrandMainService = TallerFactory.getCacheBrandService();
	}
	
	@Override
	public Brand insertBrandMainCache(Brand brand) {
		return this.cacheBrandMainService.insertBrand(brand);
	}

}
