package repository.configurationRepo.caches;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheWorkOrderRepo<K, V> extends LinkedHashMap<K, V> {

	private int limit;

	public CacheWorkOrderRepo()
	{
		this(200);
	}
	
	public CacheWorkOrderRepo(int maxLimit) {
		this.limit = maxLimit;
	}

	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size() > this.limit;
	}
}
