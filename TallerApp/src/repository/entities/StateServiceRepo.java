package repository.entities;

public enum StateServiceRepo {

	PENDIENTE("Pendiente"), ENCURSO("En Curso"), FINALIZADO("Finalizado"),
	CANCELADO("Cancelado"); 
	
	private String stateRepo;
	
	private StateServiceRepo (String stateRepo){
		this.stateRepo = stateRepo;
	}
	
	public String getStateServiceRepo() {
		return stateRepo;
	}
}
