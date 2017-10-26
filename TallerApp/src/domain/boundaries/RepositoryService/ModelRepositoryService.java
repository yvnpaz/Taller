package domain.boundaries.RepositoryService;

import domain.entities.Model;

public interface ModelRepositoryService extends Repository<Model> {

	@Override
	void guardar(Model model);
	
	@Override
	void editar(Model model);
	
	@Override
	void ver(Model model);
}
