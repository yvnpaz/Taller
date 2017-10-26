package domain.boundaries.RepositoryService;

import domain.entities.Client;
import domain.entities.Service;
import domain.entities.Vehicle;
import domain.entities.WorkOrder;
import repository.entities.ServiceRepo;

public interface ServiceRepositoryService {

	void guardar(Client client, Vehicle vehicle, Service service);
	
	void editar(Service service);
	
	void ver(Service service);
	
}
