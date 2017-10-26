package repository.configurationRepo.caches;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import repository.entities.ClientRepo;
import repository.entities.VehicleRepo;

public class CacheVehicleRepo<K, V> extends LinkedHashMap<K, V>{

	private static final long serialVersionUID = 1L;
	private int limit;
	private String licensePlate;
	private VehicleRepo vehicleRepo;
	
	public CacheVehicleRepo(String licensePlate, VehicleRepo vehicleRepo)
	{
		this.licensePlate = licensePlate;
		this.vehicleRepo = vehicleRepo;
	}

	public CacheVehicleRepo()
	{
		this(100);
	}
	
	public CacheVehicleRepo(int maxLimit) {
		this.limit = maxLimit;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public VehicleRepo getVehicleRepo() {
		return vehicleRepo;
	}

	public void setVehicleRepo(VehicleRepo vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}
	
	public VehicleRepo getValor(CacheVehicleRepo<String, VehicleRepo> cacheVehicle, String licensePlate)
	{
		VehicleRepo valor = null;
		boolean esta = false;
		
		if(licensePlate != null && cacheVehicle != null)
		{
			Iterator<String> itr = cacheVehicle.keySet().iterator();
			while(itr.hasNext())
			{
				String itrLicPlate = itr.next();
				if(itrLicPlate == licensePlate && !esta)
				{
					valor = cacheVehicle.get(licensePlate);
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
