package domain.usecases.services.managerWorkOrder;

import domain.entities.WorkOrder;

public interface ManagerWorkOrderService {

    void addRequest(WorkOrder workOrder);
    
	void updateStateWorkOrder(WorkOrder workOrder);
	
}
