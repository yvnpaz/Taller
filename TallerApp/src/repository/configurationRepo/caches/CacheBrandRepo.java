package repository.configurationRepo.caches;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import repository.entities.BrandRepo;

public class CacheBrandRepo<K, V> extends LinkedHashMap<K, V> {
	
	private static final long serialVersionUID = 1L;
	private int limit;
	private int codeBr;
	private BrandRepo brandRepo;

	public CacheBrandRepo(int codeBrand, BrandRepo brandRepo)
	{
		this.codeBr = codeBrand;
		this.brandRepo = brandRepo;
	}
	
	public CacheBrandRepo()
	{
		this(100);
	}
	
	public CacheBrandRepo(int maxLimit) {
		this.limit = maxLimit;
	}

	public int getCodeBr() {
		return codeBr;
	}

	public void setCodeBr(int codeBr) {
		this.codeBr = codeBr;
	}

	public BrandRepo getBrandRepo() {
		return brandRepo;
	}

	public void setBrandRepo(BrandRepo brandRepo) {
		this.brandRepo = brandRepo;
	}

	public BrandRepo getValor(CacheBrandRepo<Integer, BrandRepo> cacheBrand, int codeBrand)
	{
		BrandRepo valor = null;
		boolean esta = false;
		
		if(codeBrand != 0 && cacheBrand != null)
		{
			Iterator<Integer> itr = cacheBrand.keySet().iterator();
			while(itr.hasNext())
			{
				int itrCodeBr = itr.next();
				if(itrCodeBr == codeBrand && !esta)
				{
					valor = cacheBrand.get(codeBrand);
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
