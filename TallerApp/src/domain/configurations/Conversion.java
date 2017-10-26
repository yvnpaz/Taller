package domain.configurations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.entities.Brand;
import domain.entities.Client;
import domain.entities.Model;
import domain.entities.Service;
import domain.entities.ServiceType;
import domain.entities.StateService;
import domain.entities.StateWorkOrder;
import domain.entities.Vehicle;
import domain.entities.WorkOrder;
import repository.entities.BrandRepo;
import repository.entities.ClientRepo;
import repository.entities.ModelRepo;
import repository.entities.ServiceRepo;
import repository.entities.ServiceTypeRepo;
import repository.entities.StateServiceRepo;
import repository.entities.StateWorkOrderRepo;
import repository.entities.VehicleRepo;
import repository.entities.WorkOrderRepo;

public class Conversion {

	public static BrandRepo toBrandRepo(Brand brand) {
		BrandRepo brandRepo = new BrandRepo(brand.getCode(), brand.getName(), brand.getPlace());
		return brandRepo;
	}
	
	public static Brand toBrand(BrandRepo brandRepo) {
		Brand brand = new Brand(brandRepo.getCodeRepo(), brandRepo.getNameRepo(), brandRepo.getPlaceRepo());
		return brand;
	}

	public static ModelRepo toModelRepo(Model model) {
		ModelRepo modelRepo = new ModelRepo(model.getCode(), model.getNameCommertial(), model.getAnio());
		return modelRepo;
	}
	
	public static Model toModel(ModelRepo modelRepo) {
		Model model = new Model(modelRepo.getCodeRepo(), modelRepo.getNameCommertialRepo(), modelRepo.getAnioRepo());
		return model;
	}

	public static List<Brand> toListBrandRepo(List<BrandRepo> brandRepo) {
		List<Brand> listBrand = new ArrayList<>();

		for (BrandRepo brandRepoItr : brandRepo) {

			listBrand.add(new Brand(brandRepoItr.getCodeRepo(), brandRepoItr.getNameRepo(), brandRepoItr.getPlaceRepo()));
		}
		return listBrand;
	}
	
	public static List<Model> toListModelRepo(List<ModelRepo> modelRepo) {
		List<Model> listModel = new ArrayList<>();

		for (ModelRepo modelRepoItr : modelRepo) {

			listModel.add(new Model(modelRepoItr.getCodeRepo(), modelRepoItr.getNameCommertialRepo(), modelRepoItr.getAnioRepo()));
		}
		return listModel;
	}
	
	public static List<Client> toListClientRepo(List<ClientRepo> clientRepo) {
		List<Client> listClient = new ArrayList<>();

		for (ClientRepo clientsRepoItr : clientRepo) {

			listClient.add(new Client(clientsRepoItr.getDni(), clientsRepoItr.getName(), clientsRepoItr.getLastName(),
					clientsRepoItr.getEmail()));
		}
		return listClient;
	}
	
	public static List<Vehicle> toListVehicleRepo(List<VehicleRepo> vehicleRepo) {
		List<Vehicle> listVehicle = new ArrayList<>();

		for (VehicleRepo vehiclesRepoItr : vehicleRepo) {

			listVehicle.add(new Vehicle(vehiclesRepoItr.getLicensePlateRepo(), toBrand(vehiclesRepoItr.getBrandRepo()),
					toModel(vehiclesRepoItr.getModelRepo())));
		}
		return listVehicle;
	}


	public static List<ServiceRepo> toListServiceRepo(List<Service> service) {
		List<ServiceRepo> listServiceRepo = new ArrayList<>();

		for (Service serviceRepo : service) {

			listServiceRepo.add(new ServiceRepo(getServiceTypeRepo(serviceRepo.getServiceType()),
					getStateServiceRepo(serviceRepo.getStateService())));
		}
		return listServiceRepo;
	}
	
	
	public static List<Service> toListService(List<ServiceRepo> serviceRepo) {
		List<Service> listService = new ArrayList<>();

		for (ServiceRepo service : serviceRepo) {

			listService.add(new Service(getServiceType(service.getServiceTypeRepo()),
					getStateService(service.getStateServiceRepo())));
		}
		return listService;
	}

	public static ServiceTypeRepo getServiceTypeRepo(ServiceType serviceType) {
		switch (serviceType) {
		case MECANICA:
			return ServiceTypeRepo.MECANICA;
		case ELECTRICA:
			return ServiceTypeRepo.ELECTRICA;
		case CHAPAYPINTURA:
			return ServiceTypeRepo.CHAPAYPINTURA;
		case REVISION:
			return ServiceTypeRepo.REVISION;
		default:
			return null;
		}
	}

	public static StateServiceRepo getStateServiceRepo(StateService stateService) {
		switch (stateService) {
		case PENDIENTE:
			return StateServiceRepo.PENDIENTE;
		case ENCURSO:
			return StateServiceRepo.ENCURSO;
		case FINALIZADO:
			return StateServiceRepo.FINALIZADO;
		case CANCELADO:
			return StateServiceRepo.CANCELADO;
		default:
			return null;
		}
	}

