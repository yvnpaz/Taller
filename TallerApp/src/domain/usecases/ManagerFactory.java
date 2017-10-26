package domain.usecases;

import domain.boundaries.ManagerRepository.ServiceManagerRepository;
import domain.boundaries.ManagerRepository.WorkOrderManagerRepository;
import repository.boundaries.implementService.ServiceManagerRepositoryImpl;
import repository.boundaries.implementService.WorkOrderManagerRepositoryImpl;

public class ManagerFactory {
	
	private static ServiceManagerRepository serviceRepositoryManager  = null;
	private static WorkOrderManagerRepository workOrderRepositoryManager  = null;
	
	public static ServiceManagerRepository getServiceManagerRepository() {
		if (serviceRepositoryManager == null) {
			serviceRepositoryManager = new ServiceManagerRepositoryImpl();
		}

		return serviceRepositoryManager;
	}
	
	public static WorkOrderManagerRepository getWorkOrderManagerRepository() {
		if (workOrderRepositoryManager == null) {
			workOrderRepositoryManager = new WorkOrderManagerRepositoryImpl();
		}

		return workOrderRepositoryManager;
	}
	
}
