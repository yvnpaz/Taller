package main.app.managers.model;

import domain.boundaries.Services.ManagementService;
import domain.configurations.TallerFactory;
import domain.entities.Model;
import main.app.boundaries.servicesMain.ManagementMainService;

public class ManagementModelMainServiceImpl implements ManagementMainService<Model> {

	private final ManagementService<Model> managementServiceDOM;
	
	public ManagementModelMainServiceImpl() {
		this.managementServiceDOM = TallerFactory.getModelService();
	}
	
	@Override
	public void insert(Model model) {
		this.managementServiceDOM.insert(model);
	}

	@Override
	public void update(Model model) {
		this.managementServiceDOM.update(model);
	}

	@Override
	public void load(Model model) {
		this.managementServiceDOM.load(model);
	}
}
