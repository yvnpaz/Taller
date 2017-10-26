package repository.frameworks.jdbc.managers.model.cacheModel;

import repository.entities.ModelRepo;

public interface ManagerCacheModelService {

	public ModelRepo insertCacheModelRepoManage(ModelRepo modelRepo);

	public void loadAllModel();

	public boolean checkModel(ModelRepo modelRepo);
}
