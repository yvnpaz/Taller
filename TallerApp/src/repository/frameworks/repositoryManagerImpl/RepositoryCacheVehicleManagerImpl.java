package repository.frameworks.repositoryManagerImpl;

import repository.boundaries.implementManager.RepositoryCacheVehicleManager;
import repository.entities.VehicleRepo;
import repository.frameworks.RepositoryManagerFactory;
import repository.frameworks.jdbc.managers.vehicle.cacheVehicle.ManagerCacheVehicleService;

public class RepositoryCacheVehicleManagerImpl implements RepositoryCacheVehicleManager {

	private final ManagerCacheVehicleService managerCacheVehicleService;
	
	public RepositoryCacheVehicleManagerImpl() {
		this.managerCacheVehicleService = RepositoryManagerFactory.getManagerCacheVehicleService();
	}

	@Override
	public VehicleRepo insertCacheVehicleRepoManager(VehicleRepo vehicleRepo) {
		VehicleRepo vehicleRepoToRet = managerCacheVehicleService.insertCacheVehicleRepoManage(vehicleRepo);
		
		return vehicleRepoToRet;
	}
	
	
}
