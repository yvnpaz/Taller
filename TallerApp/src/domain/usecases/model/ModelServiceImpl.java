package domain.usecases.model;

import domain.boundaries.RepositoryService.ModelRepositoryService;
import domain.boundaries.Services.ManagementService;
import domain.entities.Model;
import domain.usecases.commons.Insert;
import domain.usecases.commons.Load;
import domain.usecases.commons.Update;
import repository.boundaries.RepositoryFactory;

public class ModelServiceImpl implements ManagementService<Model> {

	private final ModelRepositoryService modelRepository;
	
	public ModelServiceImpl() {
		this.modelRepository = RepositoryFactory.getModelRepositoryService();
	}
	@Override
	public void insert(Model model) {
		new Insert<Model>().execute(modelRepository, model);
	}

	@Override
	public void update(Model model) {
		new Update<Model>().execute(modelRepository, model);
	}

	@Override
	public void load(Model model) {
		new Load<Model>().execute(modelRepository, model);
	}

}
