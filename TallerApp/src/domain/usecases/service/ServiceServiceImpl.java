package domain.usecases.service;


import java.text.MessageFormat;
import java.util.logging.Logger;

import domain.boundaries.RepositoryService.ServiceRepositoryService;
import domain.boundaries.Services.ServiceService;
import domain.entities.Client;
import domain.entities.Service;
import domain.entities.Vehicle;
import domain.usecases.workOrder.WorkOrderServiceImpl;
import repository.boundaries.RepositoryFactory;

public class ServiceServiceImpl implements ServiceService {

	private final Logger LOG = Logger.getLogger(WorkOrderServiceImpl.class.getName());
	private final ServiceRepositoryService serviceRepository;
	
	public ServiceServiceImpl() {
		this.serviceRepository = RepositoryFactory.getServiceRepositoryService();
	}

	@Override
	public void insert(Client client, Vehicle vehicle, Service service) {

		LOG.info(MessageFormat.format("Service: {0}", service));
		
		serviceRepository.guardar(client, vehicle, service);
	}

	@Override
	public void update(Service service) {

		LOG.info(MessageFormat.format("Service: {0}", service));
		
		serviceRepository.editar(service);
	}

	@Override
	public void ver(Service service) {
		LOG.info(MessageFormat.format("Service: {0}", service));
		serviceRepository.ver(service);
		
	}
}
