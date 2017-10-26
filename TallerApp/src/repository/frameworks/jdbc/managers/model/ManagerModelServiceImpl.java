package repository.frameworks.jdbc.managers.model;

import java.sql.Connection;

import repository.entities.ModelRepo;
import repository.frameworks.RepositoryManagerFactory;
import repository.frameworks.jdbc.config.ConfigurationDB;
import repository.frameworks.jdbc.managers.model.cacheModel.ManagerCacheModelService;
import repository.frameworks.jdbc.managers.model.cacheModel.ManagerCacheModelServiceImpl;
import repository.frameworks.jdbc.managers.model.dao.ModelDao;

public class ManagerModelServiceImpl implements ManagerModelService {

	private final ManagerCacheModelService managerCacheModel;
	
	public ManagerModelServiceImpl() {
		this.managerCacheModel = RepositoryManagerFactory.getManagerCacheModelService();
	}
	@Override
	public void guardarModelRepoManage(ModelRepo modelRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		ModelDao modelDao = new ModelDao();
		
		managerCacheModel.loadAllModel();
		
		if(!managerCacheModel.checkModel(modelRepo))
		{
			modelDao.insertModelRepoInCache(modelRepo, connect);
			managerCacheModel.insertCacheModelRepoManage(modelRepo);
		}
		else{
			System.out.println("Ya existe el modelo.");
		}
	}

	@Override
	public void editarModelRepoManage(ModelRepo modelRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		ModelDao modelDao = new ModelDao();
		modelDao.editarModelRepo(modelRepo, connect);
	}

	@Override
	public void verModelRepoManage(ModelRepo modelRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		ModelDao modelDao = new ModelDao();
		modelDao.verModelRepo(modelRepo, connect);
	}
	
}
