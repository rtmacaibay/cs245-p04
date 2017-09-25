/**
 * Creates an array stack object
 * @author Robert Macaibay
 * @class cs245
 */

public class ArrayStack implements Stack {
	//global variables
	private Object[] a; //object array
	private int top; //index of the top most object
	
	/**
	 * Constructor
	 */
	public ArrayStack() {
		a = new Object[10];
		top = 0;
	}
	
	/**
	 * Adds an object to the top
	 * @param item - any object to add to an array
	 */
	public void push(Object item) {
		//checks if array is full. if so, grow it
		if (top == a.length)
			growStack();
		
		//add an object to the array
		a[top++] = item;
	}

	/**
	 * Takes off an object from the top and returns the removed object
	 * @return the removed object
	 */
	public Object pop() {
		//checks if array is empty. if so, return nothing
		if (empty())
			return null;
		
		//return the object at the top and "remove" it
		return a[--top];
	}
	
	/**
	 * Looks at the object on the top
	 * @return the top object
	 */
	public Object peek() {
		//checks if array is empty. if so, return nothing
		if (empty())
			return null;
		
		//return the object at the top
		return a[top - 1];
	}

	/**
	 * Checks if the array is empty
	 * @return whether or not the array is empty
	 */
	public boolean empty() {
		//checks if top is 0, meaning no objects have been added
		if (top == 0)
			return true;
		return false;
	}

	/**
	 * Grows the length of the array to twice its size
	 */
	private void growStack() {
		//create a copy of the array with twice its size and transfer it over
		Object[] temp = new Object[a.length * 2];
		System.arraycopy(a, 0, temp, 0, a.length);
		a = temp;
	}
}
