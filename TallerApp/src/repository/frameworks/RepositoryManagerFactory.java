package repository.frameworks;

import repository.boundaries.implementManager.RepositoryCacheBrandManager;
import repository.boundaries.implementManager.RepositoryCacheClientManager;
import repository.boundaries.implementManager.RepositoryCacheModelManager;
import repository.boundaries.implementManager.RepositoryCacheVehicleManager;
import repository.boundaries.implementManager.RepositoryManager;
import repository.frameworks.jdbc.managers.brand.ManagerBrandService;
import repository.frameworks.jdbc.managers.brand.ManagerBrandServiceImpl;
import repository.frameworks.jdbc.managers.brand.cacheBrand.ManagerCacheBrandService;
import repository.frameworks.jdbc.managers.brand.cacheBrand.ManagerCacheBrandServiceImpl;
import repository.frameworks.jdbc.managers.client.ManagerClientService;
import repository.frameworks.jdbc.managers.client.ManagerClientServiceImpl;
import repository.frameworks.jdbc.managers.client.cacheClient.ManagerCacheClientService;
import repository.frameworks.jdbc.managers.client.cacheClient.ManagerCacheClientServiceImpl;
import repository.frameworks.jdbc.managers.model.ManagerModelService;
import repository.frameworks.jdbc.managers.model.ManagerModelServiceImpl;
import repository.frameworks.jdbc.managers.model.cacheModel.ManagerCacheModelService;
import repository.frameworks.jdbc.managers.model.cacheModel.ManagerCacheModelServiceImpl;
import repository.frameworks.jdbc.managers.service.ManagerService;
import repository.frameworks.jdbc.managers.service.ManagerServiceImpl;
import repository.frameworks.jdbc.managers.vehicle.ManagerVehicleService;
import repository.frameworks.jdbc.managers.vehicle.ManagerVehicleServiceImpl;
import repository.frameworks.jdbc.managers.vehicle.cacheVehicle.ManagerCacheVehicleService;
import repository.frameworks.jdbc.managers.vehicle.cacheVehicle.ManagerCacheVehicleServiceImpl;
import repository.frameworks.jdbc.managers.workOrder.ManagerWorkOrder;
import repository.frameworks.jdbc.managers.workOrder.ManagerWorkOrderImpl;
import repository.frameworks.repositoryManagerImpl.RepositoryCacheBrandManagerImpl;
import repository.frameworks.repositoryManagerImpl.RepositoryCacheClientManagerImpl;
import repository.frameworks.repositoryManagerImpl.RepositoryCacheModelManagerImpl;
import repository.frameworks.repositoryManagerImpl.RepositoryCacheVehicleManagerImpl;
import repository.frameworks.repositoryManagerImpl.RepositoryManagerImpl;

public class RepositoryManagerFactory {

	private static ManagerClientService managerClientService  = null;
	private static ManagerVehicleService managerVehicleService  = null;
	private static ManagerBrandService managerBrandService  = null;
	private static ManagerModelService managerModelService  = null;
	
	private static ManagerCacheClientService managerCacheClientService  = null;
	private static ManagerCacheBrandService managerCacheBrandService  = null;
	private static ManagerCacheModelService managerCacheModelService  = null;
	private static ManagerCacheVehicleService managerCacheVehicleService  = null;
	
	private static RepositoryCacheClientManager repositoryManagerCacheClientService  = null;
	private static RepositoryCacheBrandManager repositoryManagerCacheBrandService  = null;
	private static RepositoryCacheModelManager repositoryManagerCacheModelService  = null;
	private static RepositoryCacheVehicleManager repositoryManagerCacheVehicleService  = null;
	
	private static RepositoryManager repositoryManager  = null;
	private static ManagerService managerService  = null;
	private static ManagerWorkOrder managerWorkOrder  = null;
	
	private RepositoryManagerFactory() {}
	
	public static RepositoryManager getRepositoryManager() {
		if (repositoryManager == null) {
			repositoryManager = new RepositoryManagerImpl();
		}

		return repositoryManager;
	}
	
	public static ManagerService getManagerService() {
		if (managerService == null) {
			managerService = new ManagerServiceImpl();
		}

		return managerService;
	}
	
	public static ManagerWorkOrder getManagerWorkOrder() {
		if (managerWorkOrder == null) {
			managerWorkOrder = new ManagerWorkOrderImpl();
		}

		return managerWorkOrder;
	}
	
	public static ManagerClientService getManagerClientService() {
		if (managerClientService == null) {
			managerClientService = new ManagerClientServiceImpl();
		}

		return managerClientService;
	}
	
	public static ManagerVehicleService getManagerVehicleService() {
		if (managerVehicleService == null) {
			managerVehicleService = new ManagerVehicleServiceImpl();
		}

		return managerVehicleService;
	}
	
	public static ManagerBrandService getManagerBrandService() {
		if (managerBrandService == null) {
			managerBrandService = new ManagerBrandServiceImpl();
		}

		return managerBrandService;
	}
	
	public static ManagerModelService getManagerModelService() {
		if (managerModelService == null) {
			managerModelService = new ManagerModelServiceImpl();
		}

		return managerModelService;
	}
	
	public static ManagerCacheClientService getManagerCacheClientService() {
		if (managerCacheClientService == null) {
			managerCacheClientService = new ManagerCacheClientServiceImpl();
		}

		return managerCacheClientService;
	}
	
	public static RepositoryCacheClientManager getRepositoryManagerCacheClientService() {
		if (repositoryManagerCacheClientService == null) {
			repositoryManagerCacheClientService = new RepositoryCacheClientManagerImpl();
		}

		return repositoryManagerCacheClientService;
	}
	
	public static ManagerCacheBrandService getManagerCacheBrandService() {
		if (managerCacheBrandService == null) {
			managerCacheBrandService = new ManagerCacheBrandServiceImpl();
		}

		return managerCacheBrandService;
	}
	
	public static RepositoryCacheBrandManager getRepositoryManagerCacheBrandService() {
		if (repositoryManagerCacheBrandService == null) {
			repositoryManagerCacheBrandService = new RepositoryCacheBrandManagerImpl();
		}

		return repositoryManagerCacheBrandService;
	}
	
	public static ManagerCacheModelService getManagerCacheModelService() {
		if (managerCacheModelService == null) {
			managerCacheModelService = new ManagerCacheModelServiceImpl();
		}

		return managerCacheModelService;
	}
	
	public static RepositoryCacheModelManager getRepositoryManagerCacheModelService() {
		if (repositoryManagerCacheModelService == null) {
			repositoryManagerCacheModelService = new RepositoryCacheModelManagerImpl();
		}

		return repositoryManagerCacheModelService;
	}
	
	public static ManagerCacheVehicleService getManagerCacheVehicleService() {
		if (managerCacheVehicleService == null) {
			managerCacheVehicleService = new ManagerCacheVehicleServiceImpl();
		}

		return managerCacheVehicleService;
	}
	
	public static RepositoryCacheVehicleManager getRepositoryManagerCacheVehicleService() {
		if (repositoryManagerCacheVehicleService == null) {
			repositoryManagerCacheVehicleService = new RepositoryCacheVehicleManagerImpl();
		}

		return repositoryManagerCacheVehicleService;
	}
	
}
