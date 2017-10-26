package domain.entities;

import java.util.List;

public class WorkOrder {

	//Array de servicios
	//Estado de la orden
	//Datos de vehiculo y cliente
	
	private List<Service> listServices;
	private Client client;
	private Vehicle vehicle;
	private StateWorkOrder stateWorkOrderState;
	
	public WorkOrder(List<Service> listServices, Client client, Vehicle vehicle, StateWorkOrder stateWorkOrderState) {
		super();
		this.listServices = listServices;
		this.client = client;
		this.vehicle = vehicle;
		this.stateWorkOrderState = stateWorkOrderState;
	}

	public List<Service> getListServices() {
		return listServices;
	}

	public void setListServices(List<Service> listServices) {
		this.listServices = listServices;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public StateWorkOrder getStateWorkOrderState() {
		return stateWorkOrderState;
	}

	public void setStateWorkOrderState(StateWorkOrder stateWorkOrderState) {
		this.stateWorkOrderState = stateWorkOrderState;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((listServices == null) ? 0 : listServices.hashCode());
		result = prime * result + ((stateWorkOrderState == null) ? 0 : stateWorkOrderState.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
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
		WorkOrder other = (WorkOrder) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (listServices == null) {
			if (other.listServices != null)
				return false;
		} else if (!listServices.equals(other.listServices))
			return false;
		if (stateWorkOrderState != other.stateWorkOrderState)
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkOrder [listServices=" + listServices + ", client=" + client + ", vehicle=" + vehicle
				+ ", stateWorkOrderState=" + stateWorkOrderState + "]";
	}	
	
}
