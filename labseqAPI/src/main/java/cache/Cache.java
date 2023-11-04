package cache;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.math.BigInteger;

public class Cache {

	private int cacheSize;
	private LinkedHashMap<Integer, BigInteger[]> cache;
	
	public Cache(int cacheSize) {
		this.cacheSize = cacheSize;
		
		this.cache = new LinkedHashMap<Integer, BigInteger[]>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, BigInteger[]> eldest) {
                return size() > cacheSize;
            }
        };

	}

	//We add the solution to what was asked and the last 3 values
	//Example if we lookup L(20) -> We store L(20), L(19), L(18), L(17)
	public void addToCache(int seqNumber, BigInteger solutions[]) {
		this.cache.put(seqNumber, solutions);
		
		String setAsString = this.cache.keySet().toString();
	}

	public BigInteger[] checkCache(int n) {
		return this.cache.get(n);
	}
	
	public Set<Integer> getKeys()
	{
		return cache.keySet();
	}

}
