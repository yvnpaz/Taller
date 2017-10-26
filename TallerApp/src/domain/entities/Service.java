package domain.entities;

public class Service {
	
	private ServiceType serviceType;
	private StateService stateService;
	
	public Service(ServiceType serviceType, StateService stateService) {
		super();
		this.serviceType = serviceType;
		this.stateService = stateService;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public StateService getStateService() {
		return stateService;
	}

	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceType == null) ? 0 : serviceType.hashCode());
		result = prime * result + ((stateService == null) ? 0 : stateService.hashCode());
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
		Service other = (Service) obj;
		if (serviceType != other.serviceType)
			return false;
		if (stateService != other.stateService)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Service [serviceType=" + serviceType + ", stateService=" + stateService + "]";
	}
	
}
