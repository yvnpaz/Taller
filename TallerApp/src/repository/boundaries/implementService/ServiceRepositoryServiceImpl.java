package repository.boundaries.implementService;

import domain.boundaries.RepositoryService.ServiceRepositoryService;
import domain.configurations.Conversion;
import domain.entities.Client;
import domain.entities.Service;
import domain.entities.Vehicle;
import domain.entities.WorkOrder;
import repository.boundaries.RepositoryFactory;
import repository.boundaries.implementManager.RepositoryManager;
import repository.entities.ClientRepo;
import repository.entities.ServiceRepo;
import repository.entities.VehicleRepo;
import repository.entities.WorkOrderRepo;
import repository.frameworks.RepositoryManagerFactory;

public class ServiceRepositoryServiceImpl implements ServiceRepositoryService {

	private final RepositoryManager repositoryManager;
	
	public ServiceRepositoryServiceImpl() {
		this.repositoryManager = RepositoryManagerFactory.getRepositoryManager();
	}
	
	@Override
	public void guardar(Client client, Vehicle vehicle, Service service) {
		ServiceRepo serviceRepo = Conversion.toService(service);
		ClientRepo clientRepo = Conversion.buildToClientRepo(client);
		VehicleRepo vehicleRepo = Conversion.buildToVehicleRepo(vehicle);
		repositoryManager.guardarServiceRepo(clientRepo, vehicleRepo, serviceRepo);
	}

	@Override
	public void editar(Service service) {
		ServiceRepo serviceRepo = buildService(service);
		repositoryManager.editarServiceRepo(serviceRepo);
	}

	@Override
	public void ver(Service service) {
		ServiceRepo serviceRepo = buildService(service);
		repositoryManager.verServiceRepo(serviceRepo);
	}
	
	public ServiceRepo buildService(Service service)
	{
		ServiceRepo serviceRepo = Conversion.toService(service);
		return serviceRepo = new ServiceRepo(serviceRepo.getServiceTypeRepo(), 
				serviceRepo.getStateServiceRepo());
	}
	
	public ServiceRepo buildServiceVer(Service service)
	{
		ServiceRepo serviceRepo = Conversion.toServiceRepo(null,service);
		return serviceRepo = new ServiceRepo(serviceRepo.getServiceTypeRepo(), 
				serviceRepo.getStateServiceRepo());
	}

	public WorkOrderRepo buildWorkOrder(WorkOrder workOrder)
	{
		WorkOrderRepo workOrderRepo = Conversion.toWorkOrderRepo(workOrder);
		return workOrderRepo = new WorkOrderRepo(workOrderRepo.getListServiceRepo(), workOrderRepo.getClientRepo(), 
				workOrderRepo.getVehicleRepo(), workOrderRepo.getStateWorkOrderStateRepo()); 
		
	}
}
