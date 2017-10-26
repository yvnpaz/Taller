package domain.usecases.brand;

import domain.boundaries.RepositoryService.BrandRepositoryService;
import domain.boundaries.Services.ManagementService;
import domain.configurations.Configuration;
import domain.entities.Brand;
import domain.usecases.commons.Insert;
import domain.usecases.commons.Load;
import domain.usecases.commons.Update;
import repository.boundaries.RepositoryFactory;

public class BrandServiceImpl implements ManagementService<Brand> {

	private final BrandRepositoryService brandRepository;
	
	public BrandServiceImpl() {
//		this.brandRepository = Configuration.getBrandRepository();
		this.brandRepository = RepositoryFactory.getBrandRepositoryService();
	}
	
	@Override
	public void insert(Brand brand) {
		new Insert<Brand>().execute(brandRepository, brand);
	}

	@Override
	public void update(Brand brand) {
		new Update<Brand>().execute(brandRepository, brand);
	}

	@Override
	public void load(Brand brand) {
		new Load<Brand>().execute(brandRepository, brand);
	}

}
