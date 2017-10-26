package repository.frameworks.jdbc.managers.service;

import repository.entities.ClientRepo;
import repository.entities.ServiceRepo;
import repository.entities.VehicleRepo;
import repository.entities.WorkOrderRepo;

public interface ManagerService {

	public void guardarServiceRepoManage(ClientRepo clientRepo, VehicleRepo vehicleRepo, ServiceRepo serviceRepo);
	public void editarServiceRepoManage(ServiceRepo serviceRepo);
	public void verServiceRepoManage(ServiceRepo serviceRepo);
	public void actualizarServiceState(ServiceRepo serviceRepo);
	
}
