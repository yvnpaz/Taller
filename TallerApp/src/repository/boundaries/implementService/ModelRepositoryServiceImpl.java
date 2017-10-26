package repository.boundaries.implementService;

import java.text.MessageFormat;
import java.util.logging.Logger;

import domain.boundaries.RepositoryService.ModelRepositoryService;
import domain.entities.Model;
import repository.boundaries.implementManager.RepositoryManager;
import repository.entities.ModelRepo;
import repository.frameworks.RepositoryManagerFactory;

public class ModelRepositoryServiceImpl implements ModelRepositoryService {

	private final RepositoryManager repositoryManager;
	private final Logger LOG = Logger.getLogger(BrandRepositoryServiceImpl.class.getName());
	
	public ModelRepositoryServiceImpl() {
		this.repositoryManager = RepositoryManagerFactory.getRepositoryManager();
	}

	@Override
	public void guardar(Model model) {
		
		LOG.info(MessageFormat.format("Entro guardarModel: {0} **", model));
		ModelRepo modelRepo = buildModelRepo(model);
		this.repositoryManager.guardarModelRepo(modelRepo);
		
		LOG.info(MessageFormat.format("Salgo guardarRepo: {0} **", model));
	}

	@Override
	public void editar(Model model) {
		
		LOG.info(MessageFormat.format("Entro editarModel: {0} **", model));
		ModelRepo modelRepo = buildModelRepo(model);
		this.repositoryManager.editarModelRepo(modelRepo);
		
		LOG.info(MessageFormat.format("Salgo editarRepo: {0} **", model));
	}

	@Override
	public void ver(Model model) {
		
		LOG.info(MessageFormat.format("Entro verModel: {0} **", model));
		ModelRepo modelRepo = buildModelRepo(model);
		this.repositoryManager.verModelRepo(modelRepo);
		
		LOG.info(MessageFormat.format("Salgo verRepo: {0} **", model));
	}
	
	public ModelRepo buildModelRepo(Model model)
	{
		ModelRepo modelRepo = new ModelRepo(model.getCode(), model.getNameCommertial(), model.getAnio());
		return modelRepo;
	}
	
}
