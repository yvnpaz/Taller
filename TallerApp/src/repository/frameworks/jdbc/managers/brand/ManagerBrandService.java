package repository.frameworks.jdbc.managers.brand;

import repository.entities.BrandRepo;

public interface ManagerBrandService {

	public void guardarBrandRepoManage(BrandRepo brandRepo);
	public void editarBrandRepoManage(BrandRepo brandRepo);
	public void verBrandRepoManage(BrandRepo brandRepo);
}
