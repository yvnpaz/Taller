package repository.frameworks.jdbc.managers.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import repository.entities.ClientRepo;
import repository.entities.ServiceRepo;
import repository.entities.VehicleRepo;
import repository.entities.WorkOrderRepo;
import repository.frameworks.jdbc.config.ConfigurationDB;
import repository.frameworks.jdbc.managers.service.dao.ServiceDao;
import repository.frameworks.jdbc.managers.workOrder.dao.WorkOrderDao;

public class ManagerServiceImpl implements ManagerService {

	private static int numIdWorkOrderActive=0;
	
	@Override
	public void guardarServiceRepoManage(ClientRepo clientRepo, VehicleRepo vehicleRepo, ServiceRepo serviceRepo) {
		Map<Integer, WorkOrderRepo> mapWork = new HashMap<>();
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();	
		
		WorkOrderDao workOrderDao = new WorkOrderDao();
		mapWork = workOrderDao.cargarWorkOrderRepo(clientRepo, vehicleRepo, connect);
		
		Iterator<Entry<Integer, WorkOrderRepo>> it = mapWork.entrySet().iterator();

		while (it.hasNext()) {
			 Entry<Integer, WorkOrderRepo> e = it.next();
			 numIdWorkOrderActive = e.getKey();
			}
		
		ServiceDao serviceDao = new ServiceDao();
		serviceDao.guardarServiceRepo(numIdWorkOrderActive, serviceRepo, connect);
	}

	@Override
	public void editarServiceRepoManage(ServiceRepo serviceRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		ServiceDao serviceDao = new ServiceDao();
		serviceDao.editarServiceRepo(serviceRepo, connect);
	}

	@Override
	public void verServiceRepoManage(ServiceRepo serviceRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		ServiceDao serviceDao = new ServiceDao();
		serviceDao.verServiceRepo(serviceRepo, connect);
	}

	@Override
	public void actualizarServiceState(ServiceRepo serviceRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		ServiceDao serviceDao = new ServiceDao();

		serviceDao.actualizarEstadoServiceRepo(numIdWorkOrderActive, serviceRepo, connect);
	}

}
