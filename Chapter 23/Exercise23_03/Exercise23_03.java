/*
Author: Dawson Rosenkrantz
Date: 12-01-22

Description: 
*/
import java.util.Comparator;

public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
  }
  
  public static <E extends Comparable<E>> void quickSort(E[] list) {
	  boolean isDone = false;
	  while (isDone != true) {
		  for (int i = 0; i < (int) (list.length /2); i++) {
			  E pivot = list[i];
			  E first = list[i + 1];
			  E last = list[list.length - 1 - i];
			  if ((first.compareTo(last) > 0) && (last.compareTo(pivot) < 0)) {
				  list[i] = last;
				  list[i+1] = pivot;
				  list[list.length - 1 - i] = first;
			  }
			  if ((first.compareTo(last) < 0) && (first.compareTo(pivot) < 0)) {
				  list[i] = first;
				  list[i+1] = pivot;
			  }
			  if ((last.compareTo(pivot) > 0) && (last.compareTo(list[list.length - 2 - i]) < 0)) {
				  list[list.length - 1 - i] = list[list.length - 2 - i];
				  list[list.length - 2 - i] = last;
			  }
		  }
		  int errors = 0;
		  for (int i = 0; i < list.length - 1; i++) {
			  E thisObject = list[i];
			  E nextObject = list[i+1];
			  if (thisObject.compareTo(nextObject) < 0) {
				  isDone = true;
			  }
			  if (thisObject.compareTo(nextObject) > 0) {
				  errors += 1;
				  list[i] = nextObject;
				  list[i+1] = thisObject;
			  }
		  }
		  if (errors != 0) {
			  isDone = false;
		  }
	  }
  }
  
  public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
	  boolean isDone = false;
	  while (isDone != true) {
		  for (int i = 0; i < (int) (list.length /2); i++) {
			  E pivot = list[i];
			  E first = list[i + 1];
			  E last = list[list.length - 1 - i];
			  if ((comparator.compare(first, last) > 0) && (comparator.compare(last, pivot) < 0)) {
				  list[i] = last;
				  list[i+1] = pivot;
				  list[list.length - 1 - i] = first;
			  }
			  if ((comparator.compare(first, last) < 0) && (comparator.compare(first, pivot) < 0)) {
				  list[i] = first;
				  list[i+1] = pivot;
			  }
			  if ((comparator.compare(last, pivot) > 0) && (comparator.compare(last ,list[list.length - 2 - i]) < 0)) {
				  list[list.length - 1 - i] = list[list.length - 2 - i];
				  list[list.length - 2 - i] = last;
			  }
		  }
		  int errors = 0;
		  for (int i = 0; i < list.length - 1; i++) {
			  E thisObject = list[i];
			  E nextObject = list[i+1];
			  if (comparator.compare(thisObject, nextObject) < 0) {
				  isDone = true;
			  }
			  if (comparator.compare(thisObject, nextObject) > 0) {
				  errors += 1;
				  list[i] = nextObject;
				  list[i+1] = thisObject;
			  }
		  }
		  if (errors != 0) {
			  isDone = false;
		  }
	  }
  }
  
}