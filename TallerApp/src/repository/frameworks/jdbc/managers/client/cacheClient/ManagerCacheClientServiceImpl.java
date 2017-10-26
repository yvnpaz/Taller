package repository.frameworks.jdbc.managers.client.cacheClient;

import java.sql.Connection;
import java.util.Iterator;

import repository.configurationRepo.caches.CacheClientRepo;
import repository.entities.ClientRepo;
import repository.frameworks.jdbc.config.ConfigurationDB;
import repository.frameworks.jdbc.managers.client.dao.ClientDao;

public class ManagerCacheClientServiceImpl implements ManagerCacheClientService {

	CacheClientRepo<Integer, ClientRepo> cacheClientRepo = new CacheClientRepo<Integer, ClientRepo>();

	@Override
	public ClientRepo insertCacheClientRepoManage(ClientRepo clientRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		ClientDao clientDao = new ClientDao();
		ClientRepo clientRepoToret = clientDao.insertClientRepoInCache(clientRepo, connect);
		return clientRepoToret;
	}

	@Override
	public boolean checkClient(ClientRepo clientRepo) {

		Iterator<Integer> itr = cacheClientRepo.keySet().iterator();
		boolean thisOne = false;

		while (itr.hasNext()) {
			int itrDni = itr.next();
			ClientRepo client = cacheClientRepo.get(itrDni); 
			if (client.equals(clientRepo)) {
				thisOne = true;
			}
		}
		return thisOne;
	}

	@Override
	public void loadAllClient() {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		ClientDao clientDao = new ClientDao();
		cacheClientRepo = clientDao.cargarClientRepo(connect);
	}
}
