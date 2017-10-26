package domain.usecases.services.orders;

import java.text.MessageFormat;
import java.util.logging.Logger;

import domain.boundaries.Services.ServiceService;
import domain.boundaries.Services.WorkOrderService;
import domain.configurations.Configuration;
import domain.entities.Service;
import domain.entities.WorkOrder;
import domain.usecases.CaseUse;
import domain.usecases.services.managerService.ManagerServiceService;

public class UpdateService implements CaseUse<Void> {

	private final Logger LOG = Logger.getLogger(UpdateService.class.getName());
	
	private WorkOrderService repositoryService;
	private ManagerServiceService repositoryManagerService;
	private Service service;
	private WorkOrder workOrder;

	public UpdateService(Service service) {
		super();
		this.repositoryService = Configuration.getWorkOrderServiceUpdate();
		this.service = service;
		this.workOrder = workOrder;
	}
	
	@Override
	public Void execute() {
		LOG.info(MessageFormat.format("**{0}--{1}--{2}**", this.repositoryManagerService));
		repositoryManagerService.updateStateService(this.service);
		return null;
	}
}
