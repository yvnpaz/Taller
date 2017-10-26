package repository.frameworks.repositoryManagerImpl;

import java.util.logging.Logger;

import repository.boundaries.implementManager.RepositoryCacheClientManager;
import repository.entities.ClientRepo;
import repository.frameworks.RepositoryManagerFactory;
import repository.frameworks.jdbc.managers.client.cacheClient.ManagerCacheClientService;

public class RepositoryCacheClientManagerImpl implements RepositoryCacheClientManager {

	private static final Logger LOG = Logger.getLogger(RepositoryManagerImpl.class.getName());
	
	private final ManagerCacheClientService managerCacheClientService;
	
	public RepositoryCacheClientManagerImpl() {
		this.managerCacheClientService = RepositoryManagerFactory.getManagerCacheClientService();
	}

	@Override
	public ClientRepo insertCacheClientRepoManager(ClientRepo clientRepo) {
		ClientRepo clientRepoToRet = managerCacheClientService.insertCacheClientRepoManage(clientRepo);
		
		return clientRepoToRet;
	}

}
