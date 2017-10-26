package main.app.managers.model.cacheModel;

import domain.boundaries.Services.CacheService.CacheModelService;
import domain.configurations.TallerFactory;
import domain.entities.Model;
import main.app.boundaries.servicesMain.cachesMain.CacheModelMainService;

public class ManagerCacheModelMainServiceImpl implements CacheModelMainService {

	private final CacheModelService cacheModelService;
	
	public ManagerCacheModelMainServiceImpl() {
		this.cacheModelService = TallerFactory.getCacheModelService();
	}
	@Override
	public Model insertModelMainCache(Model model) {
		return this.cacheModelService.insertCache(model);
	}

}
