package repository.boundaries.cacheRepository;

import java.util.logging.Logger;

import domain.boundaries.ManagerRepositoryCache.CacheClientRepositoryService;
import domain.configurations.Conversion;
import domain.entities.Client;
import repository.boundaries.implementManager.RepositoryCacheClientManager;
import repository.entities.ClientRepo;
import repository.frameworks.RepositoryManagerFactory;

public class CacheClientRepositoryServiceImpl implements CacheClientRepositoryService {

	private final Logger LOG = Logger.getLogger(CacheClientRepositoryServiceImpl.class.getName());
	
	private final RepositoryCacheClientManager repositoryCacheClientManager;
	
	public CacheClientRepositoryServiceImpl() {
		this.repositoryCacheClientManager = RepositoryManagerFactory.getRepositoryManagerCacheClientService();
	}

	@Override
	public Client insertCacheClientRepo(Client client) {
		
		ClientRepo clientRepo = Conversion.buildToClientRepo(client);
		ClientRepo clientRepoToRet = repositoryCacheClientManager.insertCacheClientRepoManager(clientRepo);
		Client clientToRet = Conversion.buildToClient(clientRepoToRet);
		
		return clientToRet;
	}
}
