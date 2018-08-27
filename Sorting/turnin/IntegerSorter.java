package sorting;

import java.util.Comparator;

/**
 * Class full of static sorting methods. Used to sort Integers.
 * 
 * TODO: Implement mergeSort() and selectionSort().
 * 
 * insertionSort is implemented for you as an example.
 * 
 * @author pattersp
 *
 */

public class IntegerSorter {
    /**
     * Sorts the given array of integers in ascending order according to the
     * comparator using mergesort. You may create as many private helper
     * functions as you wish to implement this method.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the integers to sort
     * @param comparator
     *            The comparator the will be used to compare two integers.
     */
    public static void mergeSort(Integer[] array, Comparator<Integer> comparator) {
    	
    	Integer[] tmpArray = new Integer[ array.length ];
    	
    	mergeSort( array, tmpArray, 0, array.length - 1, comparator );
        
        //throw new UnsupportedOperationException();
    }
    
    private static void mergeSort( Integer[] array, Integer[] tmpArray, int left, 
    								int right, Comparator<Integer> comparator ) {
    	if( left < right ) {
    		int center = ( left + right ) / 2;
    		mergeSort( array, tmpArray, left, center, comparator);
    		mergeSort( array, tmpArray, center + 1, right, comparator);
    		merge(array, tmpArray, left, center + 1, right, comparator);
    	}
    	
    }
    
    private static void merge( Integer[] array, Integer[] tmpArray, int leftPos,
    							int rightPos, int rightEnd, Comparator<Integer> comparator ) {
    	int leftEnd = rightPos -1;
    	int tmpPos = leftPos;
    	int numElements = rightEnd - leftPos + 1;
    	
    	while( leftPos <=  leftEnd && rightPos <= rightEnd) {
    		
    		if( comparator.compare(array[ leftPos ], array[ rightPos ] ) <= 0 ) {
    			tmpArray[ tmpPos++ ] = array[ leftPos++ ];
    		} else {
    			tmpArray[tmpPos++ ] = array[ rightPos ++];
    		}
    	}
    	
    	while( leftPos <= leftEnd ) {
    		tmpArray[ tmpPos++ ] = array[ leftPos++ ];
    	}
    	
    	while( rightPos <= rightEnd ) {
    		tmpArray[ tmpPos++ ] = array[ rightPos++ ];
    	}
    	
    	for( int i = 0; i < numElements; i++, rightEnd--) {
    		array[ rightEnd ] = tmpArray[ rightEnd ];
    	}
    	
    }

    /**
     * Sort the array of integers in ascending order according to the comparator
     * using selection sort.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the array of integer that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two integers.
     */
    public static void selectionSort(Integer[] array,
            Comparator<Integer> comparator) {
    	
    	for( int i = 0; i < array.length; i++) {
    		int nextMin = nextMin( i, array, comparator);
    		swap( nextMin, i, array);
    	}
        // TODO: Add your selection sort algorithm here.
        //throw new UnsupportedOperationException();
    }
    
    
    private static int nextMin( int curr, Integer[] array, Comparator<Integer> comparator) {
    	int min = curr;
    	for( int i = curr; i < array.length; i++ ) {
    		if( comparator.compare( array[ i ], array[ min ] ) < 0 ) {
    			min = i;
    		}
    	}
    	return min;
    }
    
    private static void swap(int nextMin, int curr, Integer[] array) {
    	Integer tmp = array[ curr ];
    	
    	array[curr] = array[ nextMin ];
    	array[ nextMin ] = tmp;
    	
    }

    /**
     * Sort the array of integers in ascending order according to the comparator
     * using insertion sort.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the array of integers that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two integer.
     */
    public static void insertionSort(Integer[] array,
            Comparator<Integer> comparator) {
        for (int outerIndex = 1; outerIndex < array.length; outerIndex++) {
            Integer currentInt = array[outerIndex];
            int innerIndex = outerIndex - 1;
            while (innerIndex >= 0
                    && comparator.compare(currentInt, array[innerIndex]) < 0) {
                array[innerIndex + 1] = array[innerIndex];
                innerIndex--;
            }
            array[innerIndex + 1] = currentInt;
        }
    }
}
