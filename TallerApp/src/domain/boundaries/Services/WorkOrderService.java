package domain.boundaries.Services;

import java.util.List;

import domain.entities.Client;
import domain.entities.Service;
import domain.entities.StateWorkOrder;
import domain.entities.Vehicle;
import domain.entities.WorkOrder;

public interface WorkOrderService {

	public WorkOrder newWorkOrder(Client client, Vehicle vehicle, List<Service> service, StateWorkOrder stateWorkOrderState);
	
	public void cancelWorkOrder(WorkOrder workOrder);
	
//	public void updateWorkOrderState(WorkOrder workOrder);
	
}
