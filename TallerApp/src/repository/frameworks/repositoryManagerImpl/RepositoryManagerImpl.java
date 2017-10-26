package repository.frameworks.repositoryManagerImpl;

import java.util.logging.Logger;

import domain.entities.WorkOrder;
import repository.boundaries.implementManager.RepositoryManager;
import repository.entities.BrandRepo;
import repository.entities.ClientRepo;
import repository.entities.ModelRepo;
import repository.entities.ServiceRepo;
import repository.entities.VehicleRepo;
import repository.entities.WorkOrderRepo;
import repository.frameworks.RepositoryManagerFactory;
import repository.frameworks.jdbc.managers.brand.ManagerBrandService;
import repository.frameworks.jdbc.managers.client.ManagerClientService;
import repository.frameworks.jdbc.managers.model.ManagerModelService;
import repository.frameworks.jdbc.managers.service.ManagerService;
import repository.frameworks.jdbc.managers.vehicle.ManagerVehicleService;
import repository.frameworks.jdbc.managers.workOrder.ManagerWorkOrder;

public class RepositoryManagerImpl implements RepositoryManager {

	private static final Logger LOG = Logger.getLogger(RepositoryManagerImpl.class.getName());
	private final ManagerService managerService;
	private final ManagerWorkOrder managerWorkOrder;
	private final ManagerClientService managerClientService;
	private final ManagerVehicleService managerVehicleService;
	private final ManagerBrandService managerBrandService;
	private final ManagerModelService managerModelService;
	
	public RepositoryManagerImpl() {
		this.managerService = RepositoryManagerFactory.getManagerService();
		this.managerWorkOrder = RepositoryManagerFactory.getManagerWorkOrder();
		this.managerClientService = RepositoryManagerFactory.getManagerClientService();
		this.managerVehicleService = RepositoryManagerFactory.getManagerVehicleService();
		this.managerBrandService = RepositoryManagerFactory.getManagerBrandService();
		this.managerModelService = RepositoryManagerFactory.getManagerModelService();
	}

	public void guardarClientRepo(ClientRepo clientRepo) {
		this.managerClientService.guardarClientRepoManage(clientRepo);
	}

	@Override
	public void editarClientRepo(ClientRepo clientRepo) {

		this.managerClientService.editarClientRepoManage(clientRepo);
	}

	@Override
	public void verClientRepo(ClientRepo clientRepo) {

		this.managerClientService.verClientRepoManage(clientRepo);
	}

	@Override
	public void guardarVehicleRepo(VehicleRepo vehicleRepo) {

		this.managerVehicleService.guardarVehicleRepoManage(vehicleRepo);
	}

	@Override
	public void editarVehicleRepo(VehicleRepo vehicleRepo) {

		this.managerVehicleService.editarVehicleRepoManage(vehicleRepo);
	}

	@Override
	public void verVehicleRepo(VehicleRepo vehicleRepo) {

		this.managerVehicleService.verVehicleRepoManage(vehicleRepo);
	}
	
	//WORK ORDER
	@Override
	public WorkOrderRepo nuevaWorkOrderRepo(WorkOrder workOrder) {

		WorkOrderRepo workOrderRepo = this.managerWorkOrder.nuevaWorkOrder(workOrder);
		return workOrderRepo;
	}

	@Override
	public void cancelarWorkOrder(WorkOrderRepo workOrder) {

		this.managerWorkOrder.cancelarWorkOrder(workOrder);
	}
	
	@Override
	public void actualizarWorkOrderState(WorkOrderRepo workOrder) {
		
		this.managerWorkOrder.actualizarWorkOrderState(workOrder);
	}

	@Override
	public void actualizarServicioState(ServiceRepo serviceRepo) {

		this.managerService.actualizarServiceState(serviceRepo);
	}

	//Brand
	@Override
	public void guardarBrandRepo(BrandRepo brandRepo) {

		this.managerBrandService.guardarBrandRepoManage(brandRepo);
	}

	@Override
	public void editarBrandRepo(BrandRepo brandRepo) {

		this.managerBrandService.editarBrandRepoManage(brandRepo);
	}
	
	@Override
	public void verBrandRepo(BrandRepo brandRepo) {

		this.managerBrandService.verBrandRepoManage(brandRepo);
	}

	//Model
	@Override
	public void guardarModelRepo(ModelRepo modelRepo) {

		this.managerModelService.guardarModelRepoManage(modelRepo);
	}

	@Override
	public void editarModelRepo(ModelRepo modelRepo) {

		this.managerModelService.editarModelRepoManage(modelRepo);
	}
	
	@Override
	public void verModelRepo(ModelRepo modelRepo) {

		this.managerModelService.verModelRepoManage(modelRepo);
	}

	//Service
	@Override
	public void guardarServiceRepo(ClientRepo clientRepo, VehicleRepo vehicleRepo, ServiceRepo serviceRepo) {
		this.managerService.guardarServiceRepoManage(clientRepo, vehicleRepo, serviceRepo);
	}

	@Override
	public void editarServiceRepo(ServiceRepo serviceRepo) {
		this.managerService.editarServiceRepoManage(serviceRepo);
	}

	@Override
	public void verServiceRepo(ServiceRepo serviceRepo) {

		this.managerService.verServiceRepoManage(serviceRepo);

	}

}
