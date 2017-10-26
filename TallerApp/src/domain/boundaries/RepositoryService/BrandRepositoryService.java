package domain.boundaries.RepositoryService;

import domain.entities.Brand;

public interface BrandRepositoryService extends Repository<Brand> {

	@Override
	void guardar(Brand brand);
	
	@Override
	void editar(Brand brand);
	
	@Override
	void ver(Brand brand);
}
