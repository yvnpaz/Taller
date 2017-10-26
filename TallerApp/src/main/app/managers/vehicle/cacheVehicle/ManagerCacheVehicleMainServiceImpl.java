package main.app.managers.vehicle.cacheVehicle;

import domain.boundaries.Services.CacheService.CacheVehicleService;
import domain.configurations.TallerFactory;
import domain.entities.Vehicle;
import main.app.boundaries.servicesMain.cachesMain.CacheVehicleMainService;

public class ManagerCacheVehicleMainServiceImpl implements CacheVehicleMainService {
	
	private final CacheVehicleService cacheVehicleService;
	
	public ManagerCacheVehicleMainServiceImpl() {
		this.cacheVehicleService = TallerFactory.getCacheVehicleService();
	}

	@Override
	public Vehicle insertClientMainCache(Vehicle vehicle) {
		return this.cacheVehicleService.insertCache(vehicle);
	}

}
