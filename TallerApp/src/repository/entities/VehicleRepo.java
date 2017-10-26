package repository.entities;


public class VehicleRepo {
	private String licensePlateRepo;
	private BrandRepo brandRepo;
	private ModelRepo modelRepo;
	
	public VehicleRepo(String licensePlateRepo, BrandRepo brandRepo, ModelRepo modelRepo) {
		super();
		this.licensePlateRepo = licensePlateRepo;
		this.brandRepo = brandRepo;
		this.modelRepo = modelRepo;
	}

	public String getLicensePlateRepo() {
		return licensePlateRepo;
	}

	public void setLicensePlateRepo(String licensePlateRepo) {
		this.licensePlateRepo = licensePlateRepo;
	}

	public BrandRepo getBrandRepo() {
		return brandRepo;
	}

	public void setBrandRepo(BrandRepo brandRepo) {
		this.brandRepo = brandRepo;
	}

	public ModelRepo getModelRepo() {
		return modelRepo;
	}

	public void setModelRepo(ModelRepo modelRepo) {
		this.modelRepo = modelRepo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brandRepo == null) ? 0 : brandRepo.hashCode());
		result = prime * result + ((licensePlateRepo == null) ? 0 : licensePlateRepo.hashCode());
		result = prime * result + ((modelRepo == null) ? 0 : modelRepo.hashCode());
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
		VehicleRepo other = (VehicleRepo) obj;
		if (licensePlateRepo == null) {
			if (other.licensePlateRepo != null)
				return false;
		} else if (!licensePlateRepo.equals(other.licensePlateRepo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VehicleRepo [licensePlateRepo=" + licensePlateRepo + ", brandRepo=" + brandRepo + ", modelRepo="
				+ modelRepo + "]";
	}
	
}
