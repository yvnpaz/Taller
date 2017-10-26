package repository.frameworks.jdbc.managers.workOrder;

import java.sql.Connection;
import java.util.Map;

import domain.configurations.Conversion;
import domain.entities.WorkOrder;
import repository.entities.ClientRepo;
import repository.entities.VehicleRepo;
import repository.entities.WorkOrderRepo;
import repository.frameworks.jdbc.config.ConfigurationDB;
import repository.frameworks.jdbc.managers.client.dao.ClientDao;
import repository.frameworks.jdbc.managers.vehicle.dao.VehicleDao;
import repository.frameworks.jdbc.managers.workOrder.dao.WorkOrderDao;

public class ManagerWorkOrderImpl implements ManagerWorkOrder {

	@Override
	public WorkOrderRepo nuevaWorkOrder(WorkOrder workOrder) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		WorkOrderDao workOrderDao = new WorkOrderDao();
		WorkOrderRepo workOrderRepo = Conversion.toWorkOrderRepo(workOrder);
		return workOrderDao.guardarWorkOrderRepo(workOrderRepo, connect);
	}

	@Override
	public void cancelarWorkOrder(WorkOrderRepo workOrder) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		WorkOrderDao workOrderDao = new WorkOrderDao();
		workOrderDao.cancelarWorkOrder(workOrder, connect);
	}

	@Override
	public void actualizarWorkOrderState(WorkOrderRepo workOrderRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		WorkOrderDao workOrderDao = new WorkOrderDao();
		workOrderDao.actualizarEstadoServiceRepo(workOrderRepo, connect);
	}

}
