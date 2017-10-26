package repository.frameworks.jdbc.managers.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import repository.entities.ClientRepo;
import repository.entities.ServiceRepo;
import repository.entities.VehicleRepo;
import repository.entities.WorkOrderRepo;

public class ServiceDao {

	public ServiceDao() {
	}

	public void guardarServiceRepo(int idWorkOrder, ServiceRepo serviceRepo,
			Connection connect) {
		
		String sql = "INSERT INTO ServiceRepo (stateService, typeService, idService_idWorkOrder) values (?,?,?)";

		PreparedStatement preparedSt = null;
		
		try {

			preparedSt = connect.prepareStatement(sql);
			preparedSt.setString(1, serviceRepo.getStateServiceRepo().toString());
			preparedSt.setString(2, serviceRepo.getServiceTypeRepo().getTipoReparationRepo());
			preparedSt.setInt(3, idWorkOrder);
			preparedSt.execute();

			System.out.println("He guardado en la base de datos Servicio => " + serviceRepo);

			preparedSt.close();

		} catch (Exception e) {
			System.out.println("Error en Service");
		}
	}

	public void editarServiceRepo(ServiceRepo serviceRepo, Connection connect) {

		PreparedStatement preparedSt = null;
		String sql = "UPDATE ServiceRepo SET stateService = ?, typeService = ? Where id = ?";

		try {

			preparedSt = connect.prepareStatement(sql);

			preparedSt.setString(1, serviceRepo.getStateServiceRepo().getStateServiceRepo().toString());
			preparedSt.setString(2, serviceRepo.getServiceTypeRepo().getTipoReparationRepo());
			// preparedSt.setString(3, serviceRepo);//id

			preparedSt.execute();

			System.out.println("He editado en la base de datos para servicio => " + serviceRepo);

			preparedSt.close();

		} catch (Exception e) {
			System.out.println("Error en Editar Servicio");
		}
	}

	public void actualizarEstadoServiceRepo(int numIdWorkOrder, ServiceRepo serviceRepo, Connection connect) {

		PreparedStatement preparedSt = null;
		String sql = "UPDATE ServiceRepo SET stateService = ? Where idService_idWorkOrder = ?";

		try {

			preparedSt = connect.prepareStatement(sql);

			preparedSt.setString(1, serviceRepo.getStateServiceRepo().toString());
			preparedSt.setInt(2, numIdWorkOrder);

			preparedSt.execute();

			System.out.println("He editado el 'Estado' en la base de datos para servicio => " + serviceRepo);

			preparedSt.close();

		} catch (Exception e) {
			System.out.println("Error en Editar Servicio");
		}
	}

	public void verServiceRepo(ServiceRepo serviceRepo, Connection connect) {
		System.out.println("He visto en la base de datos => " + serviceRepo);
	}

}
