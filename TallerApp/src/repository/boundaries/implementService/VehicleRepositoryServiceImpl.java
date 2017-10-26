package repository.boundaries.implementService;

import domain.boundaries.RepositoryService.VehicleRepositoryService;
import domain.configurations.Conversion;
import domain.entities.Vehicle;
import repository.boundaries.implementManager.RepositoryManager;
import repository.entities.VehicleRepo;
import repository.frameworks.RepositoryManagerFactory;

public class VehicleRepositoryServiceImpl implements VehicleRepositoryService {

	private final RepositoryManager repositoryManager;
	
	public VehicleRepositoryServiceImpl() {
		this.repositoryManager = RepositoryManagerFactory.getRepositoryManager();
	}
	
	@Override
	public void guardar(Vehicle vehicle) {
		VehicleRepo vehicleRepo = buildVehicle(vehicle);
		repositoryManager.guardarVehicleRepo(vehicleRepo);
	}

	@Override
	public void editar(Vehicle vehicle) {
		VehicleRepo vehicleRepo = buildVehicle(vehicle);
		repositoryManager.editarVehicleRepo(vehicleRepo);
	}

	@Override
	public void ver(Vehicle vehicle) {
		VehicleRepo vehicleRepo = buildVehicle(vehicle);
		repositoryManager.verVehicleRepo(vehicleRepo);
	}

	public VehicleRepo buildVehicle(Vehicle vehicle){
		VehicleRepo vehicleRepo = new VehicleRepo(vehicle.getLicensePlate(), Conversion.toBrandRepo(vehicle.getBrand()),
				Conversion.toModelRepo(vehicle.getModel()));
		return vehicleRepo;
	}
}
