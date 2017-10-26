package repository.frameworks.jdbc.managers.workOrder;

import java.util.Map;

import domain.entities.WorkOrder;
import repository.entities.WorkOrderRepo;

public interface ManagerWorkOrder {

	public WorkOrderRepo nuevaWorkOrder(WorkOrder workORder);

	public void cancelarWorkOrder(WorkOrderRepo workOrder);
	
	public void actualizarWorkOrderState(WorkOrderRepo workOrder);
	
}
