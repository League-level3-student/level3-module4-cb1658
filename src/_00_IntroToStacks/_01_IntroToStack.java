package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class

    	Stack<Double> popper = new Stack<Double>();
    	
    	
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.

    	for(int i = 0; i < 100; i++) {
    		popper.push(new Random().nextDouble()*100);
    	}
    	
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 

    	String popme = JOptionPane.showInputDialog("Enter two numbers between 0 and 100 inclusive with the first number being smaller than the second. (e.g. 76,100)");
    	String[] popme2 = popme.split(",");
    	
    	int[] popme3 = new int[2]; 
    	popme3[0] = Integer.valueOf(popme2[0]);
    	popme3[1] = Integer.valueOf(popme2[1]);
    	
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.

    	
    	System.out.println("NUM 1: " + popme3[0]);
    	System.out.println("NUM 2: " + popme3[1]);
    	
    	System.out.println("Elements on stack are being popped");
    	System.out.println("Element between " + popme3[0] + " and " + popme3[1] + ":");
    	for(int i = 0; i < 100; i++) {
    		Double popped = popper.pop();
    		
    		if(popped > popme3[0] && popped < popme3[1]) {
    			System.out.println(popped);
    		}
    	}
    	
        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}
