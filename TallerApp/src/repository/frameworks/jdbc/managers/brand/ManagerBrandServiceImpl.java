package repository.frameworks.jdbc.managers.brand;

import java.sql.Connection;

import repository.entities.BrandRepo;
import repository.frameworks.RepositoryManagerFactory;
import repository.frameworks.jdbc.config.ConfigurationDB;
import repository.frameworks.jdbc.managers.brand.cacheBrand.ManagerCacheBrandService;
import repository.frameworks.jdbc.managers.brand.dao.BrandDao;

public class ManagerBrandServiceImpl implements ManagerBrandService {

	private final ManagerCacheBrandService managerCacheBrand;
	
	public ManagerBrandServiceImpl() {
		this.managerCacheBrand = RepositoryManagerFactory.getManagerCacheBrandService();
	}
	
	@Override
	public void guardarBrandRepoManage(BrandRepo brandRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		BrandDao brandDao = new BrandDao();
		
		managerCacheBrand.loadAllBrand();
		
		if(!managerCacheBrand.checkBrand(brandRepo))
		{
			brandDao.guardarBrandRepo(brandRepo, connect);
			managerCacheBrand.insertCacheBrandRepoManage(brandRepo);
		}
		else{
			System.out.println("Ya existe la marca.");
		}
	}

	@Override
	public void editarBrandRepoManage(BrandRepo brandRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		BrandDao brandDao = new BrandDao();
		brandDao.editarBrandRepo(brandRepo, connect);
	}

	@Override
	public void verBrandRepoManage(BrandRepo brandRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		BrandDao brandDao = new BrandDao();
		brandDao.verBrandRepo(brandRepo, connect);
	}
}
