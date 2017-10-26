package repository.entities;

import java.util.List;


public class WorkOrderRepo {

	private ClientRepo clientRepo;
	private VehicleRepo vehicleRepo;
	private StateWorkOrderRepo stateWorkOrderStateRepo;
	private List<ServiceRepo> listServiceRepo;
	
	public WorkOrderRepo(List<ServiceRepo> listServices, ClientRepo clientRepo, VehicleRepo vehicleRepo,
			StateWorkOrderRepo stateWorkOrderStateRepo) {
		super();
		this.clientRepo = clientRepo;
		this.vehicleRepo = vehicleRepo;
		this.stateWorkOrderStateRepo = stateWorkOrderStateRepo;
		this.listServiceRepo = listServices;
	}
	
	public List<ServiceRepo> getListServiceRepo() {
		return listServiceRepo;
	}

	public void setListServiceRepo(List<ServiceRepo> listServiceRepo) {
		this.listServiceRepo = listServiceRepo;
	}

	public ClientRepo getClientRepo() {
		return clientRepo;
	}

	public void setClientRepo(ClientRepo clientRepo) {
		this.clientRepo = clientRepo;
	}

	public VehicleRepo getVehicleRepo() {
		return vehicleRepo;
	}

	public void setVehicleRepo(VehicleRepo vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}

	public StateWorkOrderRepo getStateWorkOrderStateRepo() {
		return stateWorkOrderStateRepo;
	}

	public void setStateWorkOrderStateRepo(StateWorkOrderRepo stateWorkOrderStateRepo) {
		this.stateWorkOrderStateRepo = stateWorkOrderStateRepo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientRepo == null) ? 0 : clientRepo.hashCode());
		result = prime * result + ((listServiceRepo == null) ? 0 : listServiceRepo.hashCode());
		result = prime * result + ((stateWorkOrderStateRepo == null) ? 0 : stateWorkOrderStateRepo.hashCode());
		result = prime * result + ((vehicleRepo == null) ? 0 : vehicleRepo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkOrderRepo other = (WorkOrderRepo) obj;
		if (clientRepo == null) {
			if (other.clientRepo != null)
				return false;
		} else if (!clientRepo.equals(other.clientRepo))
			return false;
		if (listServiceRepo == null) {
			if (other.listServiceRepo != null)
				return false;
		} else if (!listServiceRepo.equals(other.listServiceRepo))
			return false;
		if (stateWorkOrderStateRepo != other.stateWorkOrderStateRepo)
			return false;
		if (vehicleRepo == null) {
			if (other.vehicleRepo != null)
				return false;
		} else if (!vehicleRepo.equals(other.vehicleRepo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkOrderRepo [clientRepo=" + clientRepo + ", vehicleRepo=" + vehicleRepo + ", stateWorkOrderStateRepo="
				+ stateWorkOrderStateRepo + ", listServiceRepo=" + listServiceRepo + "]";
	}
	
}
