package repository.boundaries.implementService;

import java.text.MessageFormat;
import java.util.logging.Logger;

import domain.boundaries.RepositoryService.BrandRepositoryService;
import domain.entities.Brand;
import repository.boundaries.implementManager.RepositoryManager;
import repository.entities.BrandRepo;
import repository.frameworks.RepositoryManagerFactory;

public class BrandRepositoryServiceImpl implements BrandRepositoryService{

	private final RepositoryManager repositoryManager;
	private final Logger LOG = Logger.getLogger(BrandRepositoryServiceImpl.class.getName());
	
	public BrandRepositoryServiceImpl() {
		super();
		this.repositoryManager = RepositoryManagerFactory.getRepositoryManager();
	}

	@Override
	public void guardar(Brand brand) {
		
		LOG.info(MessageFormat.format("Entro guardar: {0} **", brand));
		BrandRepo brandRepo = buildBrandRepo(brand);
		this.repositoryManager.guardarBrandRepo(brandRepo);
		
		LOG.info(MessageFormat.format("Salgo guardarRepo: {0} **", brandRepo));
	}

	@Override
	public void editar(Brand brand) {
		// TODO Auto-generated method stub
		LOG.info(MessageFormat.format("Entro editar: {0} **", brand));
		BrandRepo brandRepo = buildBrandRepo(brand);
		this.repositoryManager.editarBrandRepo(brandRepo);
		
		LOG.info(MessageFormat.format("Salgo editarRepo: {0} **", brandRepo));
	}

	@Override
	public void ver(Brand brand) {
		// TODO Auto-generated method stub
		LOG.info(MessageFormat.format("Entro ver: {0} **", brand));
		BrandRepo brandRepo = buildBrandRepo(brand);
		this.repositoryManager.verBrandRepo(brandRepo);
		
		LOG.info(MessageFormat.format("Salgo verRepo: {0} **", brandRepo));
	}

	public BrandRepo buildBrandRepo(Brand brand)
	{
		BrandRepo brandRepo = new BrandRepo(brand.getCode(), brand.getName(), brand.getPlace());
		return brandRepo;
	}
	
	
}
