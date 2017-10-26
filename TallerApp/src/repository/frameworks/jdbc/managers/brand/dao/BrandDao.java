package repository.frameworks.jdbc.managers.brand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import repository.configurationRepo.caches.CacheBrandRepo;
import repository.entities.BrandRepo;

public class BrandDao {

	CacheBrandRepo<Integer, BrandRepo> cacheBrandRepo = new CacheBrandRepo<>();
	
	public BrandDao() {}
	
	public void guardarBrandRepo(BrandRepo brandRepo, Connection connect)
	{
		String sqlSelect = "SELECT * FROM BrandRepo WHERE codeBrId = ?";
		String sqlInsert = "INSERT INTO BrandRepo (codeBrId, name, place) values (?,?,?)";
		PreparedStatement preparedSt = null;
		
		try {
			PreparedStatement pstmt = connect.prepareStatement(sqlSelect);
			pstmt.setInt(1, brandRepo.getCodeRepo());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println("No se ha guardado la marca porque ya existe");
			}
			else{
				preparedSt = connect.prepareStatement(sqlInsert);
				preparedSt.setInt(1, brandRepo.getCodeRepo());
				preparedSt.setString(2, brandRepo.getNameRepo() );
				preparedSt.setString(3, brandRepo.getPlaceRepo() );
				preparedSt.execute();
				
				preparedSt.close();
				System.out.println("He guardado en la base de datos => "+ brandRepo);
				
			}

			rs.close();
		} catch (Exception e) {
			System.out.println("Error en Inserta Brand");
		}
	}
	
	public BrandRepo insertBrandRepoInCache(BrandRepo brandRepo, Connection connect)
	{
		cacheBrandRepo.put(brandRepo.getCodeRepo(), brandRepo);
		BrandRepo valor = cacheBrandRepo.getValor(cacheBrandRepo, brandRepo.getCodeRepo());
		
		return valor;
	}
	
	public void editarBrandRepo(BrandRepo brandRepo, Connection connect)
	{
		String sql = "UPDATE BrandRepo SET codeBrId = ?, name = ?, place = ? Where codeBrId = ?";
		PreparedStatement preparedSt = null;
		
		try {
			
			preparedSt = connect.prepareStatement(sql);

			preparedSt.setInt(1, brandRepo.getCodeRepo());
			preparedSt.setString(2, brandRepo.getNameRepo());
			preparedSt.setString(3, brandRepo.getPlaceRepo());
			
			preparedSt.setInt(4, brandRepo.getCodeRepo());
			
			preparedSt.execute();
			
			System.out.println("He editado en la base de datos de BrandRepo => "+ brandRepo);	

			preparedSt.close();

		} catch (Exception e) {
			System.out.println("Error en Editar Brand");
		}
	}
	
	
	public void verBrandRepo(BrandRepo brandRepo, Connection connect)
	{
		String sql = "SELECT * FROM BrandRepo Where codeBrId = ?";
		PreparedStatement preparedSt = null;

		try {	
			preparedSt = connect.prepareStatement(sql);
			preparedSt.setInt(1, brandRepo.getCodeRepo());
			ResultSet rs = preparedSt.executeQuery();
			while (rs.next()) {
				System.out.println("Ver Brand: " + rs.getInt("codeBrId") + "\t" + rs.getString("name") + "\t"
						+ rs.getString("place") );
			}
		} catch (Exception e) {
			System.out.println("Error en Ver Brand");
		}
	}
	
	
	public CacheBrandRepo<Integer, BrandRepo> cargarBrandRepo(Connection connect)
	{
		String sqlAll = "SELECT * FROM BrandRepo";
		BrandRepo brandRepoSelect = null;
		CacheBrandRepo<Integer, BrandRepo> mapBrandRepo = new CacheBrandRepo<>();
				
		try {	
			
			PreparedStatement pstmt = connect.prepareStatement(sqlAll);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				brandRepoSelect = new BrandRepo(rs.getInt("codeBrId"), rs.getString("name"), rs.getString("place"));
				
				int codeBr = rs.getInt("codeBrId");
				mapBrandRepo.put(codeBr, brandRepoSelect);
			}
		} catch (Exception e) {
			System.out.println("Error en cargar CacheBrand");
		}
		return mapBrandRepo;
	}
	
}
