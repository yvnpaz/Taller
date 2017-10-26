package domain.boundaries.RepositoryService;

import domain.entities.Vehicle;

public interface VehicleRepositoryService extends Repository<Vehicle> {

	@Override
	void guardar(Vehicle vehicle);
	
	@Override
	void editar(Vehicle vehicle);
	
	@Override
	void ver(Vehicle vehicle);
	
}
