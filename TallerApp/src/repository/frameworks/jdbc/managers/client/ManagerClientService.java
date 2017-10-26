package repository.frameworks.jdbc.managers.client;

import repository.entities.ClientRepo;

public interface ManagerClientService {

	public void guardarClientRepoManage(ClientRepo clientRepo);
	public void editarClientRepoManage(ClientRepo clientRepo);
	public void verClientRepoManage(ClientRepo clientRepo);
	
}
