package domain.usecases.client.cacheClient;

import domain.boundaries.ManagerRepositoryCache.CacheClientRepositoryService;
import domain.boundaries.Services.CacheService.CacheClientService;
import domain.entities.Client;
import repository.boundaries.RepositoryFactory;

public class CacheClientServiceImpl implements CacheClientService {

	private final CacheClientRepositoryService cacheClientRepository;
	
	public CacheClientServiceImpl() {
		this.cacheClientRepository = RepositoryFactory.getCacheClientRepositoryService();
	}
	
	@Override
	public Client insertCache(Client client) {
		return this.cacheClientRepository.insertCacheClientRepo(client);
	}
}
