package main.app.boundaries.servicesMain.workOrder;

import java.util.List;

import domain.entities.Client;
import domain.entities.Service;
import domain.entities.StateWorkOrder;
import domain.entities.Vehicle;
import domain.entities.WorkOrder;

public interface WorkOrderMainService {

	WorkOrder newWorkOrder(Client client, Vehicle vehicle, List<Service> service, StateWorkOrder stateWorkOrder);
	
}
