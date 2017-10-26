package domain.usecases.services.managerService;

import java.util.logging.Logger;

import domain.boundaries.ManagerRepository.ServiceManagerRepository;
import domain.entities.Service;
import domain.entities.WorkOrder;
import domain.usecases.ManagerFactory;

public class ManagerServiceServiceImpl implements ManagerServiceService {

	private final Logger LOG = Logger.getLogger(ManagerServiceServiceImpl.class.getName());
	private ServiceManagerRepository serviceManagerRepository;
	
	public ManagerServiceServiceImpl() {
		this.serviceManagerRepository = ManagerFactory.getServiceManagerRepository();
	}
	
	@Override
	public void updateStateService(Service service) {
		
		this.serviceManagerRepository.actualizarStateService(service);
		
	}
}
