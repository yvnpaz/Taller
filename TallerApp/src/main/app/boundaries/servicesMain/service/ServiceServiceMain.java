package main.app.boundaries.servicesMain.service;

import domain.entities.Client;
import domain.entities.Service;
import domain.entities.Vehicle;

public interface ServiceServiceMain {

	void insert(Client client, Vehicle vehicle, Service service);

	void edit(Service service);

	void load(Service service);
}
