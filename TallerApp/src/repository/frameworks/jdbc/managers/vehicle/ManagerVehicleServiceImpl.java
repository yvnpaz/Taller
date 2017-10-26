package repository.frameworks.jdbc.managers.vehicle;

import java.sql.Connection;

import repository.entities.VehicleRepo;
import repository.frameworks.RepositoryManagerFactory;
import repository.frameworks.jdbc.config.ConfigurationDB;
import repository.frameworks.jdbc.managers.vehicle.cacheVehicle.ManagerCacheVehicleService;
import repository.frameworks.jdbc.managers.vehicle.dao.VehicleDao;

public class ManagerVehicleServiceImpl implements ManagerVehicleService {

	private final ManagerCacheVehicleService managerCacheVehicle;
	
	public ManagerVehicleServiceImpl() {
		this.managerCacheVehicle = RepositoryManagerFactory.getManagerCacheVehicleService();
	}
	
	@Override
	public void guardarVehicleRepoManage(VehicleRepo vehicleRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		VehicleDao vehicleDao = new VehicleDao();
		
		managerCacheVehicle.loadAllVehicle();
		
		if(!managerCacheVehicle.checkVehicle(vehicleRepo))
		{
			vehicleDao.guardarVehicleRepo(vehicleRepo, connect);
			managerCacheVehicle.insertCacheVehicleRepoManage(vehicleRepo);
		}
		else{
			System.out.println("Ya existe el vehicle");
		}
	}

	@Override
	public void editarVehicleRepoManage(VehicleRepo vehicleRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		VehicleDao vehicleDao = new VehicleDao();
		vehicleDao.editarVehicleRepo(vehicleRepo, connect);
	}

	@Override
	public void verVehicleRepoManage(VehicleRepo vehicleRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		VehicleDao vehicleDao = new VehicleDao();
		vehicleDao.verVehicleRepo(vehicleRepo, connect);
	}
}
