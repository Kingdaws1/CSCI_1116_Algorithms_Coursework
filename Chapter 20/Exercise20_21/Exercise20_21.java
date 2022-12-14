/*
Author: Dawson Rosenkrantz
Date: 10/31/22

Description: 
*/
import java.util.ArrayList;
import java.util.Comparator;

public class Exercise20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};

    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    selectionSort(list, new GeometricObjectComparator());
    for (int i = 0; i < list.length; i++)
      System.out.println(list[i].getArea() + " ");
  }
  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
	  ArrayList<E> coppiedList = new ArrayList<E>();
	  for (int i = 0; i < list.length; i++) {
		  coppiedList.add(list[i]);
	  }
	  int howBig = coppiedList.size();
	  ArrayList<E> sortedList = new ArrayList<E>();
	  int largestObject = 0;
	  while (sortedList.size() < howBig) {
		  for (int i = 0; i < coppiedList.size(); i++) {
			  if (comparator.compare(coppiedList.get(largestObject), coppiedList.get(i)) == -1) {
				  largestObject = i;
			  }
		  }
		  sortedList.add(coppiedList.get(largestObject));
		  coppiedList.remove(largestObject);
		  largestObject = 0;
	  }
	  for (int i = 0; i < sortedList.size(); i ++) {
		  list[i] = sortedList.get(i);
	  }
  }
}