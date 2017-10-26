package domain.boundaries.ManagerRepository;

import domain.entities.WorkOrder;

public interface WorkOrderManagerRepository {

	void actualizarStateWorkOrder(WorkOrder workOrder);
}