	public static StateWorkOrderRepo toStateWorkOrderRepo(StateWorkOrder stateWorkOrder) {
		switch (stateWorkOrder) {
		case ABIERTA:
			return StateWorkOrderRepo.ABIERTA;
		case EN_CURSO:
			return StateWorkOrderRepo.EN_CURSO;
		case CERRADA:
			return StateWorkOrderRepo.CERRADA;
		default:
			return null;
		}
	}
	
	public static ServiceType getServiceType(ServiceTypeRepo serviceTypeRepo) {
		switch (serviceTypeRepo) {
		case MECANICA:
			return ServiceType.MECANICA;
		case ELECTRICA:
			return ServiceType.ELECTRICA;
		case CHAPAYPINTURA:
			return ServiceType.CHAPAYPINTURA;
		case REVISION:
			return ServiceType.REVISION;
		default:
			return null;
		}
	}
	
	public static StateService getStateService(StateServiceRepo stateServiceRepo) {
		switch (stateServiceRepo) {
		case PENDIENTE:
			return StateService.PENDIENTE;
		case ENCURSO:
			return StateService.ENCURSO;
		case FINALIZADO:
			return StateService.FINALIZADO;
		case CANCELADO:
			return StateService.CANCELADO;
		default:
			return null;
		}
	}
	
	public static StateWorkOrder toStateWorkOrder(StateWorkOrderRepo stateWorkOrderRepo) {
		switch (stateWorkOrderRepo) {
		case ABIERTA:
			return StateWorkOrder.ABIERTA;
		case EN_CURSO:
			return StateWorkOrder.EN_CURSO;
		case CERRADA:
			return StateWorkOrder.CERRADA;
		default:
			return null;
		}
	}	
	
	public static ClientRepo buildToClientRepo(Client client)
	{
		ClientRepo clientRepo = new ClientRepo(client.getDni(),client.getName(), client.getLastName(), client.getEmail());
		return clientRepo;
	}
	
	public static Client buildToClient(ClientRepo clientRepo)
	{
		Client client = new Client(clientRepo.getDni(), clientRepo.getName(), clientRepo.getLastName(), clientRepo.getEmail());
		return client;
	}
	
	public static VehicleRepo buildToVehicleRepo(Vehicle vehicle)
	{
		VehicleRepo vehicleRepo = new VehicleRepo(vehicle.getLicensePlate(), Conversion.toBrandRepo(vehicle.getBrand()), 
				Conversion.toModelRepo(vehicle.getModel()));
		return vehicleRepo;
	}
	
	public static Vehicle buildToVehicle(VehicleRepo vehicleRepo)
	{
		Vehicle vehicle = new Vehicle(vehicleRepo.getLicensePlateRepo(), Conversion.toBrand(vehicleRepo.getBrandRepo()), 
				Conversion.toModel(vehicleRepo.getModelRepo()));
		return vehicle;
	}
	
	public static ServiceRepo toServiceRepo(WorkOrder workOrder, Service service)
	{
		ServiceRepo serviceRepo = new ServiceRepo(getServiceTypeRepo(service.getServiceType()), 
				getStateServiceRepo(service.getStateService()));
		
		return serviceRepo;
	}
	
	public static Service toService(ServiceRepo serviceRepo)
	{
		Service service = new Service(getServiceType(serviceRepo.getServiceTypeRepo()), 
				getStateService(serviceRepo.getStateServiceRepo()));
		
		return service;
	}
	
	public static ServiceRepo toService(Service service)
	{
		ServiceRepo serviceRepo = new ServiceRepo(getServiceTypeRepo(service.getServiceType()), 
				getStateServiceRepo(service.getStateService()));
		
		return serviceRepo;
	}
	
	public static WorkOrder BuildWorkOrder(Client client, Vehicle vehicle, List<Service> service, StateWorkOrder stateWorkOrder)
	{
		WorkOrder workOrder = new WorkOrder(service, client, vehicle, stateWorkOrder);
		return workOrder;
	}
	
	
	public static WorkOrderRepo toWorkOrderRepo(WorkOrder workOrder)
	{
		WorkOrderRepo workOrderRepo = new WorkOrderRepo(toListServiceRepo(workOrder.getListServices()),
				buildToClientRepo(workOrder.getClient()),
				buildToVehicleRepo(workOrder.getVehicle()),
				toStateWorkOrderRepo(workOrder.getStateWorkOrderState()));
		
		return workOrderRepo;
	}
	
	public static WorkOrder toWorkOrder(WorkOrderRepo workOrderRepo)
	{
		WorkOrder workOrder = new WorkOrder(toListService(workOrderRepo.getListServiceRepo()),
				buildToClient(workOrderRepo.getClientRepo()), 
				buildToVehicle(workOrderRepo.getVehicleRepo()),
				toStateWorkOrder(workOrderRepo.getStateWorkOrderStateRepo()) );
		
		return workOrder;
	}
	
	public static Map<WorkOrder, Service> toServiceWorkOrder(WorkOrderRepo workOrderRepo, ServiceRepo serviceRepo)
	{
		WorkOrder workOrder = toWorkOrder(workOrderRepo);
		Service service = toService(serviceRepo);
		
		Map<WorkOrder, Service> mapWorkOrderService = new HashMap<>();
		mapWorkOrderService.put(workOrder, service);
		
		
		return mapWorkOrderService;
	}
	
}