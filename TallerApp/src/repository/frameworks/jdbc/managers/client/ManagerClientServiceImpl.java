package repository.frameworks.jdbc.managers.client;

import java.sql.Connection;

import repository.entities.ClientRepo;
import repository.frameworks.RepositoryManagerFactory;
import repository.frameworks.jdbc.config.ConfigurationDB;
import repository.frameworks.jdbc.managers.client.cacheClient.ManagerCacheClientService;
import repository.frameworks.jdbc.managers.client.dao.ClientDao;

public class ManagerClientServiceImpl implements ManagerClientService {

	private final ManagerCacheClientService managerCacheClient;
	
	public ManagerClientServiceImpl() {
		this.managerCacheClient = RepositoryManagerFactory.getManagerCacheClientService();
	}
	
	@Override
	public void guardarClientRepoManage(ClientRepo clientRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		ClientDao clientDao = new ClientDao();
		
		managerCacheClient.loadAllClient();
		
		if(!managerCacheClient.checkClient(clientRepo))
		{
			clientDao.guardarClientRepo(clientRepo, connect);
			managerCacheClient.insertCacheClientRepoManage(clientRepo);
		}
		else{
			System.out.println("Ya existe el usuario.");
		}	
	}

	@Override
	public void editarClientRepoManage(ClientRepo clientRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		ClientDao clientDao = new ClientDao();
		clientDao.editarClientRepo(clientRepo, connect);
	}

	@Override
	public void verClientRepoManage(ClientRepo clientRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		ClientDao clientDao = new ClientDao();
		clientDao.verClientRepo(clientRepo, connect);
	}

}
