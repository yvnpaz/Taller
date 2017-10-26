package repository.frameworks.jdbc.managers.model.cacheModel;

import java.sql.Connection;
import java.util.Iterator;

import repository.configurationRepo.caches.CacheModelRepo;
import repository.entities.ModelRepo;
import repository.frameworks.jdbc.config.ConfigurationDB;
import repository.frameworks.jdbc.managers.model.dao.ModelDao;

public class ManagerCacheModelServiceImpl implements ManagerCacheModelService {

	CacheModelRepo<Integer, ModelRepo> cacheModelRepo = new CacheModelRepo<>();
	
	@Override
	public ModelRepo insertCacheModelRepoManage(ModelRepo modelRepo) {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		
		ModelDao modelDao = new ModelDao();
		ModelRepo modelRepoToRet = modelDao.insertModelRepoInCache(modelRepo, connect);
		
		return modelRepoToRet;
	}

	@Override
	public void loadAllModel() {
		ConfigurationDB.Conex();
		Connection connect = ConfigurationDB.getConex();
		
		ModelDao modelDao = new ModelDao();
		cacheModelRepo = modelDao.cargarModelRepo(connect);		
	}

	@Override
	public boolean checkModel(ModelRepo modelRepo) {
		Iterator<Integer> itr = cacheModelRepo.keySet().iterator();
		boolean thisOne = false;
		
		while(itr.hasNext())
		{
			int itrCodeMo = itr.next();
			ModelRepo model = cacheModelRepo.get(itrCodeMo);
			if(model.equals(modelRepo))
			{
				thisOne = true;
			}
		}
		return thisOne;
	}

}
