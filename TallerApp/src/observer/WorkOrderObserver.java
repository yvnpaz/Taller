package observer;

import java.util.Observable;
import java.util.Observer;

import domain.entities.Service;
import domain.entities.WorkOrder;

public class WorkOrderObserver implements Observer {

	public WorkOrderObserver() {}
	
	@Override
	public void update(Observable observable, Object args) {//args -> Service
		
		if (args instanceof WorkOrder) 
		{			
			Service servicio = (Service) args;
			System.out.printf("El Servicio ha cambiado de estado de %s a %s", 
					servicio.getServiceType(), servicio.getStateService() );
			System.out.println("Esta pasando algo.");
		}
	}
}
