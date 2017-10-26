package repository.frameworks.jdbc.managers.brand.cacheBrand;

import repository.entities.BrandRepo;

public interface ManagerCacheBrandService {

	public BrandRepo insertCacheBrandRepoManage(BrandRepo brandRepo);
	
	public void loadAllBrand();
	
	public boolean checkBrand(BrandRepo brandRepo);
}
