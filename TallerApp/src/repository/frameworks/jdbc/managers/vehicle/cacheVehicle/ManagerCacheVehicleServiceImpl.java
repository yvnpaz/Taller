package repository.frameworks.jdbc.managers.vehicle.cacheVehicle;

import java.sql.Connection;
import java.util.Iterator;

import repository.configurationRepo.caches.CacheVehicleRepo;
import repository.entities.VehicleRepo;
import repository.frameworks.jdbc.config.ConfigurationDB;
import repository.frameworks.jdbc.managers.vehicle.dao.VehicleDao;

public class ManagerCacheVehicleServiceImpl implements ManagerCacheVehicleService {
	
	CacheVehicleRepo<String, VehicleRepo> cacheVehicleRepo = new CacheVehicleRepo<>();

	@Override
	public VehicleRepo insertCacheVehicleRepoManage(VehicleRepo vehicleRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		
		VehicleDao vehicleDao = new VehicleDao();
		VehicleRepo vehicleRepoToret = vehicleDao.insertVehicleRepoInCache(vehicleRepo, connect);
	
		return vehicleRepoToret; 
	}

	@Override
	public void loadAllVehicle() {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		
		VehicleDao vehicleDao = new VehicleDao();
		
		cacheVehicleRepo = vehicleDao.cargarVehicleRepo(connect);
	}

	@Override
	public boolean checkVehicle(VehicleRepo vehicleRepo) {

		Iterator<String> itr = cacheVehicleRepo.keySet().iterator();
		boolean thisOne = false;
		
		while(itr.hasNext())
		{
			String itrLicPlate = itr.next();
			VehicleRepo vehicle = cacheVehicleRepo.get(itrLicPlate);
			if(vehicle.equals(vehicleRepo))
			{
				thisOne = true;
			}
		}
		return thisOne;
	}
}
