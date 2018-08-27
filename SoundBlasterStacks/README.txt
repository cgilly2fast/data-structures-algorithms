1. How did you test that your stack implementations were correct?
	for each implentation I tested every public method in the 3 cases 
		empty stack
		stack with 1 element
		stack with a resized amout of elements
2. How many times would this resizing occur for 1 mill, 1 bill, and 1 trill?
	well i would say this is a logrithmic computation: 

	log((input size)/(starting array size)) = (number of resizes) 

	rational:
		10 * 2^x = 1,000,000
		2^x = 100,000

	This is assuming that the stack is doubled in size for each "resize", rounding up for resizes, cs base 2 trope
		answers: log(1mill/10) = 17
				 log(1bill/10) = 27
				 log(1trill/10) = 37
3. queue pseudo code enqueue and dequeue
	
	create global feild queue1
	create global feild queue2

	push accepts varaible a
		queue1.enqueue(a);
		while(!queue2.isEmpty)
			queue1.enqueue(queue2.dequeue);

		declare variable queueSwap

		queueSwap = queue1;
		queue1 = queue2
		queue2 = queueSwap

	pop
		check if queue2.isEmpty()

		return queue.dequeue

4. In my queue implementation of a stack the pop is O(n) because it has to irrate 
through each element that has been passed to have the reverse position correct for a 
later pop, where my array implination is O(1) because the number of operations required
to push is the same. The pop for the queue is constant time because it is only a 
simple dequeue, all the work was done while pushing. The array implementation is also
constant time as per usaul for array[idx]. Array implentation, i choose you. because
it is srictly better because of the faster push time. I think something to weigh in
future descions is if i need a fast pop and dont care about a slow push or vice 
versa, in this case we get the best of both worlds with the array implementation,
but that may not always such an easy desicion in the future.

5. extra credit 
	"the scent of bitter almonds always reminded him of the fate of unrequited love" 
	Modify your array implementations so that when the array is 3/4 empty, the stack resizes to use an array of half the size.





