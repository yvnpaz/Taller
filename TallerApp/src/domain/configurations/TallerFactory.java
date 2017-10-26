package domain.configurations;

import domain.boundaries.Services.ManagementService;
import domain.boundaries.Services.ServiceService;
import domain.boundaries.Services.WorkOrderService;
import domain.boundaries.Services.CacheService.CacheBrandService;
import domain.boundaries.Services.CacheService.CacheClientService;
import domain.boundaries.Services.CacheService.CacheModelService;
import domain.boundaries.Services.CacheService.CacheVehicleService;
import domain.entities.Brand;
import domain.entities.Client;
import domain.entities.Model;
import domain.entities.Vehicle;
import domain.usecases.brand.BrandServiceImpl;
import domain.usecases.brand.cacheBrand.CacheBrandServiceImpl;
import domain.usecases.client.ClientServiceImpl;
import domain.usecases.client.cacheClient.CacheClientServiceImpl;
import domain.usecases.model.ModelServiceImpl;
import domain.usecases.model.cacheModel.CacheModelServiceImpl;
import domain.usecases.service.ServiceServiceImpl;
import domain.usecases.services.managerService.ManagerServiceService;
import domain.usecases.services.managerService.ManagerServiceServiceImpl;
import domain.usecases.vehicle.VehicleServiceImpl;
import domain.usecases.vehicle.cacheVehicle.CacheVehicleServiceImpl;
import domain.usecases.workOrder.WorkOrderServiceImpl;

public final class TallerFactory {

	private static ManagementService<Client> clientService = null;
	private static ManagementService<Vehicle> vehicleService = null;
	private static ManagementService<Brand> brandService = null;
	private static ManagementService<Model> modelService = null;
	private static WorkOrderService workOrderService = null;
	private static ServiceService serviceService = null;
	private static ManagerServiceService managerServiceService = null;
	//cache
	private static CacheClientService cacheClientService = null;
	private static CacheBrandService cacheBrandService = null;
	private static CacheModelService cacheModelService = null;
	private static CacheVehicleService cacheVehicleService = null;
	
	public TallerFactory() {}
	
	public static ManagementService<Client> getClientService()
	{
		if(clientService == null)
		{
			clientService = new ClientServiceImpl();
		}
		return clientService;
	}
	
	public static ManagementService<Vehicle> getVehicleService()
	{
		if(vehicleService == null)
		{
			vehicleService = new VehicleServiceImpl();
		}
		return vehicleService;
	}
	
	public static ManagementService<Brand> getBrandService()
	{
		if(brandService == null)
		{
			brandService = new BrandServiceImpl();
		}
		return brandService;
	}
	
	public static ManagementService<Model> getModelService()
	{
		if(modelService == null)
		{
			modelService = new ModelServiceImpl();
		}
		return modelService;
	}
	
	public static WorkOrderService getWorkService()
	{
		if(workOrderService == null)
		{
			workOrderService = new WorkOrderServiceImpl();
		}
		return workOrderService;
	}
	
	public static ServiceService getServiceService()
	{
		if(serviceService == null)
		{
			serviceService = new ServiceServiceImpl();
		}
		return serviceService;
	}
	
	public static ManagerServiceService getManagerServiceService()
	{
		if(managerServiceService == null)
		{
			managerServiceService = new ManagerServiceServiceImpl();
		}
		return managerServiceService;
	}
	
	public static CacheClientService getCacheClientService()
	{
		if(cacheClientService == null)
		{
			cacheClientService = new CacheClientServiceImpl();
		}
		return cacheClientService;
	}
	
	public static CacheBrandService getCacheBrandService()
	{
		if(cacheBrandService == null)
		{
			cacheBrandService = new CacheBrandServiceImpl();
		}
		return cacheBrandService;
	}
	
	public static CacheModelService getCacheModelService()
	{
		if(cacheModelService == null)
		{
			cacheModelService = new CacheModelServiceImpl();
		}
		return cacheModelService;
	}
	
	public static CacheVehicleService getCacheVehicleService()
	{
		if(cacheVehicleService == null)
		{
			cacheVehicleService = new CacheVehicleServiceImpl();
		}
		return cacheVehicleService;
	}
}
