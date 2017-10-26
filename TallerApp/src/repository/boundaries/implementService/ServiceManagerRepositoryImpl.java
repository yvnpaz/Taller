package repository.boundaries.implementService;

import domain.boundaries.ManagerRepository.ServiceManagerRepository;
import domain.configurations.Conversion;
import domain.entities.Service;
import domain.entities.WorkOrder;
import repository.entities.ServiceRepo;
import repository.entities.WorkOrderRepo;
import repository.frameworks.RepositoryManagerFactory;
import repository.frameworks.jdbc.managers.service.ManagerService;

public class ServiceManagerRepositoryImpl implements ServiceManagerRepository {

	private final ManagerService managerService;
	
	public ServiceManagerRepositoryImpl() {
		this.managerService = RepositoryManagerFactory.getManagerService();
	}
	
	@Override
	public void actualizarStateService(Service service) {
		ServiceRepo serviceRepo = buildService(service);
		this.managerService.actualizarServiceState(serviceRepo);
	}
	
	public ServiceRepo buildService(Service service)
	{
		ServiceRepo serviceRepo = Conversion.toService(service);
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
