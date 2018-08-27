import java.util.EmptyStackException;

public class Test {

	public static void main(String[] args) {
		ArrayStack arrayS = new ArrayStack();
		ListStack listS = new ListStack();
		
			//testEmptyA();
			//testOneA();
			testNA();
		
	
			//testEmptyL();
			//testOneL();
			//testNL();
	
	}
	
	public static void testEmptyA() {
		ArrayStack s = new ArrayStack();
		
		System.out.print("isEmpty() Test:\t");
		if(s.isEmpty()) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
		System.out.print("clear() Test:\t");
		s.clear();
		if(s.size() == -1) {
			System.out.print("size:pass ");
		} else {
			System.out.println("size:fail");
			System.out.println("this.size should be assigned to -1 for an empty stack");
		}
		
		System.out.print(".peek() Test:\t");
		boolean peek = false;
		try {
			s.peek();
		} catch(EmptyStackException e) {
			System.out.println("pass");
			peek = true;
		}
		
		if(!peek) {
			System.out.println("fail");
			System.out.println(".peek() on an empty array should throw an EmptyStackException");
		}
		
		System.out.print(".pop() Test:\t");
		boolean pop = false;
		try {
			s.pop();
		} catch(EmptyStackException e) {
			System.out.println("pass");
			peek = true;
		}
		
		if(!peek) {
			System.out.println("fail");
			System.out.println(".pop() on an empty array should throw an EmptyStackException");
		}
	}
	
	public static void testOneA() {
		ArrayStack s = new ArrayStack();
		
		System.out.print("push() Test:\t");
		s.push(2.0);
		boolean peek = false;
		double q = s.peek();
		if( q == 2.0) {
			System.out.println("pass");
			System.out.print("peek() Test:\t");
			System.out.println("pass");
			peek = true;
		} else {
			System.out.print("fail");
			System.out.print("peek() did not find the correct element or no element");
		}
		
		System.out.print("clear() Test:\t");
		s.clear();
		if(s.size() == -1) {
			System.out.print("size:pass ");
		} else {
			System.out.println("size:fail");
			System.out.println("this.size should be assigned to -1 for an empty stack");
		}
		
		if(!peek){
			System.out.print(".peek() Test:\t");
			s.clear();
			s.push(3.0);
			double peeked = s.peek();
			double popped = s.pop();
			
			if(peeked != popped) {
				System.out.print("fail");
				System.out.print("popped item not equal to peeked item right before pop");
			} else {
				System.out.println("pass");
			}
		}
		
		System.out.print("isEmpty() Test:\t");
		s.push(4.0);
		s.clear();
		
		if(s.isEmpty()) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}
	
	public static void testNA() {
	ArrayStack s = new ArrayStack();
		
		System.out.print("push() Test:\t");
		for(int i = 0; i <= 20; i++) {
			s.push(i);
		}
		boolean tester = true;
		for(int i = 20; i >= 0; i--) {
			double value = s.pop();
			System.out.println(s.size());
			if(!(value == i)){
				tester = false;
			}
		} 
		
		if(tester) {
			System.out.print("pass");
			
		}
		boolean peek = false;
		s.push(2.0);
		if(s.peek() == 2.0) {
			System.out.println("pass");
			System.out.print("peek() Test:\t");
			System.out.println("pass");
			peek = true;
		} else {
			System.out.print("fail");
			System.out.print("peek() did not find the correct element or no element");
		}
		
		System.out.print("clear() Test:\t");
		s.clear();
		if(s.size() == -1) {
			System.out.print("size:pass ");
		} else {
			System.out.println("size:fail");
			System.out.println("this.size should be assigned to -1 for an empty stack");
		}
		
		if(!peek){
			System.out.print(".peek() Test:\t");
			s.clear();
			s.push(3.0);
			double peeked = s.peek();
			double popped = s.pop();
			
			if(peeked != popped) {
				System.out.print("fail");
				System.out.print("popped item not equal to peeked item right before pop");
			} else {
				System.out.println("pass");
				System.out.println(".pop() Test:\t");
				System.out.println("pass");
			}
		}
		
		System.out.print("isEmpty() Test:\t");
		s.push(4.0);
		s.clear();
		
		if(s.isEmpty()) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}
	
