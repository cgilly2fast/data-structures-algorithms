// Colby Gilbert
// 1362977
// CSE 373 winter 2017
// Kiley Porter

// DESCRIPTION: Array implementation of DStack includes extra public methods, .size(), .clear() 
import java.util.EmptyStackException;

public class ListStack implements DStack {

	public ListStack () {
		doClear();
	}
	
	// Returns boolean true if empty
	public boolean isEmpty() {
		return size() < 0;
	}

	// pushes one element to stack 
	public void push(double d) {
		
		Node<Double> newNode = new Node<Double>(d, this.beginMarker.next);
		beginMarker.next = newNode;
		this.size++;
	}

	// returns double on top of stack
	// throws EmptyStackException if called when no elements are in stack
	public double pop() throws EmptyStackException {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		
		double returnValue = beginMarker.next.data;
		System.out.println(returnValue);
		beginMarker.next = beginMarker.next.next;
		this.size--;
		return returnValue;
	}

	// returns double preview of top item in stack
	// throws EmptyStackException if called when no elements are in stack
	public double peek() {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		
		return beginMarker.next.data;
	}
	
	// Clears stack to empty
	public void clear() {
		doClear();
	}
	
	// private method to handle any new stack creation
	private void doClear() {
		// empty stack is considered to have size of -1
		size = -1;
		beginMarker = new Node<Double>(-1, null);
	}
	
	// Returns int of num items in stack
	public int size() {
		return this.size;
	}
	
	private int size;
	private Node<Double> beginMarker;
	
	// DESCRIPTION: node class for single linked list implementation of stack
	private static class Node<Double> {
		
		public Node(double d, Node<Double> n) {
			data = d;
			next = n;
		}
		
		private double data;
		private Node<Double> next;
		
	}
}
