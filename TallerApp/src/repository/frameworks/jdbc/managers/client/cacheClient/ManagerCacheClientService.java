package repository.frameworks.jdbc.managers.client.cacheClient;

import repository.entities.ClientRepo;

public interface ManagerCacheClientService {

	public ClientRepo insertCacheClientRepoManage(ClientRepo clientRepo);
	
	public void loadAllClient();
	
	public boolean checkClient(ClientRepo clientRepo);
}
