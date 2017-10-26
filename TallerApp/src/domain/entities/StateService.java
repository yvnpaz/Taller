package domain.entities;

public enum StateService {
	
	PENDIENTE("Pendiente"), ENCURSO("En Curso"), FINALIZADO("Finalizado"),
	CANCELADO("Cancelado"); 
	
	private String state;
	
	private StateService (String state){
		this.state = state;
	}
	
	public String getStateService() {
		return state;
	}
}
