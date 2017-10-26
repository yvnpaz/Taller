package main.app.managers.vehicle;

import domain.boundaries.Services.ManagementService;
import domain.configurations.TallerFactory;
import domain.entities.Vehicle;
import main.app.boundaries.servicesMain.ManagementMainService;

public class ManagementVehicleMainServiceImpl implements ManagementMainService<Vehicle> {

	private final ManagementService<Vehicle> managementVehicleMainService;
	
	public ManagementVehicleMainServiceImpl() {
		this.managementVehicleMainService = TallerFactory.getVehicleService();
	}
	
	@Override
	public void insert(Vehicle vehicle) {
		this.managementVehicleMainService.insert(vehicle);
	}

	@Override
	public void update(Vehicle vehicle) {
		this.managementVehicleMainService.update(vehicle);
	}

	@Override
	public void load(Vehicle vehicle) {
		this.managementVehicleMainService.load(vehicle);
	}

}
