/*
Sort.java
@author Jack Keane
Due date: 5/12/2020
*/

import java.util.ArrayList;

public class Sort {
	public static int[] iterations = new int[6];
	
	// Selection Sort
	// Time Complexity: O(n^2)
	public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
		int minIndex;
		iterations[0]=0;
		for (int i = 0; i < list.size()-1; i++) {
			iterations[0]++;
			E min = list.get(i);
			minIndex = i;
			for (int j = i + 1; j < list.size(); j++) {
				iterations[0]++;
				if (list.get(j).compareTo(min)< 0) {
					min = list.get(j);
					minIndex = j;
				}
			}
			E temp = list.get(i);
			list.set(i, list.get(minIndex));
			list.set(minIndex, temp);
			
		}
	}

	
	// Insertion Sort
	// Time Complexity: O(N^2)
	public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {
		iterations[1]=0;
		for (int i = 1; i < list.size(); i++) {
			iterations[1]++;
			// inserts element i in the sorted sublist
			E currentVal = list.get(i);
			int j = i;
			while (j > 0 && currentVal.compareTo((list.get(j - 1)))<0) {
				iterations[1]++;
				// shift element j-1 into element j
				list.set(j,list.get(j - 1));
				j--;
			}
			// inserts currentVal at position i
			list.set(j,currentVal);
		}
	}

	// Bubble Search
	// Time Complexity: O(N^2)
	public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
		iterations[2] = 0;
		boolean sorted = false;
		for (int k = 1; k < list.size() && !sorted; k++) {
			iterations[2]++;
			sorted = true;
			for (int i = 0; i < list.size() - k; i++) {
				iterations[2]++;
				if (list.get(i).compareTo(list.get(i + 1))>0) {
					E temp = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
					sorted = false;
				}
			}

		}	
	}
	// Merge Sort
	// Time Complexity: O(n log n)
	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
		iterations[3]++;

		// Base case
		if (list.size() > 1) {
			ArrayList<E> firstHalf = subList(list, 0, list.size()/2);
			ArrayList<E> secondHalf = subList(list, list.size()/2,list.size());
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list);
		}
	}

	// subList Method
	public static  <E extends Comparable<E>> ArrayList<E> subList(ArrayList<E> list, int start, int end){
		ArrayList<E> newList = new ArrayList<>();
		for(int i=start; i<end; i++) {
			iterations[3]++;
			newList.add(list.get(i));
		}
		return newList;
	}

	// Merge Method
	// Time Complexity: O(n log n)
	public static <E extends Comparable<E>> void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> list) {
		int list1Index = 0;
		int list2Index = 0;
		int listIndex = 0;
		while( list1Index < list1.size() && list2Index < list2.size()) {
			iterations[3]++;
			if (list1.get(list1Index).compareTo(list2.get(list2Index))<0) {
				list.set(listIndex++,list1.get(list1Index++));
			} else {
				list.set(listIndex++,list2.get(list2Index++));
			}	
		}
		
		while(list1Index < list1.size()) {
			iterations[3]++;
			list.set(listIndex++,list1.get(list1Index++));
		}
			
		while(list2Index < list2.size()){
			iterations[3]++;
			list.set(listIndex++,list2.get(list2Index++));
		}
	}

	// Quicksort Method
	// Time complexity: O(n log n), worst case: O(n^2)
	public static  <E extends Comparable<E>> void quickSort(ArrayList<E> list, int first, int last) {
		iterations[4]++;
		if(last>first) {
			int pivotIndex = partition(list,first,last);
			quickSort(list,first,pivotIndex-1);
			quickSort(list, pivotIndex+1, last);
		}
	}
	
	// Quicksort Method
	public static  <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
		quickSort(list,0,list.size()-1);
	}

	
	// Heap sort
	public static <E extends Comparable<E>> void heapSort(ArrayList<E> list) {
		Heap<E> heap = new Heap<>(list);
		for(int i=list.size()-1; i>=0;i--) {
			iterations[5]++;
			list.set(i,heap.delete());
		}
	}

	// Partition Method
	public static  <E extends Comparable<E>> int partition(ArrayList<E> list, int first, int last) {
		E pivot;
		int index, pivotIndex;
		pivot=list.get(first);
		pivotIndex=first;
		for(index=first+1; index <= last; index++ ) {
			iterations[4]++;
			if(list.get(index).compareTo(pivot) < 0) {
				pivotIndex++;
				swap(list,pivotIndex, index);
			}
		}
		swap(list,first,pivotIndex);
		return pivotIndex;
	}


	// Swap Method
	public static <E> void swap(ArrayList<E> list, int i, int j) {
		E temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

}

