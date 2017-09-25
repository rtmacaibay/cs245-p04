/**
 * Creates an array queue object
 * @author Robert Macaibay
 * @class cs245
 */

public class ArrayQueue implements Queue {
	//global variables
	private Object[] a; //object array
	private int head; //head of the array
	private int tail; //tail, where the next object would be placed
	private int size; //number of elements in the array
	
	/**
	 * Constructor
	 */
	public ArrayQueue() {
		a = new Object[10];
		head = 0;
		tail = 0;
		size = 0;
	}
	
	/**
	 * Takes off the object at the "front" of the array
	 * @return the object that used to be at the front
	 */
	public Object dequeue() {
		//check if array is empty. if so, return nothing
		if (empty())
			return null;
		
		//reduce the number of elements in the array
		size--;
		//return and also lose the object in the front
		return a[head++ % a.length];
	}

	/**
	 * Adds an object at the end
	 * @param item - object to add
	 */
	public void enqueue(Object item) {
		//checks if array is full. if so, grow the array
		if (head == tail && size > 0)
			growQueue();
		
		//increase the number of elements
		size++;
		//add object at the end
		a[tail++ % a.length] = item;
		//"reset" tail and head to their position in the array
		tail %= a.length;
		head %= a.length;
	}

	/**
	 * Checks if the array is empty
	 * @return whether or not the array is empty
	 */
	public boolean empty() {
		//checks the number of elements in the array
		if (size == 0) 
			return true;
		return false;
	}

	/**
	 * Grows the array
	 */
	private void growQueue() {
		//creates a copy of the array and transfer it over
		Object[] temp = new Object[a.length * 2];
		
		System.arraycopy(a, head, temp, 0, a.length - head);
		System.arraycopy(a, 0, temp, head, tail);
		
		a = temp;
		
		//"reset" head and tail bc they might've looped around originally
		head = 0;
		tail = size;
	}
}
