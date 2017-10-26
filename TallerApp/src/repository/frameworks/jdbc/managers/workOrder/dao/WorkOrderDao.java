package repository.frameworks.jdbc.managers.workOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import repository.entities.ClientRepo;
import repository.entities.ServiceRepo;
import repository.entities.StateWorkOrderRepo;
import repository.entities.VehicleRepo;
import repository.entities.WorkOrderRepo;

public class WorkOrderDao {

	public WorkOrderDao() { }

	public WorkOrderRepo guardarWorkOrderRepo(WorkOrderRepo workOrderRepo, Connection connect) {

		String sql = "INSERT INTO WorkOrderRepo (ClientWorkOrder, VehicleWorkOrder, StateWorkOrder) values (?,?,?)";
		String sqlSelect = "SELECT * FROM WorkOrderRepo Where ClientWorkOrder = ? and VehicleWorkOrder = ?";
		PreparedStatement preparedSt = null;

		try {
			preparedSt = connect.prepareStatement(sql);
			preparedSt.setString(1, workOrderRepo.getClientRepo().getDni());
			preparedSt.setString(2, workOrderRepo.getVehicleRepo().getLicensePlateRepo());
			preparedSt.setString(3, workOrderRepo.getStateWorkOrderStateRepo().getStateWorkOrderRepo());
			preparedSt.execute();

			System.out.println("He guardado en la Orden de trabajo de client con dni => "
					+ workOrderRepo.getClientRepo().getDni());

			preparedSt.close();

			PreparedStatement newPrepare = connect.prepareStatement(sqlSelect);
			newPrepare.setString(1, workOrderRepo.getClientRepo().getDni());
			newPrepare.setString(2, workOrderRepo.getVehicleRepo().getLicensePlateRepo());
			ResultSet rs = newPrepare.executeQuery();

			// workOrderRepo = new WorkOrderRepo(wservice, client, vehicleRepo,
			// stateWorkOrderRepo);
			rs.close();

		} catch (Exception e) {
			System.out.println("Error en inserta WorkOrderRepo");
		}

		return workOrderRepo;
	}

	public void cancelarWorkOrder(WorkOrderRepo workOrderRepo, Connection connect) {
		String sql = "UPDATE WorkOrderRepo SET stateWorkOrder = ? Where ClientWorkOrder = ? and VehicleWorkOrder = ?";
		PreparedStatement preparedSt = null;
		String finalished = "CANCELLED";

		try {

			preparedSt = connect.prepareStatement(sql);

			preparedSt.setString(1, finalished);
			preparedSt.setString(2, workOrderRepo.getClientRepo().getDni());
			preparedSt.setString(3, workOrderRepo.getVehicleRepo().getLicensePlateRepo());

			preparedSt.execute();

			System.out.println("He cancelado en la base de datos de workOrderRepo => " + workOrderRepo);

			preparedSt.close();

		} catch (Exception e) {
			System.out.println("Error en Cancelar WorkOrder");
		}
	}

	public void actualizarEstadoServiceRepo(WorkOrderRepo workOrderRepo, Connection connect) {
		PreparedStatement preparedSt = null;
		String sql = "UPDATE WorkOrderRepo SET StateWorkOrder = ? Where ClientWorkOrder = ? and VehicleWorkOrder= ?";

		try {

			preparedSt = connect.prepareStatement(sql);

			preparedSt.setString(1, workOrderRepo.getStateWorkOrderStateRepo().getStateWorkOrderRepo().toString());
			preparedSt.setString(2, workOrderRepo.getClientRepo().getDni());
			preparedSt.setString(3, workOrderRepo.getVehicleRepo().getLicensePlateRepo());

			preparedSt.execute();

			System.out.println("He editado el 'Estado' en la base de datos para servicio => " + workOrderRepo);

			preparedSt.close();

		} catch (Exception e) {
			System.out.println("Error en Editar WorkOrder");
		}
	}

	public Map<Integer, WorkOrderRepo> cargarWorkOrderRepo(ClientRepo clientRepo, VehicleRepo vehicleRepo,
			Connection connect) {
		String sqlWork = "SELECT idWorkOrder FROM WorkOrderRepo WHERE ClientWorkOrder = ? and VehicleWorkOrder = ? and StateWorkOrder = ?";
		String open = "Abierta";
		WorkOrderRepo workOrderRepoSelect = null;
		Map<Integer, WorkOrderRepo> mapWorkOrderRepo = new HashMap<>();

		try {
			PreparedStatement pstmt = connect.prepareStatement(sqlWork);
			pstmt.setString(1, clientRepo.getDni());
			pstmt.setString(2, vehicleRepo.getLicensePlateRepo());
			pstmt.setString(3, open);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				workOrderRepoSelect = new WorkOrderRepo(null, clientRepo, vehicleRepo, StateWorkOrderRepo.ABIERTA);
				mapWorkOrderRepo.put(rs.getInt("idWorkOrder"), workOrderRepoSelect);
			}
		} catch (Exception e) {
			System.out.println("Error en cargar WorkOrder");
		}
		return mapWorkOrderRepo;
	}

	public void editarWorkOrderRepo(WorkOrderRepo workOrderRepo) {
		System.out.println("He modificado en la base de datos => " + workOrderRepo);
	}

	public void verWorkOrderRepo(WorkOrderRepo workOrderRepo) {
		System.out.println("He visto en la base de datos => " + workOrderRepo);
	}
}
