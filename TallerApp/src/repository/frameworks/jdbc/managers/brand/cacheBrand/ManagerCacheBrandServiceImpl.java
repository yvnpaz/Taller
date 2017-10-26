package repository.frameworks.jdbc.managers.brand.cacheBrand;

import java.sql.Connection;
import java.util.Iterator;

import repository.configurationRepo.caches.CacheBrandRepo;
import repository.entities.BrandRepo;
import repository.frameworks.jdbc.config.ConfigurationDB;
import repository.frameworks.jdbc.managers.brand.dao.BrandDao;

public class ManagerCacheBrandServiceImpl implements ManagerCacheBrandService {

	CacheBrandRepo<Integer, BrandRepo> cacheBrandRepo = new CacheBrandRepo<>();

	@Override
	public BrandRepo insertCacheBrandRepoManage(BrandRepo brandRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();

		BrandDao brandDao = new BrandDao();
		BrandRepo brandRepoToret = brandDao.insertBrandRepoInCache(brandRepo, connect);
		return brandRepoToret;
	}

	@Override
	public boolean checkBrand(BrandRepo brandRepo) {
		Iterator<Integer> itr = cacheBrandRepo.keySet().iterator();
		boolean thisOne = false;

		while (itr.hasNext()) {
			int itrCode = itr.next();
			BrandRepo brand = cacheBrandRepo.get(itrCode);
			if (brand.equals(brandRepo)) {
				thisOne = true;
			}
		}
		return thisOne;
	}

	@Override
	public void loadAllBrand() {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();

		BrandDao brandDao = new BrandDao();

		cacheBrandRepo = brandDao.cargarBrandRepo(connect);

	}

}
