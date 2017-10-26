package main.app;

import domain.boundaries.Services.ServiceService;
import domain.entities.Brand;
import domain.entities.Client;
import domain.entities.Model;
import domain.entities.Vehicle;
import main.app.boundaries.servicesMain.ManagementMainService;
import main.app.boundaries.servicesMain.cachesMain.CacheClientMainService;
import main.app.boundaries.servicesMain.service.ServiceServiceMain;
import main.app.boundaries.servicesMain.workOrder.WorkOrderMainService;
import main.app.managers.brand.ManagementBrandMainServiceImpl;
import main.app.managers.client.ManagementClientMainServiceImpl;
import main.app.managers.client.cacheClient.ManagerCacheClientMainServiceImpl;
import main.app.managers.model.ManagementModelMainServiceImpl;
import main.app.managers.service.ManagerServiceMainServiceImpl;
import main.app.managers.vehicle.ManagementVehicleMainServiceImpl;
import main.app.managers.workOrder.ManagerWorkOrderMainServiceImpl;
import repository.frameworks.jdbc.managers.service.ManagerServiceImpl;

public class MainFactory {

	private static ManagementMainService<Client> managementClientMainService;
	private static ManagementMainService<Vehicle> managementVehicleMainService;
	private static ManagementMainService<Brand> managementBrandMainService;
	private static ManagementMainService<Model> managementModelMainService;
	
	private static WorkOrderMainService workOrderMainService;
	private static ServiceServiceMain serviceServiceMainService;
	
	private static CacheClientMainService CacheClientMainService;
	
	public static ManagementMainService<Client> getManagementClientMainService()
	{
		if(managementClientMainService == null)
		{
			managementClientMainService = new ManagementClientMainServiceImpl();
		}
		return managementClientMainService;
	}
	
	//Vehicle
	public static ManagementMainService<Vehicle> getManagementVehicleMainService()
	{
		if(managementVehicleMainService == null)
		{
			managementVehicleMainService = new ManagementVehicleMainServiceImpl();
		}
		return managementVehicleMainService;
	}
	
	public static ManagementMainService<Brand> getManagementBrandMainService()
	{
		if(managementBrandMainService == null)
		{
			managementBrandMainService = new ManagementBrandMainServiceImpl();
		}
		return managementBrandMainService;
	}
	
	public static ManagementMainService<Model> getManagementModelMainService()
	{
		if(managementModelMainService == null)
		{
			managementModelMainService = new ManagementModelMainServiceImpl();
		}
		return managementModelMainService;
	}
	
	public static CacheClientMainService getCacheClientMainService()
	{
		if(CacheClientMainService == null)
		{
			CacheClientMainService = new ManagerCacheClientMainServiceImpl();
		}
		return CacheClientMainService;
	}
	
	public static WorkOrderMainService getWorkOrderMainService()
	{
		if(workOrderMainService == null)
		{
			workOrderMainService = new ManagerWorkOrderMainServiceImpl();
		}
		return workOrderMainService;
	}
	
	public static ServiceServiceMain getServiceServiceMain()
	{
		if(serviceServiceMainService == null)
		{
			serviceServiceMainService = new ManagerServiceMainServiceImpl();
		}
		return serviceServiceMainService;
	}
	
}
