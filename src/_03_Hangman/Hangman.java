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
	JLabel liveDisplay = new JLabel("Lives: 10");
	int numWords; 
	Stack<String> words = new Stack<String>();
	String imPopped;
	ArrayList<Character> knownletters = new ArrayList<Character>();
	// static boolean cont = true;  idea
	int lives = 10;
	
	ArrayList<Integer> indexes;
	char typedLetter; 
	
	public static void main(String [] args) {
		Hangman a = new Hangman();
		
		
		
		JOptionPane c = new JOptionPane(); 
		String b = JOptionPane.showInputDialog("Insert the number of words you want to be tested on (1-100)");
		
		try {
			int d = Integer.parseInt(b);
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Game Over! Try to insert an *integer* next time.");
			System.exit(-1);
		} 
		int d = Integer.parseInt(b);
		
		a.numWords = d;
		
		
		
		a.run();
			
	}
	
	@Override
	public void keyTyped(KeyEvent e) {					
		typedLetter = e.getKeyChar();
		
		boolean wrong = true; 
		
		for(int i = 0; i < imPopped.length(); i++) {
			if(typedLetter == imPopped.charAt(i)) {
				wrong = false; 
			}
		}
		
		if(wrong && lives == 1) {
			liveDisplay.setText("GAME OVER");
			JOptionPane.showMessageDialog(null, "Game Over! Thanks for playing!");
			
			System.exit(-1);
		}
		else if(wrong){
			lives--;
			liveDisplay.setText("Lives: " + lives); 
		}
		else {
			
			
			
			knownletters.add(typedLetter);
			
			StringBuilder bob = new StringBuilder();
			
			for(int c = 0; c < imPopped.length(); c++) {
				bob.append("_");
			}
			
			for(int j = 0; j < imPopped.length(); j++) {
				for(int b = 0; b < knownletters.size(); b++) {
					if(imPopped.charAt(j) == knownletters.get(b)) {
						bob.replace(j,j+1,knownletters.get(b)+"");
					}

				}
				
				
			}
			
			
			
			
			String newdisplay = bob.toString();
			
			underscores.setText(newdisplay);
			
			if(bob.toString().equals(imPopped)) {
				getNewWord();
			}
			
			f.pack();
		}
	} 
	
	private void run() {
		
		
		
		f.setVisible(true);
		f.add(panel);
		f.addKeyListener(this);
		

		
		
		
		if(numWords < 1 || numWords > 100) {
			JOptionPane.showMessageDialog(null, "Game Over! Try to insert a valid integer next time.");	
			System.exit(-1);
			}
		
		
		
		
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
		
		
		
		panel.add(underscores);
	
		panel.add(liveDisplay);
		
		getNewWord();
		
			
		}
		
		
		void getNewWord() {
			
			if(words.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Good job, you won! ");
				System.exit(-1);
			}
			imPopped = words.pop();
			System.out.println(imPopped); // cheat-cheat
			String tmp = "";
			for(int k = 0; k < imPopped.length(); k++) {
				tmp += '_';
				
			}
			knownletters.clear();
			
			underscores.setText(tmp);

			
			f.pack();
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

