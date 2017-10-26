package domain.entities;

public enum StateWorkOrder {

	ABIERTA("Abierta"), EN_CURSO("En Curso"), CANCELADO("Cancelado"),
	CERRADA("Cerrada"); 
	
	private String state;
	
	private StateWorkOrder (String state){
		this.state = state;
	}
	
	public String getStateWorkOrder() {
		return state;
	}
}
