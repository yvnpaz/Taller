package repository.frameworks.jdbc.managers.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import repository.configurationRepo.caches.CacheClientRepo;
import repository.entities.ClientRepo;

public class ClientDao {
	
	CacheClientRepo<Integer, ClientRepo> cacheClientRepo = new CacheClientRepo<Integer, ClientRepo>();
	
	public ClientDao() { }
	
	public void guardarClientRepo(ClientRepo clientRepo, Connection connect)
	{
		String sql = "INSERT INTO ClientRepo (dni, name, lastName, email) values (?,?,?,?)";
		PreparedStatement preparedSt = null;
		
		try {
			
			preparedSt = connect.prepareStatement(sql);
			preparedSt.setString(1, clientRepo.getDni());
			preparedSt.setString(2, clientRepo.getName() );
			preparedSt.setString(3, clientRepo.getLastName() );
			preparedSt.setString(4, clientRepo.getEmail() );
			preparedSt.execute();
			
			System.out.println("He guardado en la base de datos => "+ clientRepo);	

			preparedSt.close();

		} catch (Exception e) {
			System.out.println("Error en Inserta Cliente");
		}
	}
	
	public ClientRepo insertClientRepoInCache(ClientRepo clientRepo, Connection connect)
	{
		
		int newDNI = convertToInt(clientRepo.getDni());
		
		cacheClientRepo.put(newDNI, clientRepo);
		ClientRepo valor = cacheClientRepo.getValor(cacheClientRepo, newDNI);
		
		return valor;
	}
	
	public void editarClientRepo(ClientRepo clientRepo, Connection connect)
	{
		String sql = "UPDATE ClientRepo SET name = ?, lastName = ?, email = ? Where email=?";
		PreparedStatement preparedSt = null;
		
		try {
			
			preparedSt = connect.prepareStatement(sql);

			preparedSt.setString(1, clientRepo.getName());
			preparedSt.setString(2, clientRepo.getLastName());
			preparedSt.setString(3, clientRepo.getEmail());
			
			preparedSt.setString(4, clientRepo.getEmail());
			
			preparedSt.execute();
			
			System.out.println("He editado en la base de datos => "+ clientRepo);	

			preparedSt.close();

		} catch (Exception e) {
			System.out.println("Error en Editar Cliente");
		}
	}
	
	public void verClientRepo(ClientRepo clientRepo, Connection connect)
	{
		String sql = "SELECT * FROM ClientRepo WHERE Email = ?";
		PreparedStatement preparedSt = null;
		
		try {
			
			preparedSt = connect.prepareStatement(sql);
			preparedSt.setString(1, clientRepo.getEmail());
			
			ResultSet rs = preparedSt.executeQuery();
			
			while (rs.next()) {
				System.out.println("Ver Cliente: " + rs.getString("dni") + "\t" + rs.getString("name") + "\t"
						+ rs.getString("lastName") +"\t"+ rs.getString("email"));
			}
			
		} catch (Exception e) {
			System.out.println("Error en Ver Cliente");
		}
		

	}
	
	public ClientRepo verClientRepoLoad(ClientRepo clientRepo, Connection connect)
	{
		String sql = "SELECT * FROM ClientRepo WHERE Email = ?";
		PreparedStatement preparedSt = null;
		ClientRepo clientRepoLoad = null;
		try {
			
			preparedSt = connect.prepareStatement(sql);
			preparedSt.setString(1, clientRepo.getEmail());
			
			ResultSet rs = preparedSt.executeQuery();
			
			while (rs.next()) {
				clientRepoLoad = new ClientRepo(clientRepo.getDni(), clientRepo.getName(), clientRepo.getLastName(),
						clientRepo.getEmail() );
			}
		} catch (Exception e) {
			System.out.println("Error en cargar un Cliente");
		}
		return clientRepoLoad;
	}
	
	public CacheClientRepo<Integer, ClientRepo> cargarClientRepo(Connection connect)
	{
		String sqlAll = "SELECT * FROM ClientRepo";
		ClientRepo clientRepoSelect = null;
		CacheClientRepo<Integer, ClientRepo> mapClientRepo = new CacheClientRepo<>();
				
		try {	
			
			PreparedStatement pstmt = connect.prepareStatement(sqlAll);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				clientRepoSelect = new ClientRepo(rs.getString("dni"), rs.getString("name"), rs.getString("lastName"),
						rs.getString("email"));
				int dni = convertToInt(rs.getString("dni"));
				
				mapClientRepo.put(dni, clientRepoSelect);
				
			}
		} catch (Exception e) {
			System.out.println("Error en cargar CacheClient");
		}
		return mapClientRepo;
	}
	
	
	private int convertToInt(String dni)
	{
		String dniNew = dni.substring(0,8);
		int newDni = Integer.parseInt(dniNew);
		return newDni;
	}

}
