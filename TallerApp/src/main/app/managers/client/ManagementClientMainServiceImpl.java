package main.app.managers.client;

import domain.boundaries.Services.ManagementService;
import domain.configurations.TallerFactory;
import domain.entities.Client;
import main.app.boundaries.servicesMain.ManagementMainService;

public class ManagementClientMainServiceImpl implements ManagementMainService<Client> {

	private final ManagementService<Client> managementServiceDOM;
	
	public ManagementClientMainServiceImpl() {
		this.managementServiceDOM = TallerFactory.getClientService();
	}
	
	@Override
	public void insert(Client client) {
		this.managementServiceDOM.insert(client);
	}

	@Override
	public void update(Client client) {
		this.managementServiceDOM.update(client);
	}

	@Override
	public void load(Client client) {
		this.managementServiceDOM.load(client);
	}

}
