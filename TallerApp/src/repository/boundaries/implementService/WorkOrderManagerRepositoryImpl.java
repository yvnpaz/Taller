package repository.boundaries.implementService;

import domain.boundaries.ManagerRepository.WorkOrderManagerRepository;
import domain.configurations.Conversion;
import domain.entities.WorkOrder;
import repository.entities.WorkOrderRepo;
import repository.frameworks.RepositoryManagerFactory;
import repository.frameworks.jdbc.managers.workOrder.ManagerWorkOrder;

public class WorkOrderManagerRepositoryImpl implements WorkOrderManagerRepository {

	private final ManagerWorkOrder managerWorkOrder;
	
	public WorkOrderManagerRepositoryImpl() {
		this.managerWorkOrder = RepositoryManagerFactory.getManagerWorkOrder();
	}
	
	@Override
	public void actualizarStateWorkOrder(WorkOrder workOrder) {
		
		WorkOrderRepo workOrderRepo = buildWorkOrder(workOrder);
		this.managerWorkOrder.actualizarWorkOrderState(workOrderRepo);	
	}
	
	public WorkOrderRepo buildWorkOrder(WorkOrder workOrder)
	{
		WorkOrderRepo workOrderRepo = Conversion.toWorkOrderRepo(workOrder);
		return workOrderRepo = new WorkOrderRepo(workOrderRepo.getListServiceRepo(), workOrderRepo.getClientRepo(), 
				workOrderRepo.getVehicleRepo(), workOrderRepo.getStateWorkOrderStateRepo()); 
		
	}

}
