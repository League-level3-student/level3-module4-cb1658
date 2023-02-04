package _02_IntroToQueues;
/* 
 * OBJECTIVE:
 * 1. Push 100 double values onto a Stack.
 * 2. Pop off as many values from the Stack to fill a Queue with 5 values.
 * 3. Randomly remove between 1 and 5 values from the Queue and print them to
 *    the console.
 * 4. Repeat steps 2 and 3 until there are no values left in either the Stack
 *    or Queue.
 * 
 * Example:
 * stack: { ..., 60, 36, 88, 4, 65, 75, 10 }
 * queue: { } // empty
 * 
 * Pop off 5 elements from stack to fill queue with 5 elements
 * stack: { ..., 60, 36 }
 * queue: { 10, 75, 65, 4, 88 }
 * 
 * Remove a random number of values from the front of the queue
 * (2 in this example) and print the number of values being removed
 * and the values themselves
 * stack: { ..., 60, 36 }
 * queue: { 65, 4, 88 }
 * "Removing 2 elements: 10 75"
 * 
 * Pop off 2 elements from the stack to fill the queue to 5
 * stack: { ... }
 * queue: { 65, 4, 88, 36, 60 }
 * 
 * Repeat until there are no more elements in the stack and queue
 */

import java.util.ArrayDeque;
import java.util.Random;
import java.util.Stack;

public class _01_IntroToQueue {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles using the Stack class
        //    Note: you have to use the capitalized Double and not double
    	
    	Stack<Double> popper = new Stack<Double>(); 

        // 2. Use a loop to add 100 random doubles between 0 and 100 to the Stack

    	for(int i = 0; i< 100; i++) {
    		Random rand = new Random(); 
    		int a = rand.nextInt(10000);
    		double pushme = a/100;
    		
    		popper.push(pushme);
    	}
    	
    	
        // 3. Create a Queue of Doubles using the ArrayDeque class
        //    Note: you have to use the capitalized Double and not double

    	ArrayDeque<Double> remover = new ArrayDeque<Double>(); 
    	    	
        // 4. Pop off 5 elements from the Stack and add them to the Queue 

    	for(int i =0; i < 5; i++) {
    		double addme = popper.pop();
    		remover.add(addme);
    	}
    	
        // 5. Print and remove a random number of elements, from 1 to 5 elements,
        //    from the front of the Queue. Example:
        //    "removing 3 elements from Queue: 25 57 2"

    	Random luck = new Random();
    	int b = luck.nextInt(5);
    	StringBuilder bob = new StringBuilder("Removing " + b + " elements from Queue: ");
    	double[] remember = new double[b];
    	for(int i =0; i < b; i++) {
    		double a = remover.remove();
    		remember[i] = a;
    	}
    	for(double d : remember) {
    		bob.append(d);
    		bob.append(' ');
    	}
    	
    	System.out.println(bob.toString());
    	
        // 6. Pop off as many elements from the stack to fill the Queue with 5
        //    elements. If there aren't enough elements in the Stack to fill the 
        //    queue, fill the queue as much as possible. 

    	for(int i =0; i < 5; i++) {
    		if(popper.isEmpty()) {
    			break;
    		}
    		double addme = popper.pop();
    		remover.add(addme);
    	}
    	
    	
        // 7. Loop until there are no more elements in either the Stack or Queue
        //    and all the elements are printed
        
    	while(!popper.isEmpty()) {
    		System.out.println(popper.pop());
    	}
    	
    	while(!remover.isEmpty()) {
    		System.out.println(remover.remove());
    	}
    	
    	
    }
}
