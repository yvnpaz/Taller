package observer;

import java.util.List;
import java.util.Observable;

import domain.configurations.Configuration;
import domain.entities.Service;
import domain.entities.ServiceType;
import domain.entities.StateService;
import domain.entities.StateWorkOrder;
import domain.entities.WorkOrder;
import domain.usecases.services.managerService.ManagerServiceService;
import domain.usecases.services.managerWorkOrder.ManagerWorkOrderService;

public class WorkOrderObservable extends Observable implements Runnable {

	public static ManagerServiceService managerServiceService;
	public static ManagerWorkOrderService managerWorkOrderService;
	private List<Service> listService;
	private WorkOrder workOrder;
	long numberOfHour = 0;
	int cont = 0;
	boolean endListWorkOrderBool = false;

	public WorkOrderObservable(WorkOrder workOrder, List<Service> listService) {
		this.listService = listService;
		this.workOrder = workOrder;
		managerServiceService = Configuration.getManagerServiceService();
		managerWorkOrderService = Configuration.getManagerWorkOrder();
	}

	public List<Service> getListService() {
		return listService;
	}

	@Override
	public synchronized void setChanged() {
		super.setChanged();
	}

	public Service updateStateService(Service service) {

		if (!service.getStateService().equals(StateService.CANCELADO)) {
			if (service.getStateService().equals(StateService.PENDIENTE)) {
				service.setStateService(StateService.ENCURSO);
			} else if (service.getStateService().equals(StateService.ENCURSO)) {
				service.setStateService(StateService.FINALIZADO);
			}
		}
		return service;
	}

	public WorkOrder updateStateWorkOrder(WorkOrder workOrder) {

		if (!workOrder.getStateWorkOrderState().equals(StateWorkOrder.CANCELADO)) {
			if (workOrder.getStateWorkOrderState().equals(StateWorkOrder.ABIERTA)) {
				workOrder.setStateWorkOrderState(StateWorkOrder.EN_CURSO);
			} else if (workOrder.getStateWorkOrderState().equals(StateWorkOrder.EN_CURSO)) {
				workOrder.setStateWorkOrderState(StateWorkOrder.CERRADA);
			}
		}
		return workOrder;
	}

	@Override
	public void run() {
		while (!endListWorkOrderBool) {
			System.out.println("Estoy en el hilo.");

			// for (WorkOrder workOrder : listWorkOrder) {
			// cont = workOrder.getListServices().size();
			if (listService != null) {
				WorkOrder workO = updateStateWorkOrder(this.workOrder);
				managerWorkOrderService.updateStateWorkOrder(workO);
				for (Service service : listService) {
					if (service.getServiceType().equals(ServiceType.MECANICA)) {
						numberOfHour = 4000;
						while (!service.getStateService().equals(StateService.FINALIZADO)) {
							Service serviceUp = updateStateService(service);
							managerServiceService.updateStateService(serviceUp);
							sleep(numberOfHour);
							System.out.println("THREAD workOrder");
							// notifyObservers("hola!" + workOrder);
						}
					} else if (service.getServiceType().equals(ServiceType.ELECTRICA)) {
						numberOfHour = 3500;
						while (!service.getStateService().equals(StateService.FINALIZADO)) {
							Service serviceUp = updateStateService(service);
							managerServiceService.updateStateService(serviceUp);
							sleep(numberOfHour);
							System.out.println("THREAD workOrder");
							// notifyObservers("hola!" + workOrder);
						}
					} else if (service.getServiceType().equals(ServiceType.CHAPAYPINTURA)) {
						numberOfHour = 3000;
						while (!service.getStateService().equals(StateService.FINALIZADO)) {
							Service serviceUp = updateStateService(service);
							managerServiceService.updateStateService(serviceUp);
							sleep(numberOfHour);
							System.out.println("THREAD workOrder");
							// notifyObservers("hola!" + workOrder);
						}
					} else if (service.getServiceType().equals(ServiceType.REVISION)) {
						numberOfHour = 2000;
						while (!service.getStateService().equals(StateService.FINALIZADO)) {
							Service serviceUp = updateStateService(service);
							managerServiceService.updateStateService(serviceUp);
							sleep(numberOfHour);
							System.out.println("THREAD workOrder");
							// notifyObservers("hola!" + workOrder);
						}
					}
					WorkOrder workOrderFinished = updateStateWorkOrder(workO);
					managerWorkOrderService.updateStateWorkOrder(workOrderFinished);
					endListWorkOrderBool=true;
				}
			}
			sleep(500);
		}
		setChanged();
		System.out.println(Thread.currentThread());
	}

	private void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
