package repository.boundaries;

import domain.boundaries.ManagerRepository.ServiceManagerRepository;
import domain.boundaries.ManagerRepositoryCache.CacheBrandRepositoryService;
import domain.boundaries.ManagerRepositoryCache.CacheClientRepositoryService;
import domain.boundaries.ManagerRepositoryCache.CacheModelRepositoryService;
import domain.boundaries.ManagerRepositoryCache.CacheVehicleRepositoryService;
import domain.boundaries.RepositoryService.BrandRepositoryService;
import domain.boundaries.RepositoryService.ClientRepositoryService;
import domain.boundaries.RepositoryService.ModelRepositoryService;
import domain.boundaries.RepositoryService.ServiceRepositoryService;
import domain.boundaries.RepositoryService.VehicleRepositoryService;
import domain.boundaries.RepositoryService.WorkOrderRepositoryService;
import repository.boundaries.cacheRepository.CacheBrandRepositoryServiceImpl;
import repository.boundaries.cacheRepository.CacheClientRepositoryServiceImpl;
import repository.boundaries.cacheRepository.CacheModelRepositoryServiceImpl;
import repository.boundaries.cacheRepository.CacheVehicleRepositoryServiceImpl;
import repository.boundaries.implementService.BrandRepositoryServiceImpl;
import repository.boundaries.implementService.ClientRepositoryServiceImpl;
import repository.boundaries.implementService.ModelRepositoryServiceImpl;
import repository.boundaries.implementService.ServiceManagerRepositoryImpl;
import repository.boundaries.implementService.ServiceRepositoryServiceImpl;
import repository.boundaries.implementService.VehicleRepositoryServiceImpl;
import repository.boundaries.implementService.WorkOrderRepositoryServiceImpl;

public class RepositoryFactory {

	private static ClientRepositoryService clientRepositoryService = null;
	private static VehicleRepositoryService vehicleRepositoryService = null;
	private static BrandRepositoryService brandRepositoryService = null;
	private static ModelRepositoryService modelRepositoryService = null;
	private static WorkOrderRepositoryService workOrderRepositoryService = null;
	private static ServiceRepositoryService serviceRepositoryService = null;
	private static ServiceManagerRepository serviceManagerRepository = null;
	
	private static CacheClientRepositoryService cacheClientRepositoryService = null;
	private static CacheBrandRepositoryService cacheBrandRepositoryService = null;
	private static CacheModelRepositoryService cacheModelRepositoryService = null;
	private static CacheVehicleRepositoryService cacheVehicleRepositoryService = null;
	
	private RepositoryFactory() {}
	
	public static ClientRepositoryService getClientRepositoryService()
	{
		if(clientRepositoryService == null)
		{
			clientRepositoryService = new ClientRepositoryServiceImpl();
		}
		
		return clientRepositoryService;
	}
	
	public static VehicleRepositoryService getVehicleRepositoryService()
	{
		if(vehicleRepositoryService == null)
		{
			vehicleRepositoryService = new VehicleRepositoryServiceImpl();
		}
		return vehicleRepositoryService;
	}
	
	public static BrandRepositoryService getBrandRepositoryService()
	{
		if(brandRepositoryService == null)
		{
			brandRepositoryService = new BrandRepositoryServiceImpl();
		}
		return brandRepositoryService;
	}
	
	public static ModelRepositoryService getModelRepositoryService()
	{
		if(modelRepositoryService == null)
		{
			modelRepositoryService = new ModelRepositoryServiceImpl();
		}
		return modelRepositoryService;
	}
	
	public static WorkOrderRepositoryService getWorkOrderRepositoryService()
	{
		if(workOrderRepositoryService == null)
		{
			workOrderRepositoryService = new WorkOrderRepositoryServiceImpl();
		}
		return workOrderRepositoryService;
	}
	
	public static ServiceRepositoryService getServiceRepositoryService()
	{
		if(serviceRepositoryService == null)
		{
			serviceRepositoryService = new ServiceRepositoryServiceImpl();
		}
		return serviceRepositoryService;
	}
	
	public static ServiceManagerRepository getManagerServiceService()
	{
		if(serviceManagerRepository == null)
		{
			serviceManagerRepository = new ServiceManagerRepositoryImpl();
		}
		return serviceManagerRepository;
	}
	
	//cache
	public static CacheClientRepositoryService getCacheClientRepositoryService()
	{
		if(cacheClientRepositoryService == null)
		{
			cacheClientRepositoryService = new CacheClientRepositoryServiceImpl();
		}
		return cacheClientRepositoryService;
	}
	
	public static CacheBrandRepositoryService getCacheBrandRepositoryService()
	{
		if(cacheBrandRepositoryService == null)
		{
			cacheBrandRepositoryService = new CacheBrandRepositoryServiceImpl();
		}
		return cacheBrandRepositoryService;
	}
	
	public static CacheModelRepositoryService getCacheModelRepositoryService()
	{
		if(cacheModelRepositoryService == null)
		{
			cacheModelRepositoryService = new CacheModelRepositoryServiceImpl();
		}
		return cacheModelRepositoryService;
	}
	
	public static CacheVehicleRepositoryService getCacheVehicleRepositoryService()
	{
		if(cacheVehicleRepositoryService == null)
		{
			cacheVehicleRepositoryService = new CacheVehicleRepositoryServiceImpl();
		}
		return cacheVehicleRepositoryService;
	}
	
}

