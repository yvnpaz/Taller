package domain.usecases.services.managerWorkOrder;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import domain.boundaries.ManagerRepository.WorkOrderManagerRepository;
import domain.entities.WorkOrder;
import domain.usecases.ManagerFactory;

public class ManagerWorkOrderServiceImpl implements ManagerWorkOrderService {

	private final Logger LOG = Logger.getLogger(ManagerWorkOrderServiceImpl.class.getName());

	private final List<WorkOrder> listWorkOrder;
	private WorkOrderManagerRepository workOrderManagerRepository;
	
	public ManagerWorkOrderServiceImpl() {
		this.listWorkOrder = new ArrayList<>();
		this.workOrderManagerRepository = ManagerFactory.getWorkOrderManagerRepository();
	}

	@Override
	public void updateStateWorkOrder(WorkOrder workOrder) {

		this.workOrderManagerRepository.actualizarStateWorkOrder(workOrder);
		
	}

	@Override
	public void addRequest(WorkOrder workOrder) {
		// TODO Auto-generated method stub
		listWorkOrder.add(workOrder);
		LOG.info(MessageFormat.format("{0}", workOrder));
	}

}