	public static void testEmptyL() {
		ListStack s = new ListStack();
		
		System.out.print("isEmpty() Test:\t");
		if(s.isEmpty()) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
		System.out.print("clear() Test:\t");
		s.clear();
		if(s.size() == -1) {
			System.out.print("size:pass ");
		} else {
			System.out.println("size:fail");
			System.out.println("this.size should be assigned to -1 for an empty stack");
		}
		
		System.out.print(".peek() Test:\t");
		boolean peek = false;
		try {
			s.peek();
		} catch(EmptyStackException e) {
			System.out.println("pass");
			peek = true;
		}
		
		if(!peek) {
			System.out.println("fail");
			System.out.println(".peek() on an empty array should throw an EmptyStackException");
		}
		
		System.out.print(".pop() Test:\t");
		boolean pop = false;
		try {
			s.pop();
		} catch(EmptyStackException e) {
			System.out.println("pass");
			peek = true;
		}
		
		if(!peek) {
			System.out.println("fail");
			System.out.println(".pop() on an empty array should throw an EmptyStackException");
		}
	}
	
	public static void testOneL() {
		ListStack s = new ListStack();
		
		System.out.print("push() Test:\t");
		s.push(2.0);
		boolean peek = false;
		if(s.peek() == 2.0) {
			System.out.println("pass");
			System.out.print("peek() Test:\t");
			System.out.println("pass");
			peek = true;
		} else {
			System.out.print("fail");
			System.out.print("peek() did not find the correct element or no element");
		}
		
		System.out.print("clear() Test:\t");
		s.clear();
		if(s.size() == -1) {
			System.out.print("size:pass ");
		} else {
			System.out.println("size:fail");
			System.out.println("this.size should be assigned to -1 for an empty stack");
		}
		
		if(!peek){
			System.out.print(".peek() Test:\t");
			s.clear();
			s.push(3.0);
			double peeked = s.peek();
			double popped = s.pop();
			
			if(peeked != popped) {
				System.out.print("fail");
				System.out.print("popped item not equal to peeked item right before pop");
			} else {
				System.out.println("pass");
			}
		}
		
		System.out.print("isEmpty() Test:\t");
		s.push(4.0);
		s.clear();
		
		if(s.isEmpty()) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}
	
	public static void testNL() {
	ListStack s = new ListStack();
		
		System.out.print("push() Test:\t");
		for(int i = 0; i <= 20; i++) {
			s.push(i);
		}
		boolean tester = true;
		for(int i = 20; i >= 0; i--) {
			double value = s.pop();
			if(!(value == i)){
				tester = false;
			}
		} 
		
		if(tester) {
			System.out.print("pass");
			
		}
		boolean peek = false;
		s.push(2.0);
		if(s.peek() == 2.0) {
			System.out.println("pass");
			System.out.print("peek() Test:\t");
			System.out.println("pass");
			peek = true;
		} else {
			System.out.print("fail");
			System.out.print("peek() did not find the correct element or no element");
		}
		
		System.out.print("clear() Test:\t");
		s.clear();
		if(s.size() == -1) {
			System.out.print("size:pass ");
		} else {
			System.out.println("size:fail");
			System.out.println("this.size should be assigned to -1 for an empty stack");
		}
		
		if(!peek){
			System.out.print(".peek() Test:\t");
			s.clear();
			s.push(3.0);
			double peeked = s.peek();
			double popped = s.pop();
			
			if(peeked != popped) {
				System.out.print("fail");
				System.out.print("popped item not equal to peeked item right before pop");
			} else {
				System.out.println("pass");
				System.out.println(".pop() Test:\t");
				System.out.println("pass");
			}
		}
		
		System.out.print("isEmpty() Test:\t");
		s.push(4.0);
		s.clear();
		
		if(s.isEmpty()) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}
}
