package domain.boundaries.RepositoryService;

import java.util.List;

import domain.entities.Client;
import domain.entities.Service;
import domain.entities.StateWorkOrder;
import domain.entities.Vehicle;
import domain.entities.WorkOrder;

public interface WorkOrderRepositoryService  {

	public WorkOrder nuevaWorkOrder(Client client, Vehicle vehicle, List<Service> service, StateWorkOrder stateWorkOrderState);
	
	public void cancelarWorkOrder(WorkOrder workOrder);
	
}
