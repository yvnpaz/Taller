package domain.boundaries.RepositoryService;

import domain.entities.Client;

public interface ClientRepositoryService extends Repository<Client> {

	@Override
	void guardar(Client client);
	
	@Override
	void editar(Client client);
	
	@Override
	void ver(Client client);
}
