package repository.configurationRepo.caches;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import repository.entities.ClientRepo;

public class CacheClientRepo<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;
	private int limit;
	private int numDni;
	private ClientRepo clientRepo;

	public CacheClientRepo(int numDni, ClientRepo clientRepo)
	{
		this.numDni = numDni;
		this.clientRepo = clientRepo;
	}
	
	public CacheClientRepo()
	{
		this(100);
	}	

	public CacheClientRepo(int maxLimit) {
		this.limit = maxLimit;
	}
	
	public int getNumDni() {
		return numDni;
	}


	public void setNumDni(int numDni) {
		this.numDni = numDni;
	}

	public ClientRepo getClient() {
		return clientRepo;
	}

	public void setClient(ClientRepo clientRepo) {
		this.clientRepo = clientRepo;
	}
	
	public ClientRepo getValor(CacheClientRepo<Integer, ClientRepo> cacheClient, int dni)
	{
		ClientRepo valor = null;
		boolean esta = false;
		
		if(dni != 0 && cacheClient != null)
		{
			Iterator<Integer> itr = cacheClient.keySet().iterator();
			while(itr.hasNext())
			{
				int itrDni = itr.next();
				if(itrDni == dni && !esta)
				{
					valor = cacheClient.get(dni);
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
