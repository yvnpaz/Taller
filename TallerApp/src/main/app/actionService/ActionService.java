package main.app.actionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.entities.Service;
import domain.entities.ServiceType;
import domain.entities.StateService;

public class ActionService {

	
	public ActionService() { }
	
	public static List<Service> giveDataService()
	{
		List<Service> listService = new ArrayList<>();
		Service service = null;
		boolean called = false;
		System.out.println("Introduce los servicios:");
		Scanner scanner = new Scanner(System.in);
		
		while(!called)
		{
			System.out.println("Los servicios son los siguientes: 1. Mecanica (alta prioridad), 2. Electrica (media prioridad), \n"
					+ "3. Chapa y pintura (prioridada baja) y 4. Revisión (prioridad baja). \n"
					+ "00. Salir");
			int key = scanner.nextInt();
			scanner.nextLine();
			switch (key) {
			case 1: service = new Service(ServiceType.MECANICA, StateService.PENDIENTE);
				listService.add(service);
				break;
			case 2: service = new Service(ServiceType.ELECTRICA, StateService.PENDIENTE);
				listService.add(service);
				break;
			case 3: service = new Service(ServiceType.CHAPAYPINTURA, StateService.PENDIENTE);
				listService.add(service);
				break;
			case 4: service = new Service(ServiceType.REVISION, StateService.PENDIENTE);
				listService.add(service);
				break;
			case 00: called = true; 
				break;
			default:
				break;
			}
		}
		
		return listService;
	}	
}
