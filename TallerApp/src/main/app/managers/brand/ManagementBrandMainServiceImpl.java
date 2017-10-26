package main.app.managers.brand;

import domain.boundaries.Services.ManagementService;
import domain.configurations.TallerFactory;
import domain.entities.Brand;
import main.app.boundaries.servicesMain.ManagementMainService;

public class ManagementBrandMainServiceImpl implements ManagementMainService<Brand> {

	private final ManagementService<Brand> managementServiceDOM;
	
	public ManagementBrandMainServiceImpl() {
		this.managementServiceDOM = TallerFactory.getBrandService();
	}
	
	@Override
	public void insert(Brand brand) {
		this.managementServiceDOM.insert(brand);
	}

	@Override
	public void update(Brand brand) {
		this.managementServiceDOM.update(brand);
	}

	@Override
	public void load(Brand brand) {
		this.managementServiceDOM.load(brand);		
	}

}
