package domain.usecases.vehicle.cacheVehicle;

import domain.boundaries.ManagerRepositoryCache.CacheVehicleRepositoryService;
import domain.boundaries.Services.CacheService.CacheVehicleService;
import domain.entities.Vehicle;
import repository.boundaries.RepositoryFactory;

public class CacheVehicleServiceImpl implements CacheVehicleService {
	
	private final CacheVehicleRepositoryService cacheVehicleRepositoryService;
	
	public CacheVehicleServiceImpl() {
		this.cacheVehicleRepositoryService = RepositoryFactory.getCacheVehicleRepositoryService();
	}

	@Override
	public Vehicle insertCache(Vehicle vehicle) {
		return this.cacheVehicleRepositoryService.insertCacheVehicleRepo(vehicle);
	}
	
}
