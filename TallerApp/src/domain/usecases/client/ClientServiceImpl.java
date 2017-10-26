package domain.usecases.client;

import domain.boundaries.RepositoryService.ClientRepositoryService;
import domain.boundaries.Services.ManagementService;
import domain.entities.Client;
import domain.usecases.commons.Insert;
import domain.usecases.commons.Load;
import domain.usecases.commons.Update;
import repository.boundaries.RepositoryFactory;

public class ClientServiceImpl implements ManagementService<Client> {

	private final ClientRepositoryService clientRepository;
	
	public ClientServiceImpl()
	{
		this.clientRepository = RepositoryFactory.getClientRepositoryService();
	}

	@Override
	public void insert(Client client) {
		Insert<Client> insertClient = new Insert<Client>();
		insertClient.execute(clientRepository, client);
	}
	
	@Override
	public void update(Client client) {
		new Update<Client>().execute(clientRepository, client);
	}

	@Override
	public void load(Client client) {
		new Load<Client>().execute(clientRepository, client);
	}
	
}
