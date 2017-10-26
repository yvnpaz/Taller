package repository.entities;

public enum ServiceTypeRepo {
	
	MECANICA("Reparación mecánica", 40, "Alta"), ELECTRICA("Reparación eléctrica",35, "Media"),
	CHAPAYPINTURA("Chapa y Pintura",30, "Baja"), REVISION("Revisión",20, "Baja");
	
	private String tipoReparationRepo;
	private int priceRepo;
	private String priorityRepo;
	
	
	private ServiceTypeRepo(String tipoReparationRepo, int priceRepo, String priorityRepo) {
		this.tipoReparationRepo = tipoReparationRepo;
		this.priceRepo = priceRepo;
		this.priorityRepo = priorityRepo;
	}


	public String getTipoReparationRepo() {
		return tipoReparationRepo;
	}


	public void setTipoReparationRepo(String tipoReparationRepo) {
		this.tipoReparationRepo = tipoReparationRepo;
	}


	public int getPriceRepo() {
		return priceRepo;
	}


	public void setPriceRepo(int priceRepo) {
		this.priceRepo = priceRepo;
	}


	public String getPriorityRepo() {
		return priorityRepo;
	}


	public void setPriorityRepo(String priorityRepo) {
		this.priorityRepo = priorityRepo;
	}
	
	
	
}
