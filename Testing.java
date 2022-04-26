import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/*
Testing.java
@author Jack Keane
Due date: 5/12/2020
*/
public class Testing {

	public static void main(String[] args) {
		ArrayList<Integer> randomList = new ArrayList<>(10000);
		Random random = new Random();
		
		// Adding values to array list.
		for (int i = 0; i < 10000; i++) {
			randomList.add(random.nextInt(10000));
		}

		ArrayList<Integer> sortedList = (ArrayList) randomList.clone();
		java.util.Collections.sort(sortedList);
		ArrayList<Integer> reverseList = (ArrayList) randomList.clone();
		java.util.Collections.reverse(reverseList);

		// Implementing all sorting methods.
		Sort.selectionSort(randomList);
		java.util.Collections.shuffle(randomList);
		Sort.insertionSort(randomList);
		java.util.Collections.shuffle(randomList);
		Sort.bubbleSort(randomList);
		java.util.Collections.shuffle(randomList);
		Sort.mergeSort(randomList);
		java.util.Collections.shuffle(randomList);
		Sort.quickSort(randomList);
		java.util.Collections.shuffle(randomList);
		Sort.heapSort(randomList);

		int[] ranIt = new int[6];
		for (int i = 0; i < 6; i++) {
			ranIt[i] = Sort.iterations[i];
		}

		// Sorting 
		Sort.selectionSort(sortedList);
		java.util.Collections.shuffle(sortedList);
		Sort.insertionSort(sortedList);
		java.util.Collections.shuffle(sortedList);
		Sort.bubbleSort(sortedList);
		java.util.Collections.shuffle(sortedList);
		Sort.mergeSort(sortedList);
		java.util.Collections.shuffle(sortedList);
		Sort.quickSort(sortedList);
		java.util.Collections.shuffle(sortedList);
		Sort.heapSort(sortedList);

		int[] sortIt = new int[6];
		for (int i = 0; i < 6; i++) {
			sortIt[i] = Sort.iterations[i];
		}

		Sort.selectionSort(reverseList);
		java.util.Collections.shuffle(reverseList);
		Sort.insertionSort(reverseList);
		java.util.Collections.shuffle(reverseList);
		Sort.bubbleSort(reverseList);
		java.util.Collections.shuffle(reverseList);
		Sort.mergeSort(reverseList);
		java.util.Collections.shuffle(reverseList);
		Sort.quickSort(reverseList);
		java.util.Collections.shuffle(reverseList);
		Sort.heapSort(reverseList);

		int[] reverseIt = new int[6];
		for (int i = 0; i < 6; i++) {
			reverseIt[i] = Sort.iterations[i];
		}

		String[] list = {	"Selection Sort:", 
							"Insertion Sort:", 
							"Bubble Sort:",
							"Quick Sort:", 
							"Merge Sort:",
							"Heap Sort:"};

		System.out.printf("%-15s\t%-10s\t\t%-10s\t\t%-10s\n", "Sorting Algorithm","Random List","Sorted List", "Reverse List");
		
		for(int i=0; i < 6; i++) {
			System.out.printf("%-15s\t\t%-10d\t\t%-10d\t\t%-10d\n", list[i],Sort.iterations[i],sortIt[i],reverseIt[i] );
		}

		/***
		 * When it comes to all lists, the same relatvie 
		 * number of iterations appears on routine. For 
		 * selection sort and insertion sort, all lists
		 * have the same number. Bubble sort, selection 
		 * sort and insertion sort share the same relative 
		 * range of numebrs for all lists. Merge, quick, 
		 * and heap sorts all see signafigantly less in 
		 * terms of the value of the numbers when comparing 
		 * them to the first 3. 
		 */
	}

}
