package main.app.managers.workOrder;

import java.util.List;

import domain.boundaries.Services.WorkOrderService;
import domain.configurations.TallerFactory;
import domain.entities.Client;
import domain.entities.Service;
import domain.entities.StateWorkOrder;
import domain.entities.Vehicle;
import domain.entities.WorkOrder;
import main.app.boundaries.servicesMain.workOrder.WorkOrderMainService;

public class ManagerWorkOrderMainServiceImpl implements WorkOrderMainService {

	private final WorkOrderService workOrderService;
	
	public ManagerWorkOrderMainServiceImpl() {
		this.workOrderService = TallerFactory.getWorkService();
	}

	@Override
	public WorkOrder newWorkOrder(Client client, Vehicle vehicle, List<Service> service,
			StateWorkOrder stateWorkOrder) {
		return this.workOrderService.newWorkOrder(client, vehicle, service, stateWorkOrder);
	}
}
