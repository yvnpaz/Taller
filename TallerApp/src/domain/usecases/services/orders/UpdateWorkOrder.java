package domain.usecases.services.orders;

import java.text.MessageFormat;
import java.util.logging.Logger;

import domain.boundaries.Services.WorkOrderService;
import domain.configurations.Configuration;
import domain.entities.WorkOrder;
import domain.usecases.CaseUse;
import domain.usecases.services.managerWorkOrder.ManagerWorkOrderService;

public class UpdateWorkOrder implements CaseUse<Void> {

	private final Logger LOG = Logger.getLogger(UpdateWorkOrder.class.getName());

//	private WorkOrderService repositoryWorkOrder;
	private ManagerWorkOrderService repositoryManagerWorkOrder;
	private WorkOrder workOrder;
	
	public UpdateWorkOrder(WorkOrder workOrder) {
		super();
//		this.repositoryWorkOrder = Configuration.getWorkOrderServiceUpdate();
		this.repositoryManagerWorkOrder = Configuration.getManagerWorkOrder();
		this.workOrder = workOrder;
		
	}

	@Override
	public Void execute() {
		
		LOG.info(MessageFormat.format("{0};{1}", this.repositoryManagerWorkOrder, this.workOrder));
		repositoryManagerWorkOrder.updateStateWorkOrder(workOrder);
		return null;
	}

}
