package repository.configurationRepo.caches;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheServiceRepo<K, V> extends LinkedHashMap<K, V> {

	private int limit;

	public CacheServiceRepo()
	{
		this(100);
	}
	
	public CacheServiceRepo(int maxLimit) {
		this.limit = maxLimit;
	}

	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size() > this.limit;
	}
	
	
}
