package domain.entities;

public enum ServiceType {

	MECANICA("Reparación mecánica", 40, "Alta"), ELECTRICA("Reparación eléctrica",35, "Media"),
	CHAPAYPINTURA("Chapa y Pintura",30, "Baja"), REVISION("Revisión",20, "Baja");
	
	private String tipoReparation;
	private int price;
	private String priority;
	
	private ServiceType (String tipoReparation, int price, String priority){
		this.tipoReparation = tipoReparation;
		this.price = price;
		this.priority = priority;
	}

	public String getTipoReparation() {
		return tipoReparation;
	}

	public void setTipoReparation(String tipoReparation) {
		this.tipoReparation = tipoReparation;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
}
