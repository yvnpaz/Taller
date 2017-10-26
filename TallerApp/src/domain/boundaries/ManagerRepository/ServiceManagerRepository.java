package domain.boundaries.ManagerRepository;

import domain.entities.Service;
import domain.entities.WorkOrder;

public interface ServiceManagerRepository {

	void actualizarStateService(Service service);
}
