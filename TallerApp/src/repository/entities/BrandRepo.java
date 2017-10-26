package repository.entities;

public class BrandRepo {

	private int codeRepo;
	private String nameRepo;
	private String placeRepo;
	
	public BrandRepo() {}
	
	public BrandRepo(int codeRepo, String nameRepo, String placeRepo) {
		super();
		this.codeRepo = codeRepo;
		this.nameRepo = nameRepo;
		this.placeRepo = placeRepo;
	}

	public int getCodeRepo() {
		return codeRepo;
	}

	public void setCodeRepo(int codeRepo) {
		this.codeRepo = codeRepo;
	}

	public String getNameRepo() {
		return nameRepo;
	}

	public void setNameRepo(String nameRepo) {
		this.nameRepo = nameRepo;
	}

	public String getPlaceRepo() {
		return placeRepo;
	}

	public void setPlaceRepo(String placeRepo) {
		this.placeRepo = placeRepo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codeRepo;
		result = prime * result + ((nameRepo == null) ? 0 : nameRepo.hashCode());
		result = prime * result + ((placeRepo == null) ? 0 : placeRepo.hashCode());
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
		BrandRepo other = (BrandRepo) obj;
		if (codeRepo != other.codeRepo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BrandRepo [codeRepo=" + codeRepo + ", nameRepo=" + nameRepo + ", placeRepo=" + placeRepo + "]";
	}
	
}
