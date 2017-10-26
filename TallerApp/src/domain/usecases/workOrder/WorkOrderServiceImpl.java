package domain.usecases.workOrder;

import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Logger;

import domain.boundaries.RepositoryService.WorkOrderRepositoryService;
import domain.boundaries.Services.WorkOrderService;
import domain.entities.Client;
import domain.entities.Service;
import domain.entities.StateWorkOrder;
import domain.entities.Vehicle;
import domain.entities.WorkOrder;
import repository.boundaries.RepositoryFactory;

public class WorkOrderServiceImpl implements WorkOrderService {

	private final Logger LOG = Logger.getLogger(WorkOrderServiceImpl.class.getName());
	private final WorkOrderRepositoryService workOrderRepositoryService;

	public WorkOrderServiceImpl() {
		this.workOrderRepositoryService = RepositoryFactory.getWorkOrderRepositoryService();
	}

	@Override
	public WorkOrder newWorkOrder(Client client, Vehicle vehicle, List<Service> service,
			StateWorkOrder stateWorkOrderState) {

		LOG.info(MessageFormat.format("Cliente: {0}", client));
		LOG.info(MessageFormat.format("Vehiculo {0}", vehicle));
		LOG.info(MessageFormat.format("Estado: {0}", stateWorkOrderState));
		
		WorkOrder newWorkOrder = workOrderRepositoryService.nuevaWorkOrder(client, vehicle, service, stateWorkOrderState);

		LOG.info(MessageFormat.format("Cliente: {0}", newWorkOrder.getClient()));
		LOG.info(MessageFormat.format("Vehiculo: {0}", newWorkOrder.getVehicle()));
		LOG.info(MessageFormat.format("Estado: {0}", newWorkOrder.getStateWorkOrderState()));
		return newWorkOrder;
	}

	@Override
	public void cancelWorkOrder(WorkOrder workOrder) {
		workOrderRepositoryService.cancelarWorkOrder(workOrder);
	}

}
