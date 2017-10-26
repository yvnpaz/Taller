package domain.entities;

public class Model {
	
	private int code;
	private String nameCommertial;
	private int anio;
	
	public Model(int code, String nameCommertial, int anio) {
		super();
		this.code = code;
		this.nameCommertial = nameCommertial;
		this.anio = anio;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNameCommertial() {
		return nameCommertial;
	}

	public void setNameCommertial(String nameCommertial) {
		this.nameCommertial = nameCommertial;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anio;
		result = prime * result + code;
		result = prime * result + ((nameCommertial == null) ? 0 : nameCommertial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Model other = (Model) obj;
		if (anio != other.anio)
			return false;
		if (code != other.code)
			return false;
		if (nameCommertial == null) {
			if (other.nameCommertial != null)
				return false;
		} else if (!nameCommertial.equals(other.nameCommertial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Model [code=" + code + ", nameCommertial=" + nameCommertial + ", anio=" + anio + "]";
	}

}
