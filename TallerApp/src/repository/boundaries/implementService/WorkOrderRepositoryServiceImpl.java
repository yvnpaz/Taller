package repository.boundaries.implementService;

import java.util.List;

import domain.boundaries.RepositoryService.WorkOrderRepositoryService;
import domain.configurations.Conversion;
import domain.entities.Client;
import domain.entities.Service;
import domain.entities.StateWorkOrder;
import domain.entities.Vehicle;
import domain.entities.WorkOrder;
import repository.boundaries.implementManager.RepositoryManager;
import repository.frameworks.RepositoryManagerFactory;

public class WorkOrderRepositoryServiceImpl implements WorkOrderRepositoryService {

	private final RepositoryManager repositoryManager;

	public WorkOrderRepositoryServiceImpl() {
		this.repositoryManager = RepositoryManagerFactory.getRepositoryManager();
	}

	@Override
	public WorkOrder nuevaWorkOrder(Client client, Vehicle vehicle, List<Service> service,
			StateWorkOrder stateWorkOrderState) {
		
		WorkOrder newWorkOrder = Conversion.BuildWorkOrder(client, vehicle, service, stateWorkOrderState);
		repositoryManager.nuevaWorkOrderRepo(newWorkOrder);
		
		return newWorkOrder;
	}

	@Override
	public void cancelarWorkOrder(WorkOrder workOrder) {

		this.repositoryManager.cancelarWorkOrder(Conversion.toWorkOrderRepo(workOrder));
	}

}
