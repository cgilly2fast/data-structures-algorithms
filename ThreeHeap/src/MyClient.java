import java.util.*;
import java.util.Arrays.*;

public class MyClient {

	public static void main(String[] args) {
		emptyTest();
		oneTest();
		nTest();
	}
	
	public static void emptyTest() {
		ThreeHeap heap = new ThreeHeap();
		
		System.out.println("emptyTest:");
		System.out.println();
		 
		if( heap.isEmpty() ) {
			System.out.println("isEmpty: pass");
		} else {
			System.out.println("isEmpty: fail");
		}
		
		if( heap.size() == 0 ) {
			System.out.println("size: pass");
		} else {
			System.out.println("size: fail");
		}
		
		boolean findMin = false;
		
		System.out.print("findMin: ");
		try {
			heap.findMin();
		} catch(EmptyHeapException e) {
			System.out.println("pass");
			findMin = true;
		}
		
		if(!findMin) {
			System.out.println("fail");
		}
		
		boolean deleteMin = false;
		
		System.out.print("deleteMin: ");
		try {
			heap.deleteMin();
		} catch(EmptyHeapException e) {
			System.out.println("pass");
			deleteMin = true;
		}
		
		if(!deleteMin) {
			System.out.println("fail");
		}
		System.out.println();
	}
	
	public static void oneTest() {
		ThreeHeap heap = new ThreeHeap();
		
		boolean test1 = true;
		
		heap.insert(1.0);
		
		System.out.println("oneTest");
		System.out.println();
		
		if( heap.findMin() == 1.0 ) {
			System.out.println("findMin: pass");
		} else {
			System.out.println("findMin: fail");
			test1 = false;
		}
		
		if( !heap.isEmpty() ) {
			System.out.println("isEmpty: pass");
		} else {
			System.out.println("isEmpty: fail");
			test1 = false;
		}
		
		if( heap.size() == 1 ) {
			System.out.println("size: pass");
		} else {
			System.out.println("size: fail");
			test1 = false;
		}
		
		double test = heap.deleteMin();
		
		if( test == 1.0 ) {
			System.out.println("size: pass");
		} else {
			System.out.println("size: fail");
			test1 = false;
		}
		
		if(test1) {
			System.out.println("insert: pass");
		} else {
			System.out.println("insert: fail");
		}
		System.out.println();
	}
	
	public static void nTest() {
		
		System.out.println("nTest");
		System.out.println();
		
		ThreeHeap heap = new ThreeHeap();
		
		boolean test1 = true;
		boolean test2 = true;
		boolean test3 = true;
		boolean test4 = true;
		
		List<Double> list1 = new ArrayList<Double>();
		for(double i = 0.0; i <= 10.0; i++) {
			list1.add(i);
		}
		
		List<Double> list2 = new ArrayList<Double>();
		for(double i = 10.0; i >= 0.0 ; i--) {
			list2.add(i);
		}
		
		heap.buildQueue(list1);
		for(double i = 0.0; i <= 10.0; i++) {
			double value = heap.deleteMin();
			if( !(value == i) ) {
				test2 = false;
			}
		}
		
		if(test2) {
			System.out.println("single buildQueue: pass");
		} else {
			System.out.println("single buildQueue: fail");
		}
		
		heap.buildQueue(list1);
		heap.buildQueue(list2);
		for(double i = 0.0; i <= 10; i++) {
			double value = heap.deleteMin();
			if( !(value == i) ) {
				test3 = false;
			}
		}
		
		
		List<Double> list3 = new ArrayList<Double>();
		double [] rand = new double[51];
		for(int i = 0; i <= 50; i++) {
			double value = Math.floor(Math.random() * 101);
			rand[ i ] = value;
			list3.add( value );
		}
		
		Arrays.sort(rand);
		
		heap.buildQueue(list3);
		for(int i = 0; i <= 50; i++) {
			double value = heap.deleteMin();
			if( !(value == rand[ i ]) ) {
				test4 = false;
			}
		}
		
		if(test4) {
			System.out.println("rand buildQueue: pass");
		} else {
			System.out.println("rand buildQueue: fail");
		}
		
		if(test3) {
			System.out.println("double buildQueue: pass");
		} else {
			System.out.println("double buildQueue: fail");
		}
		
		heap.buildQueue(list2);
		
		if( heap.findMin() == 0.0 ) {
			System.out.println("findMin: pass");
		} else {
			System.out.println("findMin: fail");
			test1 = false;
		}
		
		if( !heap.isEmpty() ) {
			System.out.println("isEmpty: pass");
		} else {
			System.out.println("isEmpty: fail");
			test1 = false;
		}
		
		if( heap.size() == 11 ) {
			System.out.println("size: pass");
		} else {
			System.out.println("size: fail");
			test1 = false;
		}
		
		double test = heap.deleteMin();
		
		if( test == 0.0 ) {
			System.out.println("size: pass");
		} else {
			System.out.println("size: fail");
			test1 = false;
		}
		
		if(test1) {
			System.out.println("insert: pass");
		} else {
			System.out.println("insert: fail");
		}
	}	

}
