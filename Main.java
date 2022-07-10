package Calculator;

/**
 * 
 * @author Wei Jian Zhen
 *
 * Program intended for portfolio building and learning about front end Java development.
 * 
 * I made my first simple standard calculator in Java. 
 * The development took around two weeks to complete.
 * I learned about the swing, awt, and awt.event packages from Java.
 * I learned about JFrames, JPanels, JTextFields, JButtons, Fonts, and many
 * additional components in order to complete this calculator.
 * 
 * Initial Publishing Date/Date Published: 07/10/2022
 * 
 **/

public class Main {
	
	public static void main(String[] args) {
		
		//Instantiating a new CalcFrame object to call components from CalcFrame class.
		CalcFrame calcWindow = new CalcFrame();
		
		//Calls defineGUI() method to display the calculator when run.
		calcWindow.defineGUI();

	}

}
