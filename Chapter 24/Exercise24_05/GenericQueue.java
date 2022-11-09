import java.util.*;

public class GenericQueue<E> extends LinkedList<Object>{
	LinkedList<E> list = new LinkedList<E>();
	
	public void enqueue(E e) {
		list.addLast(e);
	}
	
	public E dequeque() {
		return list.removeFirst();
	}
	
	public int getSize() {
		return list.size();
	}
	
	@Override
	public String toString() {
		return "Queue: " + list.toString();
	}

	public static void main(String[] args) {
		System.out.println("What does it take to get the job done?");
		GenericQueue<String> queue = new GenericQueue<String>();
		queue.enqueue("blood");
		queue.enqueue("sweat");
		queue.enqueue("tears");
		System.out.println(queue.toString());
		System.out.println("Hold up, scratch that first one...");
		queue.dequeque();
		System.out.println(queue.toString());
	}

}
