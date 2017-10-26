package main.app.ManageUser.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.entities.Client;
import domain.entities.Service;
import domain.entities.Vehicle;
import main.app.actionService.ActionService;
import main.app.boundaries.servicesMain.service.ServiceServiceMain;

public class ManageRequestService {

	private static boolean esta = false;
	private static List<Service> listService = new ArrayList<Service>();
	
	public static List<Service> requestService(Client client, Vehicle vehicle, ServiceServiceMain serviceServiceMain)
	{
		while(!esta)
		{
			//Pedir servicios
			listService = ActionService.giveDataService();
			if(listService.isEmpty())
			{
				System.out.println("Tiene que escoger un servicio.");
			}
			else{
				for (Service serviceItr : listService) {
					serviceServiceMain.insert(client, vehicle, serviceItr);
				}
				System.out.println("El/Los servicio/s servicios ha/n sido/s guardado/s.");
				esta=true;
			}
		}
				
		Collections.sort(listService, new Comparator<Service>() {

			public int compare(Service s1, Service s2) {
				return new Integer(s2.getServiceType().getPrice())
						.compareTo(new Integer(s1.getServiceType().getPrice()));
			}
		});

		return listService;
	}
}
