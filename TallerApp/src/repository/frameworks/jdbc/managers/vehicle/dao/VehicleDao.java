package repository.frameworks.jdbc.managers.vehicle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import repository.configurationRepo.caches.CacheVehicleRepo;
import repository.entities.ClientRepo;
import repository.entities.VehicleRepo;

public class VehicleDao {
	
	CacheVehicleRepo<String, VehicleRepo> cacheVehicleRepo = new CacheVehicleRepo<>();
	
	public VehicleDao() {}

	public void guardarVehicleRepo(VehicleRepo vehicleRepo, Connection connect) {
		
		String sql = "INSERT INTO VehicleRepo (LicensePlate, codeBrand, codeModel) values (?,?,?)";
		PreparedStatement preparedSt = null;
		
		try {
			
			preparedSt = connect.prepareStatement(sql);
			preparedSt.setString(1, vehicleRepo.getLicensePlateRepo() );
			preparedSt.setInt(2, vehicleRepo.getBrandRepo().getCodeRepo() );
			preparedSt.setInt(3, vehicleRepo.getModelRepo().getCodeRepo() );
			preparedSt.execute();
			
			System.out.println("He guardado en la base de datos => " + vehicleRepo);
			
			preparedSt.close();

		} catch (Exception e) {
			System.out.println("Error Inserta vehicle");
		}
	}
	
	public VehicleRepo insertVehicleRepoInCache(VehicleRepo vehicleRepo, Connection connect)
	{
		
		cacheVehicleRepo.put(vehicleRepo.getLicensePlateRepo(), vehicleRepo);
		VehicleRepo valor = cacheVehicleRepo.getValor(cacheVehicleRepo, vehicleRepo.getLicensePlateRepo());
		
		return valor;
	}
	
	public void editarVehicleRepo(VehicleRepo vehicleRepo, Connection connect)
	{
		
		String sql = "UPDATE VehicleRepo SET codeBrand = ?, codeModel = ? Where LicensePlate = ?";
		PreparedStatement preparedSt = null;
		
		try {
			
			preparedSt = connect.prepareStatement(sql);

			preparedSt.setString(1, vehicleRepo.getBrandRepo().toString() );
			preparedSt.setString(2, vehicleRepo.getModelRepo().toString() );
			preparedSt.setString(3, vehicleRepo.getLicensePlateRepo() );
			
			preparedSt.execute();
			
			System.out.println("He editado en la base de datos => "+ vehicleRepo);	

			preparedSt.close();

		} catch (Exception e) {
			System.out.println("Error en Editar Cliente");
		}
	}
	
	public void verVehicleRepo(VehicleRepo vehicleRepo, Connection connect)
	{
		String sql = "SELECT * FROM VehicleRepo WHERE LicensePlate = ?";
		PreparedStatement preparedSt = null;
		
		try {
			
			preparedSt = connect.prepareStatement(sql);
			preparedSt.setString(1, vehicleRepo.getLicensePlateRepo());
			
			ResultSet rs = preparedSt.executeQuery();
			
			while (rs.next()) {
				System.out.println("Ver Vehiculo: " + rs.getString("LicensePlate") + "\t" + rs.getString("codeBrand") + "\t"
						+ rs.getString("codeModel"));
			}
			
		} catch (Exception e) {
			System.out.println("Error en Ver Vehiculo.");
		}
		
	}
	
	public CacheVehicleRepo<String, VehicleRepo> cargarVehicleRepo(Connection connect)
	{
		String sqlAll = "SELECT * FROM VehicleRepo";
		VehicleRepo vehicleRepoSelect = null;
		CacheVehicleRepo<String, VehicleRepo> mapVehicleRepo = new CacheVehicleRepo<>();
				
		try {	
			
			PreparedStatement pstmt = connect.prepareStatement(sqlAll);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				vehicleRepoSelect = new VehicleRepo(rs.getString("LicensePlate"), null, null);
				
				mapVehicleRepo.put(rs.getString("LicensePlate"), vehicleRepoSelect);
			}
		} catch (Exception e) {
			System.out.println("Error en cargar CacheVehicle");
		}
		return mapVehicleRepo;
	}
	
}
