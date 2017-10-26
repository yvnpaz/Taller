package repository.frameworks.jdbc.managers.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import repository.configurationRepo.caches.CacheModelRepo;
import repository.entities.ModelRepo;

public class ModelDao {

	CacheModelRepo<Integer, ModelRepo> cacheModelRepo = new CacheModelRepo<>();
	
	public ModelDao() { }
	
	public void guardarModelRepo(ModelRepo modelRepo, Connection connect)
	{
		String sqlSelect = "SELECT * FROM ModelRepo WHERE codeMoId = ?";
		String sqlInsert = "INSERT INTO ModelRepo (codeMoId, nameCommertial, anio) values (?,?,?)";
		PreparedStatement preparedSt = null;
		
		try {
			PreparedStatement pstmt = connect.prepareStatement(sqlSelect);
			pstmt.setInt(1, modelRepo.getCodeRepo());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println("No se ha guardado el modelo porque ya existe");
			}
			else{
				preparedSt = connect.prepareStatement(sqlInsert);
				preparedSt.setInt(1, modelRepo.getCodeRepo());
				preparedSt.setString(2, modelRepo.getNameCommertialRepo() );
				preparedSt.setInt(3, modelRepo.getAnioRepo() );
				preparedSt.execute();
				
				preparedSt.close();
				System.out.println("He guardado en la base de datos modelo => "+ modelRepo);
				
			}
			
			rs.close();
		} catch (Exception e) {
			System.out.println("Error en Inserta Model");
		}
	}
	
	public ModelRepo insertModelRepoInCache(ModelRepo modelRepo, Connection connect)
	{
		cacheModelRepo.put(modelRepo.getCodeRepo(), modelRepo);
		ModelRepo valor = cacheModelRepo.getValor(cacheModelRepo, modelRepo.getCodeRepo());
		
		return valor;
	}
	
	public void editarModelRepo(ModelRepo modelRepo, Connection connect)
	{
		String sql = "UPDATE ModelRepo SET codeMoId = ?, nameCommertial = ?, anio = ? Where codeMoId = ?";
		PreparedStatement preparedSt = null;
		
		try {
			
			preparedSt = connect.prepareStatement(sql);

			preparedSt.setInt(1, modelRepo.getCodeRepo());
			preparedSt.setString(2, modelRepo.getNameCommertialRepo());
			preparedSt.setInt(3, modelRepo.getAnioRepo());
			
			preparedSt.setInt(4, modelRepo.getCodeRepo());
			
			preparedSt.execute();
			
			System.out.println("He editado en la base de datos del modelo => "+ modelRepo);	

			preparedSt.close();

		} catch (Exception e) {
			System.out.println("Error en Editar Model");
		}
	}
	
	public void verModelRepo(ModelRepo modelRepo, Connection connect)
	{
		String sql = "SELECT * FROM ModelRepo Where codeMoId = ?";
		PreparedStatement preparedSt = null;

		try {	
			preparedSt = connect.prepareStatement(sql);
			preparedSt.setInt(1, modelRepo.getCodeRepo());
			ResultSet rs = preparedSt.executeQuery();
			while (rs.next()) {
				System.out.println("Ver Model: " + rs.getInt("codeMoId") + "\t" + rs.getString("nameCommertial") + "\t"
						+ rs.getInt("anio") );
			}
		} catch (Exception e) {
			System.out.println("Error en Ver Brand");
		}
	}
	
	public CacheModelRepo<Integer, ModelRepo> cargarModelRepo(Connection connect)
	{
		String sqlAll = "SELECT * FROM ModelRepo";
		ModelRepo modelRepoSelect = null;
		CacheModelRepo<Integer, ModelRepo> mapCacheModel = new CacheModelRepo<>();
				
		try {	
			
			PreparedStatement pstmt = connect.prepareStatement(sqlAll);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				modelRepoSelect = new ModelRepo(rs.getInt("codeMoId"), rs.getString("nameCommertial"), rs.getInt("anio"));
				
				mapCacheModel.put(rs.getInt("codeMoId"), modelRepoSelect);
			}
		} catch (Exception e) {
			System.out.println("Error en cargar CacheBrand");
		}
		return mapCacheModel;
	}
}
