/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeMin is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
public class HeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected T[] storage;
	protected int currentSize;
	
	// Feel free to change rootIndex to 0 if you want to 
	// use 0-based indexing (either option is fine)
	private static final int rootIndex = 1;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	@SuppressWarnings({"unchecked"})
	public HeapPriorityQueue(Class<T> dataType) {
		// Creating generics arrays in Java is not very clean. The following 
		// two lines allocate the generic array for you based on whether you
		// have selected to store the root at index 0 or 1 above.
		if (rootIndex == 0) {
			storage = (T[]) java.lang.reflect.Array.newInstance(dataType, DEFAULT_SIZE);
		} else {
			storage = (T[]) java.lang.reflect.Array.newInstance(dataType, DEFAULT_SIZE+1);
		}
		currentSize = 0;
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	@SuppressWarnings({"unchecked"})
	public HeapPriorityQueue(Class<T> clazz, int size) {
		// Creating generics arrays in Java is not very clean. The following 
		// two lines allocate the generic array for you based on whether you
		// have selected to store the root at index 0 or 1 above.
		if (rootIndex == 0) {
			storage = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
		} else {
			storage = (T[]) java.lang.reflect.Array.newInstance(clazz, 99999999+1);
		}
		currentSize = 0;
	}

	public void insert (T element) throws HeapFullException {
		if (isFull()) {
            throw new HeapFullException();
        }
        currentSize++;
        storage[currentSize] = element;

		int cur = currentSize;

		bubbleUp(cur);
	
		
    
		}
		
		// When inserting the first element, choose whether to use 
		// a 0-based on 1-based implementation. (By default, the root
		// index is set to 1 for you above. Whatever you choose,
		// make sure your implementation for the rest of the program
		// is consistent with this choice.		
    
	
	private void bubbleUp(int index) {
		if (storage[index/2] != null && storage[index].compareTo(storage[index/2]) < 0) {
			
				T temp = storage[index];
				storage[index] = storage[index/2];
				storage[index/2] = temp;

				bubbleUp(index/2);
			
			
		}
		}
			
	public T removeMin() throws HeapEmptyException {
		if (currentSize == 0) {
			throw new HeapEmptyException();
		}
		T temp = storage[1];
		storage[1] = storage[currentSize];
		storage[currentSize] = null;

		currentSize--;
		bubbleDown(1);
		return temp;
	}
	
	private void bubbleDown(int index) {
		if (storage[2*index] != null || storage[2*index + 1] != null) {
			T left = storage[2*index];
			T right = storage[2*index + 1];
			T smallest = null;

			if (right == null) {
				smallest = left;
			} else if (left == null) {
				smallest = right;
			}
			
			else if (left.compareTo(right) > 0) {
				smallest = right;
				
			} else { 
				smallest = left;
				}
				if (storage[index].compareTo(smallest) > 0) {
					T temp = storage[index];
					if (smallest == left) {
						storage[index] = left;
						storage[2*index] = temp;
						bubbleDown(2*index);	
					} else if (smallest == right) {
						storage[index] = right;
						storage[2*index + 1] = temp;
						bubbleDown(2*index + 1);
					}
			
					
					
				}
		}
	
	}

	public boolean isEmpty(){
		return size() == 0;
	}
	
	public boolean isFull() {
		return currentSize == storage.length;
	}
	
	public int size () {
		return currentSize;                                                                                        
	}

	public String toString() {
		String s = "";
		String sep = "";
		if (rootIndex == 0) {
			for (int i = 0; i < currentSize; i++) {
				s += sep + storage[i];
				sep = " ";				
			}
		} else if (rootIndex == 1) {
			for(int i=1; i<=currentSize; i++) {
				s += sep + storage[i];
				sep = " ";
			}
		}
		return s;
	}
}
