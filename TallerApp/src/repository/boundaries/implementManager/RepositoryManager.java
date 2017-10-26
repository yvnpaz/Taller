package repository.boundaries.implementManager;

import domain.entities.WorkOrder;
import repository.entities.BrandRepo;
import repository.entities.ClientRepo;
import repository.entities.ModelRepo;
import repository.entities.ServiceRepo;
import repository.entities.VehicleRepo;
import repository.entities.WorkOrderRepo;

public interface RepositoryManager {

	//Client
	void guardarClientRepo(ClientRepo clientRepo);
	void editarClientRepo(ClientRepo clientRepo);
	void verClientRepo(ClientRepo clientRepo);

	//Vehicle
	void guardarVehicleRepo(VehicleRepo vehicleRepo);
	void editarVehicleRepo(VehicleRepo vehicleRepo);
	void verVehicleRepo(VehicleRepo vehicleRepo);
	
	//Service
	void guardarServiceRepo(ClientRepo clientRepo, VehicleRepo vehicleRepo, ServiceRepo serviceRepo);
	void editarServiceRepo(ServiceRepo serviceRepo);
	void verServiceRepo(ServiceRepo serviceRepo);
	
	//Brand
	void guardarBrandRepo(BrandRepo brandRepo);
	void editarBrandRepo(BrandRepo branRepo);
	void verBrandRepo(BrandRepo brandRepo);
	
	//Model
	void guardarModelRepo(ModelRepo modelRepo);
	void editarModelRepo(ModelRepo modelRepo);
	void verModelRepo(ModelRepo modelRepo);

	
	//Funcionalidades WorkOrder	
	public WorkOrderRepo nuevaWorkOrderRepo(WorkOrder workOrder);

	public void cancelarWorkOrder(WorkOrderRepo workOrder);
	
	public void actualizarWorkOrderState(WorkOrderRepo workOrder);
	
	public void actualizarServicioState(ServiceRepo serviceRepo);

}
