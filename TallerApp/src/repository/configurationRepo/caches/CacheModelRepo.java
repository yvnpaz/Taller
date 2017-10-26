package repository.configurationRepo.caches;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import repository.entities.ModelRepo;

public class CacheModelRepo<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;
	private int limit;
	private int codeModel;
	private ModelRepo modelRepo;

	public CacheModelRepo(int codeModel, ModelRepo modelRepo)
	{
		this.codeModel = codeModel;
		this.modelRepo = modelRepo;
	}
	
	public CacheModelRepo()
	{
		this(100);
	}
	
	public CacheModelRepo(int maxLimit) {
		this.limit = maxLimit;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCodeModel() {
		return codeModel;
	}

	public void setCodeModel(int codeModel) {
		this.codeModel = codeModel;
	}

	public ModelRepo getModelRepo() {
		return modelRepo;
	}

	public void setModelRepo(ModelRepo modelRepo) {
		this.modelRepo = modelRepo;
	}
	
	public ModelRepo getValor(CacheModelRepo<Integer, ModelRepo> cacheModel, int codeMo)
	{
		ModelRepo valor = null;
		boolean esta = false;
		
		if(codeMo != 0 && cacheModel != null)
		{
			Iterator<Integer> itr = cacheModel.keySet().iterator();
			while(itr.hasNext())
			{
				int itrDni = itr.next();
				if(itrDni == codeMo && !esta)
				{
					valor = cacheModel.get(codeMo);
					esta=true;
				}
			}
		}
		return valor;
	}


	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size() > this.limit;
	}
}
