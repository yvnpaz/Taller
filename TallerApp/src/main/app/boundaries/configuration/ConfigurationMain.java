package main.app.boundaries.configuration;

import domain.entities.Brand;
import domain.entities.Client;
import main.app.boundaries.servicesMain.ManagementMainService;
import main.app.boundaries.servicesMain.cachesMain.CacheClientMainService;
import main.app.boundaries.servicesMain.service.ServiceServiceMain;
import main.app.boundaries.servicesMain.workOrder.WorkOrderMainService;

public class ConfigurationMain {
	
	private static ManagementMainService<Client> managementClientMainServiceDom;
	private static ManagementMainService<Brand> managementBrandMainServiceDom;
	private static CacheClientMainService cacheClientMainServiceDom;
	private static WorkOrderMainService workOrderMainServiceDom;
	private static ServiceServiceMain serviceServiceMain;

	public ConfigurationMain() {}
	
	public ManagementMainService<Client> getManagementCLientMainService()
	{
		return managementClientMainServiceDom;
	}
	
	public static void setDomain(ManagementMainService<Client> managementClientDom)
	{
		managementClientMainServiceDom = managementClientDom;
	}
	
	public ManagementMainService<Brand> getManagementBrandMainService()
	{
		return managementBrandMainServiceDom;
	}
	
	public static void setDomainBrand(ManagementMainService<Brand> managementBrandDom)
	{
		managementBrandMainServiceDom = managementBrandDom;
	}
	

	public CacheClientMainService getCacheClientMainService()
	{
		return cacheClientMainServiceDom;
	}
	
	public static void setDomain(CacheClientMainService cacheClientDom)
	{
		cacheClientMainServiceDom = cacheClientDom;
	}	
	
	public WorkOrderMainService getWorkOrderMainService()
	{
		return workOrderMainServiceDom;
	}
	
	public static void setDomain(WorkOrderMainService workOrderDom)
	{
		workOrderMainServiceDom = workOrderDom;
	}
	
	//Service
	public static ServiceServiceMain getServiceServiceMain()
	{
		return serviceServiceMain;
	}
	
	public static void setDomain(ServiceServiceMain serviceServiceDom)
	{
		serviceServiceMain = serviceServiceDom;
	}
}
