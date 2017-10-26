package main.app.managers.client.cacheClient;

import domain.boundaries.Services.CacheService.CacheClientService;
import domain.configurations.TallerFactory;
import domain.entities.Client;
import main.app.boundaries.servicesMain.cachesMain.CacheClientMainService;

public class ManagerCacheClientMainServiceImpl implements CacheClientMainService {

	private final CacheClientService cacheClientServiceDom;
	
	public ManagerCacheClientMainServiceImpl() {
		this.cacheClientServiceDom = TallerFactory.getCacheClientService();
	}
	
	@Override
	public Client insertClientMainCache(Client client) {
		return this.cacheClientServiceDom.insertCache(client);
	}

}
