// Colby Gilbert
// 1362977
// CSE 373 winter 2017
// Kiley Porter

// DESCRIPTION: Array implementation of DStack includes extra public methods, .size(), .clear() 
// 				will expand and shrink as stack fills and empties
import java.util.EmptyStackException;

public class ArrayStack implements DStack {
	
	
	public ArrayStack() {
		doClear();
	}
	
	// Returns boolean true if empty
	public boolean isEmpty() {
		return size() < 0;
	}

	// pushes one element to stack 
	// will expand if stack becomes filled
	public void push(double d) {
		if(size() == (this.arr.length - 1)) {
			resize(this.arr.length * 2);
		}
		
		size++;
		this.arr[this.size()] = d;
		System.out.println(this.arr[this.size()]);
		
		
	}

	// returns double on top of stack
	// throws EmptyStackException if called when no elements are in stack
	// will shrink as stack empties
	public double pop() throws EmptyStackException {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		
		
		double returnValue = this.arr[this.size()];
		System.out.println(returnValue);
		this.size--;
		if(this.size() == this.arr.length/4) {
			resize(this.arr.length / 2);
		}
		return returnValue;
		
	}

	// returns double preview of top item in stack
	// throws EmptyStackException if called when no elements are in stack
	public double peek() throws EmptyStackException {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		return this.arr[this.size()];
	}
	
	// Returns int of num items in stack
	public int size() {
		return this.size;
	}
	
	// Clears stack to empty
	public void clear() {
		doClear();
	}
	
	// private method to handle any new stack creation
	private void doClear() {
		// empty stack is considered to have size of -1
		this.size = -1;
		resize(DEFAULT_CAPACITY);
	}
	
	// used to change size of stack: shrink, expand, create
	// parameter: desired capacity of new stack
	private void resize(int newCapacity) {
		
		double [] old = this.arr;
		arr = new double[newCapacity];
		for( int i = 0; i <= this.size();  i++) {
			arr[i] = old[i];
		}
	}
	
	private static final int DEFAULT_CAPACITY = 10;
	private double [] arr;
	private int size;
	
	
	
}
