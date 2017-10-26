package repository.configurationRepo;

import repository.boundaries.implementManager.RepositoryManager;
import repository.frameworks.jdbc.managers.client.cacheClient.ManagerCacheClientService;
import repository.frameworks.jdbc.managers.service.ManagerService;

public class ConfigurationRepo {

	private static RepositoryManager repositoryManager;
	private static ManagerService managerService;
	private static ManagerCacheClientService managerCacheClient;
	
	public ConfigurationRepo() {}
	
	public static RepositoryManager getRepositoryManager()
	{
		return repositoryManager;
	}
	
	public static void setRepositoryManager(RepositoryManager repositoryManage)
	{
		repositoryManager = repositoryManage;
	}
	
	public static ManagerService getManagerService() {
		return managerService;
	}
	
	public static void setManagerService(ManagerService managerServiceSet)
	{
		managerService = managerServiceSet;
	}
	
	
	//Cache
	public static ManagerCacheClientService getManagerCacheClient() {
		return managerCacheClient;
	}
	
	public static void setManagerCacheClient(ManagerCacheClientService managerCacheClient0Set)
	{
		managerCacheClient = managerCacheClient0Set;
	}
}
