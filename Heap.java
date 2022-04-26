/*
Heap.java
@author Jack Keane
Due date: 5/12/2020
*/
import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
	private ArrayList<E> list;

	// Constructor
	// Time complexity: O(1)
	public Heap() {
		list = new ArrayList<>();// empty heap with capacity 10
	}

	// Constructor
	// Time complexity: O(n log n)
	public Heap(E[] data) {
		list = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			Sort.iterations[5]++;
			// Time complexity: O(log n)
			insert(data[i]);
		}
	}
	
	// Constructor
	// Time complexity: O(log n)
	public Heap(ArrayList<E> data) {
		list = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			insert(data.get(i));
		}
	}

	
	/** 
	 * insert method
	 * @param E item
	 * @return int iterations
	 * Time complexity: O(n log n)
	 */
	public int insert(E item) {
		int iterations = 0;
		list.add(item); // adds new item to the heap
		int currIndex = list.size() - 1;
		// Time complexities: O(log n)
		while (currIndex > 0) {
			Sort.iterations[5]++;
			int parentIndex = ((currIndex - 1) / 2);
			E current = list.get(currIndex);
			E parent = list.get(parentIndex);
			if (current.compareTo(parent) > 0) {
				list.set(currIndex, parent);
				list.set(parentIndex, current);
			} else {
				break;
			}
			currIndex = parentIndex;
		}
		return iterations;
	}

	
	/** 
	 * Delete method
	 * @param none
	 * @return E 
	 * Time complexity: O( log n)
	 */
	public E delete() {
		if (list.size() == 0) {
			return null;
		}
		E removedItem = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		int currIndex = 0;
		// Searching for the max
		while (currIndex < list.size()) {
			Sort.iterations[5]++;
			int left = (2 * currIndex) + 1;
			int right = (2 * currIndex) + 2;
			if (left >= list.size()) {
				break;
			}
			
			int maxIndex = left;
			E max = list.get(maxIndex);
			if (right < list.size()) {
				if (max.compareTo(list.get(right)) < 0) {
					maxIndex = right;
				}
			}

			E current = list.get(currIndex);
			max = list.get(maxIndex);

			if (list.get(currIndex).compareTo(max) < 0) {
				list.set(maxIndex, current);
				list.set(currIndex, max);
				currIndex = maxIndex;
			} else {
				break;
			}	
		}
		return removedItem;
	}

	
	/** 
	 * @param E item
	 * @return int index
	 * Time complexity: O(n)
	 */
	public int search(E item) {
		int returnVal = 0;
		for (int i = 0; i < list.size(); i++) {
			returnVal++;
			if (list.get(i).equals(item)) {
				return returnVal;
			}	
		}
		return returnVal;
	}

	// Time Complexity: O(1)
	public int size() {
		return list.size();
	}

	// Time Complexity: O(1)
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// Time Complexity: O(1)
	public void clear() {
		list.clear();
	}

	// Time Complexity: O(n)
	public String toString() {
		return list.toString();
	}

}


