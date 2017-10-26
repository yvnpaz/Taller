package repository.entities;

public class ServiceRepo {

	private ServiceTypeRepo serviceTypeRepo;
	private StateServiceRepo stateServiceRepo;
	
	public ServiceRepo(ServiceTypeRepo serviceTypeRepo, StateServiceRepo stateServiceRepo) {
		super();
		this.serviceTypeRepo = serviceTypeRepo;
		this.stateServiceRepo = stateServiceRepo;
	}


	public ServiceTypeRepo getServiceTypeRepo() {
		return serviceTypeRepo;
	}


	public void setServiceTypeRepo(ServiceTypeRepo serviceTypeRepo) {
		this.serviceTypeRepo = serviceTypeRepo;
	}


	public StateServiceRepo getStateServiceRepo() {
		return stateServiceRepo;
	}


	public void setStateServiceRepo(StateServiceRepo stateServiceRepo) {
		this.stateServiceRepo = stateServiceRepo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceTypeRepo == null) ? 0 : serviceTypeRepo.hashCode());
		result = prime * result + ((stateServiceRepo == null) ? 0 : stateServiceRepo.hashCode());
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
		ServiceRepo other = (ServiceRepo) obj;
		if (serviceTypeRepo != other.serviceTypeRepo)
			return false;
		if (stateServiceRepo != other.stateServiceRepo)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ServiceRepo [serviceTypeRepo=" + serviceTypeRepo + ", stateServiceRepo=" + stateServiceRepo + "]";
	}
	
}
