package main.app.actionApp;

import java.util.List;

import domain.entities.Brand;
import domain.entities.Client;
import domain.entities.Model;
import domain.entities.Service;
import domain.entities.StateWorkOrder;
import domain.entities.Vehicle;
import domain.entities.WorkOrder;
import main.app.MainFactory;
import main.app.ManageUser.brand.ManageDataBrand;
import main.app.ManageUser.client.ManageDataClient;
import main.app.ManageUser.model.ManageDataModel;
import main.app.ManageUser.service.ManageRequestService;
import main.app.ManageUser.vehicle.ManageDataVehicle;
import main.app.boundaries.servicesMain.ManagementMainService;
import main.app.boundaries.servicesMain.service.ServiceServiceMain;
import main.app.boundaries.servicesMain.workOrder.WorkOrderMainService;
import observer.WorkOrderObservable;

public class StartApp {
	
	public static ManagementMainService<Client> managementClient;
	public static ManagementMainService<Vehicle> managementVehicle;
	public static ManagementMainService<Brand> managementBrand;
	public static ManagementMainService<Model> managementModel;
	
	public static ServiceServiceMain managementService;
	public static WorkOrderMainService managementWorkOrder;
	
	public StartApp() {
		managementClient = MainFactory.getManagementClientMainService();
		managementVehicle = MainFactory.getManagementVehicleMainService();
		managementBrand = MainFactory.getManagementBrandMainService();
		managementModel = MainFactory.getManagementModelMainService();
		managementService = MainFactory.getServiceServiceMain();
		managementWorkOrder = MainFactory.getWorkOrderMainService();
	}
	
	public static void showMessageWelcome()
	{
		System.out.println("Welcome to Oesia WorkShop!!");
		
		Client client = giveMeClient();
		Brand brand = giveMeBrandVehicle();;
		Model model  = giveMeModelVehicle();

		Vehicle vehicle = giveMeVehicle(brand, model);

		List<Service> services = giveMeService(client, vehicle);
		
		resultWorkOrder(services, client, vehicle);
		
	}
	
	public static Client giveMeClient()
	{
		Client client = ManageDataClient.giveDataClient();
		
		managementClient.insert(client);
		
		return client;

	}
	
	public static Brand giveMeBrandVehicle()
	{
		
		Brand brand = ManageDataBrand.giveDataBrandVehicle();
		
		managementBrand.insert(brand);
		
		return brand;
		
	}
	
	public static Model giveMeModelVehicle()
	{
		
		Model model =  ManageDataModel.giveDataModelVehicle();
		
		managementModel.insert(model);
		
		return model;
		
	}	
	
	public static Vehicle giveMeVehicle(Brand brand, Model model)
	{

		String licensePlate = ManageDataVehicle.giveDataVehicle();
		
		Vehicle newVehicle = new Vehicle(licensePlate, brand, model);
		managementVehicle.insert(newVehicle);
		
		return newVehicle;

	}
	
	public static List<Service> giveMeService(Client client, Vehicle vehicle)
	{
		return ManageRequestService.requestService(client, vehicle, managementService);	
	}
	
	
	public static void resultWorkOrder(List<Service> services, Client client, Vehicle vehicle)
	{
		WorkOrder workOrder = managementWorkOrder.newWorkOrder(client, vehicle, services, StateWorkOrder.ABIERTA);
		
		WorkOrderObservable observado = new WorkOrderObservable(workOrder, services);
		
		Thread threadMain = new Thread(observado, "ThreadMain");
		threadMain.start();
		
		System.out.println(Thread.currentThread());
		
	}
	
}
