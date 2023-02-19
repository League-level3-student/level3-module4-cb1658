package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener{
	JFrame f = new JFrame();
	JPanel panel = new JPanel();
	JLabel underscores = new JLabel();
	int numWords; 
	String imPopped;
	// static boolean cont = true;  idea
	int lives;
	ArrayList<Integer> indexes;
	char save; 
	
	public static void main(String [] args) {
		Hangman a = new Hangman();
		
		
		
		JOptionPane c = new JOptionPane(); 
		String b = JOptionPane.showInputDialog("Insert the number of words you want to be tested on (1-100)");
		
		try {
			int d = Integer.parseInt(b);
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Game Over! Try to insert an *integer* next time.");
		} 
		int d = Integer.parseInt(b);
		
		a.numWords = d;
		
		
		
		a.run();
		
		//System.exit(-1);
			
	}
	
	@Override
	public void keyTyped(KeyEvent e) {					
		save = e.getKeyChar();
		
		boolean wrong = true; 
		
		for(int i = 0; i < imPopped.length(); i++) {
			if(save == imPopped.charAt(i)) {
				wrong = false; 
			}
		}
		
		if(wrong && lives == 1) {
			JOptionPane.showMessageDialog(null, "Game Over! Thanks for playing!");
		}
		else if(wrong){
			lives--;
		}
		else {
			
			StringBuilder bob = new StringBuilder();
			
			for(int j = 0; j < imPopped.length(); j++) {
				if(imPopped.charAt(j) == save) {
					bob.append(save);
				}
				else {
					bob.append("_");
				}
			}
			
			
			String newdisplay = bob.toString();
			
			underscores.setText(newdisplay);
			
			panel.add(underscores);
			
			f.pack();
			// RESET DISPLAY HERE
		}
	} 
	
	private void run() {
		
		
		
		f.setVisible(true);
		f.add(panel);
		f.addKeyListener(this);
		panel.add(underscores);
		
		f.addKeyListener(this);
		
		
		
		if(numWords < 1 || numWords > 100) {
			JOptionPane.showMessageDialog(null, "Game Over! Try to insert a valid integer next time.");		
			}
		
		
		Stack<String> words = new Stack<String>();
		
		for(int i = 0; i < numWords; i++) {
			String a = Utilities.readRandomLineFromFile("dictionary.txt");
			if(!words.contains(a)) {
				words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			}
			else {
				i--;
			}
		}
		
		
		int lives = 10; 
		
		for(int i = 0; i < numWords; i++) {
			imPopped = words.pop();
			System.out.println(imPopped); // what is this doing here lol
			String tmp = "";
			for(int k = 0; k < imPopped.length(); k++) {
				tmp += '_';
				
			}
			underscores.setText(tmp);
			
			
			panel.add(underscores);
		
			
			f.pack();
		}	
			
		}
		
		
		
		
	
	
					
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	
} 
	
		
	

	
	




// A.4.2
 

