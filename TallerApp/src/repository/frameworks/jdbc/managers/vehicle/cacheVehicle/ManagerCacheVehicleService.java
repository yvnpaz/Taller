package repository.frameworks.jdbc.managers.vehicle.cacheVehicle;

import repository.entities.VehicleRepo;

public interface ManagerCacheVehicleService {

	public VehicleRepo insertCacheVehicleRepoManage(VehicleRepo vehicleRepo);

	public void loadAllVehicle();

	public boolean checkVehicle(VehicleRepo vehicleRepo);
}
