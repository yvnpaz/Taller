package main.app.managers.service;

import domain.boundaries.Services.ServiceService;
import domain.configurations.TallerFactory;
import domain.entities.Client;
import domain.entities.Service;
import domain.entities.Vehicle;
import main.app.boundaries.servicesMain.service.ServiceServiceMain;

public class ManagerServiceMainServiceImpl implements ServiceServiceMain {

	private final ServiceService serviceService;
	
	public ManagerServiceMainServiceImpl() {
		this.serviceService = TallerFactory.getServiceService();
	}
	
	@Override
	public void insert(Client client, Vehicle vehicle, Service service) {
		this.serviceService.insert(client, vehicle, service);
	}

	@Override
	public void edit(Service service) {
		this.serviceService.update(service);
	}

	@Override
	public void load(Service service) {
		// TODO Auto-generated method stub
		
	}

}
