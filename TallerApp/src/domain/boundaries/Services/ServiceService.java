package domain.boundaries.Services;

import domain.entities.Client;
import domain.entities.Service;
import domain.entities.Vehicle;

public interface ServiceService {

	void insert(Client client, Vehicle vehicle, Service service);
	
	void update(Service service);
	
	void ver(Service service);
	
}
