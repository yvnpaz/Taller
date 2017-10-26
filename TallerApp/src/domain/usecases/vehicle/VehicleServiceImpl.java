package domain.usecases.vehicle;

import domain.boundaries.RepositoryService.VehicleRepositoryService;
import domain.boundaries.Services.ManagementService;
import domain.entities.Vehicle;
import domain.usecases.commons.Insert;
import domain.usecases.commons.Load;
import domain.usecases.commons.Update;
import repository.boundaries.RepositoryFactory;

public class VehicleServiceImpl implements ManagementService<Vehicle> {

	
	private final VehicleRepositoryService vehicleRepository;
	
	public VehicleServiceImpl()
	{
		this.vehicleRepository = RepositoryFactory.getVehicleRepositoryService();
	}

	@Override
	public void insert(Vehicle vehicle) {
		new Insert<Vehicle>().execute(vehicleRepository, vehicle);
	}
	@Override
	public void update(Vehicle vehicle) {
		new Update<Vehicle>().execute(vehicleRepository, vehicle);
	}
	@Override
	public void load(Vehicle vehicle) {
		new Load<Vehicle>().execute(vehicleRepository, vehicle);
	}

}
