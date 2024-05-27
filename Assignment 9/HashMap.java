import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

	private List<List<Entry<K,V>>> 	table;
	private int	count;
	private int  tableSize;

	// For Part III
	private long getLoops;
	private long putLoops;
	

	public HashMap() {
		tableSize = 1000003; // prime number
		table = new ArrayList<List<Entry<K,V>>>(tableSize);

		// initializes table as a list of empty lists
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<Entry<K,V>>());
		}

		count = 0;

		// For Part III:
		resetGetLoops();
		resetPutLoops();
	}

	// For Part III
	public long getGetLoopCount() {
		return getLoops;
	}

	// For Part III
	public long getPutLoopCount() {
		return putLoops;
	}

	// For Part III
	public void resetGetLoops() {
		getLoops = 0;
	}
	
	// For Part III
	public void resetPutLoops() {
		putLoops = 0;
	}

	public boolean containsKey(K key) {
		
		
		int i = Math.abs(key.hashCode() % tableSize);

		List<Entry<K,V>> list = table.get(i);
        
		for (Entry<K,V> h : list){

            if (h.getKey().compareTo(key) == 0){
                return true;
            }
        }
        return false;

	}

	public V get (K key) throws KeyNotFoundException {
		
		
		int i = Math.abs(key.hashCode() % tableSize);

		List <Entry<K,V>> list = table.get(i);
        for (Entry<K,V> h : list){

            if (h.getKey().compareTo(key) == 0){

                return h.getValue();
            }
        }

		throw new KeyNotFoundException();
		
	}


	public List<Entry<K,V>>	entryList() {
		List <Entry<K,V>> result = new LinkedList<Entry<K,V>>();
		
		int i = 0;
        while (i < tableSize - 1){
            List <Entry<K,V>> list = table.get(i);
            result.addAll(list);
            i++;
        }

		return result;
	}
	
	public void put(K key, V value){
		
		int i = Math.abs(key.hashCode() % tableSize);

		List<Entry<K,V>> list = table.get(i);
        Iterator<Entry<K,V>> iter = list.iterator();

        boolean check = false;
        while (iter.hasNext()) {
            if (iter.next().key.compareTo(key) == 0) {
                list.get(0).setValue(value);
            }
            check = true;
        }
        if (!check){
            Entry<K,V> newInsert = new Entry<>(key, value);
            list.add(newInsert);
            table.set(i, list);
            count++;
        }


	}

	public int size() {
		return count;
	}

    public void clear() {
		for(int i = 0; i < tableSize; i++) {
			table.get(i).clear();
		}
        count = 0;
    }

}