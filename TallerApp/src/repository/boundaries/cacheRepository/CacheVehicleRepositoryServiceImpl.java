package repository.boundaries.cacheRepository;

import domain.boundaries.ManagerRepositoryCache.CacheVehicleRepositoryService;
import domain.configurations.Conversion;
import domain.entities.Vehicle;
import repository.boundaries.implementManager.RepositoryCacheVehicleManager;
import repository.entities.VehicleRepo;
import repository.frameworks.RepositoryManagerFactory;

public class CacheVehicleRepositoryServiceImpl implements CacheVehicleRepositoryService {

	private final RepositoryCacheVehicleManager repositoryCacheVehicleManager;
	
	public CacheVehicleRepositoryServiceImpl() {
		this.repositoryCacheVehicleManager = RepositoryManagerFactory.getRepositoryManagerCacheVehicleService();
	}

	@Override
	public Vehicle insertCacheVehicleRepo(Vehicle vehicle) {
		VehicleRepo vehicleRepo = Conversion.buildToVehicleRepo(vehicle);
		VehicleRepo vehicleRepoToRet = repositoryCacheVehicleManager.insertCacheVehicleRepoManager(vehicleRepo);
		Vehicle vehicleToRet = Conversion.buildToVehicle(vehicleRepoToRet);
		
		return vehicleToRet;
	}
}
