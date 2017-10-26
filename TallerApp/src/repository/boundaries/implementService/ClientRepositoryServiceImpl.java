package repository.boundaries.implementService;

import java.text.MessageFormat;
import java.util.logging.Logger;

import domain.boundaries.RepositoryService.ClientRepositoryService;
import domain.entities.Client;
import repository.boundaries.implementManager.RepositoryManager;
import repository.entities.ClientRepo;
import repository.frameworks.RepositoryManagerFactory;

public class ClientRepositoryServiceImpl implements ClientRepositoryService {

	private final RepositoryManager repositoryManager;
	private final Logger LOG = Logger.getLogger(ClientRepositoryServiceImpl.class.getName());
	
	public ClientRepositoryServiceImpl()
	{
		this.repositoryManager = RepositoryManagerFactory.getRepositoryManager();
	}

	@Override
	public void guardar(Client client) {
		
		LOG.info(MessageFormat.format("Entro guardar: {0} **", client));
		ClientRepo clientRepo = buildClient(client);
		repositoryManager.guardarClientRepo(clientRepo);
		
		LOG.info(MessageFormat.format("Salgo guardar: {0} **", clientRepo));
	}
	
	@Override
	public void editar(Client client) {
		LOG.info(MessageFormat.format("Entro editar: {0} **", client));
		
		ClientRepo clientRepo = buildClient(client);
		repositoryManager.editarClientRepo(clientRepo);
		
		LOG.info(MessageFormat.format("Salgo editar: {0} **", client));
	}

	@Override
	public void ver(Client client) {
		
		LOG.info(MessageFormat.format("Entro ver: {0} **", client));
		
		ClientRepo clientRepo = buildClient(client);
		repositoryManager.verClientRepo(clientRepo);
		
		LOG.info(MessageFormat.format("Salgo ver: {0} **", client));
	}
	
	public ClientRepo buildClient(Client client)
	{
		ClientRepo clientRepo = new ClientRepo(client.getDni(), client.getName(), client.getLastName(), client.getEmail());
		return clientRepo;
	}

}
