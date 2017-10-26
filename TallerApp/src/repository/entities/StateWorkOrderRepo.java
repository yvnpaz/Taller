package repository.entities;

public enum StateWorkOrderRepo {

	ABIERTA("Abierta"), EN_CURSO("En Curso"),CANCELADO("Cancelado"),
	CERRADA("Cerrada"); 
	
	private String stateRepo;
	
	private StateWorkOrderRepo (String stateRepo){
		this.stateRepo = stateRepo;
	}
	
	public String getStateWorkOrderRepo() {
		return stateRepo;
	}
}
