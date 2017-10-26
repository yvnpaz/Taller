package repository.entities;

public class ModelRepo {

	private int codeRepo;
	private String nameCommertialRepo;
	private int anioRepo;
	
	public ModelRepo(int codeRepo, String nameCommertialRepo, int anioRepo) {
		super();
		this.codeRepo = codeRepo;
		this.nameCommertialRepo = nameCommertialRepo;
		this.anioRepo = anioRepo;
	}

	public int getCodeRepo() {
		return codeRepo;
	}

	public void setCodeRepo(int codeRepo) {
		this.codeRepo = codeRepo;
	}

	public String getNameCommertialRepo() {
		return nameCommertialRepo;
	}

	public void setNameCommertialRepo(String nameCommertialRepo) {
		this.nameCommertialRepo = nameCommertialRepo;
	}

	public int getAnioRepo() {
		return anioRepo;
	}

	public void setAnioRepo(int anioRepo) {
		this.anioRepo = anioRepo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anioRepo;
		result = prime * result + codeRepo;
		result = prime * result + ((nameCommertialRepo == null) ? 0 : nameCommertialRepo.hashCode());
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
		ModelRepo other = (ModelRepo) obj;
		if (codeRepo != other.codeRepo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ModelRepo [codeRepo=" + codeRepo + ", nameCommertialRepo=" + nameCommertialRepo + ", anioRepo="
				+ anioRepo + "]";
	}
	
}
