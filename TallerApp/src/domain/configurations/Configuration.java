package domain.configurations;

import domain.boundaries.ManagerRepository.ServiceManagerRepository;
import domain.boundaries.ManagerRepositoryCache.CacheClientRepositoryService;
import domain.boundaries.RepositoryService.BrandRepositoryService;
import domain.boundaries.RepositoryService.ClientRepositoryService;
import domain.boundaries.RepositoryService.ModelRepositoryService;
import domain.boundaries.RepositoryService.ServiceRepositoryService;
import domain.boundaries.RepositoryService.VehicleRepositoryService;
import domain.boundaries.RepositoryService.WorkOrderRepositoryService;
import domain.boundaries.Services.ManagementService;
import domain.boundaries.Services.WorkOrderService;
import domain.entities.Brand;
import domain.entities.Client;
import domain.entities.Vehicle;
import domain.usecases.services.managerService.ManagerServiceService;
import domain.usecases.services.managerService.ManagerServiceServiceImpl;
import domain.usecases.services.managerWorkOrder.ManagerWorkOrderService;
import domain.usecases.services.managerWorkOrder.ManagerWorkOrderServiceImpl;

public class Configuration {

	//Main
	private static ManagementService<Client> managementClientServiceDOM;
	private static ManagementService<Vehicle> managementVehicleServiceDOM;
	private static ManagementService<Brand> managementBrandServiceDOM;
	
	private static ClientRepositoryService clientServiceRepository;
	private static VehicleRepositoryService vehicleServiceRepository;
	private static BrandRepositoryService brandRepositoryService;
	private static ModelRepositoryService modelRepositoryService;
	private static WorkOrderRepositoryService workOrderRepositoryService;
	private static WorkOrderService workOrderService;
	private static ServiceRepositoryService serviceRepositoryService;
	private static ServiceManagerRepository serviceManagerRepositoryService;
//	private static ManagerServiceService managerServiceService;
	

	private final static ManagerWorkOrderService managerWorkOrderService = new ManagerWorkOrderServiceImpl();
	private final static ManagerServiceService managerServiceService = new ManagerServiceServiceImpl();
	private static WorkOrderService workOrderServiceUpdate;
	private static WorkOrderService serviceServiceUpdate;
	
	private static CacheClientRepositoryService cacheClientRepositoryService;

	public Configuration() { }
	
	//Main
	public static ManagementService<Client> getManagementService() {
		return managementClientServiceDOM;
	}

	public static void setClientRepository(ManagementService<Client> managementService) {
		managementClientServiceDOM = managementService;
	}
	
	public static ManagementService<Vehicle> getManagementVehicleService() {
		return managementVehicleServiceDOM;
	}

	public static void setVehicleRepository(ManagementService<Vehicle> managementService) {
		managementVehicleServiceDOM = managementService;
	}
	
	public static ManagementService<Brand> getManagementBrandService() {
		return managementBrandServiceDOM;
	}

	public static void setBrandRepository(ManagementService<Brand> managementService) {
		managementBrandServiceDOM = managementService;
	}

	// client
	public static ClientRepositoryService getClientRepository() {
		return clientServiceRepository;
	}

	public static void setRepository(ClientRepositoryService repositoryService) {
		clientServiceRepository = repositoryService;
	}

	// vehicle
	public static VehicleRepositoryService getVehicleRepository() {
		return vehicleServiceRepository;
	}

	public static void setRepository(VehicleRepositoryService repositoryService) {
		vehicleServiceRepository = repositoryService;
	}

	// Brand
	public static BrandRepositoryService getBrandRepository() {
		return brandRepositoryService;
	}

	public static void setRepository(BrandRepositoryService repositoryService) {
		brandRepositoryService = repositoryService;
	}

	// Model
	public static ModelRepositoryService getModelRepository() {
		return modelRepositoryService;
	}

	public static void setRepository(ModelRepositoryService repositoryService) {
		modelRepositoryService = repositoryService;
	}

	// workOrder
	public static WorkOrderRepositoryService getWorkOrderRepository() {
		return workOrderRepositoryService;
	}

	public static void setRepository(WorkOrderRepositoryService repositoryService) {
		workOrderRepositoryService = repositoryService;
	}

	// Service
	public static ServiceRepositoryService getServiceRepository() {
		return serviceRepositoryService;
	}

	public static void setRepository(ServiceRepositoryService serviceRepository) {
		serviceRepositoryService = serviceRepository;
	}

	// Service Manager
	public static ServiceManagerRepository getServiceManagerRepository() {
		return serviceManagerRepositoryService;
	}

	public static void setRepository(ServiceManagerRepository serviceRepository) {
		serviceManagerRepositoryService = serviceRepository;
	}

	public static ManagerWorkOrderService getManagerWorkOrder() {
		return managerWorkOrderService;
	}

	public static WorkOrderService getWorkOrderServiceUpdate() {
		return workOrderServiceUpdate;
	}

	public static void setWorkOrderServiceUpdate(WorkOrderService workOrderServiceImpl) {
		workOrderServiceUpdate = workOrderServiceImpl;
	}

	public static ManagerServiceService getManagerServiceService() {
		return managerServiceService;
	}
	
	
	public static void setWorkOrderService(WorkOrderService workOrderServiceImpl) {
		workOrderService = workOrderServiceImpl;
	}

	public static WorkOrderService getWorkOrderService() {
		return workOrderService;
	}
	
	//Cache
	public static CacheClientRepositoryService getCacheClientRepositoryService() {
		return cacheClientRepositoryService;
	}

	public static void setRepository(CacheClientRepositoryService serviceCacheClientRepository) {
		cacheClientRepositoryService = serviceCacheClientRepository;
	}

}
