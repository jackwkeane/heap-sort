# Grade: 100.0/100.0
Completed Spring of 2021 as a part of Lehigh University's CSE 017: Programming and Data Structures. 

## Project Description
1\. Create the class Heap with a third constructor that takes a parameter data of type ArrayList<E> and builds the heap from data.
  
  
2\. Create a class Sort that contains the definition of static methods for the sorting algorithms covered in class (selection sort, insertion sort, bubble sort, merge sort, quick sort, heap sort) and ALA 10.
  
  
3\. All sorting methods should calculate the number of iterations and store it in a static variable inside the class Sort.
  
  
4\. Create a class Testing for the test program. Create three array lists of type Integer and size 10,000 for the data sets with the specification below:
  
  a. randomList: array list filled with random integers in the range 0 to 9999. Use the method java.util.Collections.shuffle() to shuffle randomList after each sorting algorithm.
  
  b. sortedList: contains the same data as randomList in ascending order. To obtain sortedList, clone randomList and sort the cloned list using the method java.util.Collections.sort().
  
  c. reversedList(): contains the same data as sortedList in descending order. To obtain reversedList, clone sortedList and reverse the cloned list using the method java.util.Collections.reverse(). Do not forget to reverse reversedList after each sorting algorithm.

5\. Call each sorting method on the three data sets generated in step 4 and record the number of iterations for each sorting algorithm on each data set. Then display the results in a tabular form.
