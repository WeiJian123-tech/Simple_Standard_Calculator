package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
	@author Wei Jian Zhen

	Credit to YouTube Channel "choobtorials" for JFrame tutorial.
	Credit to YouTube Channel "Bro Code" for JPanel tutorial.
	Credit to YouTube Channel "Akinola John" for decimal button tutorial.
	
	YouTube Channel "choobtorials" Videos: 
	https://youtu.be/JPTZATLXwbc
	https://youtu.be/cyZzPo0ssp8
	
	YouTube Channel "Bro Code" Video:
	https://youtu.be/dvzAuq-YDpM
	
	YouTube Channel "Akinola John" Video:
	https://youtu.be/kn43EAsHxk0
	
	Credit to Java Code Geeks for reference for immutable jtextfield.
	https://examples.javacodegeeks.com/desktop-java/swing/jtextfield/create-read-only-non-editable-jtextfield/
	
	All emojis designed by OpenMoji – the open-source emoji and icon project. License: CC BY-SA 4.0
**/

public class CalcFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel screenPanel;
	private JPanel numberPanel;
	private JPanel operatorPanel;
	private JPanel specOperatorPanel;
	protected JTextField resultScreen;
	private JButton numBtns;
	private JButton swapSignsBtn;
	private JButton zeroBtn;
	private JButton decimalBtn;
	private JButton sqrBtn;
	private JButton sqrtBtn;
	private JButton modBtn;
	private JButton clearBtn;
	private JButton deleteBtn;
	private JButton addBtn;
	private JButton subtractBtn;
	private JButton multiplyBtn;
	private JButton divideBtn;
	private JButton equalsBtn;
	private Font numberFont;
	private Font operatorFont;
	private Font screenFont;
	
	//Panels are like divs. Containers.
	
	//Constructor to initialize my components to a new component.
	public CalcFrame() {
		screenPanel = new JPanel();
		numberPanel = new JPanel();
		operatorPanel = new JPanel();
		specOperatorPanel = new JPanel();
		resultScreen = new JTextField();
		numBtns = new JButton();
		swapSignsBtn = new JButton();
		zeroBtn = new JButton();
		decimalBtn = new JButton();
		sqrBtn = new JButton();
		sqrtBtn = new JButton();
		modBtn = new JButton();
		clearBtn = new JButton();
		deleteBtn = new JButton();
		addBtn = new JButton();
		subtractBtn = new JButton();
		multiplyBtn = new JButton();
		divideBtn = new JButton();
		equalsBtn = new JButton();
		numberFont = new Font("Serif", Font.PLAIN, 25);
		operatorFont = new Font("Arial", Font.BOLD, 12);
		screenFont = new Font("Helvetica", Font.PLAIN, 22);
	}
	
	//Method that is called to Main class and method.
	//Displays the calculator with its buttons, screen, functionality, and shape when run.
	public void defineGUI() {
		setTitle("Simple Standard Calculator");
		ImageIcon img = new ImageIcon("/Users/ZhenF/eclipse-workspace/Personal/src/Calculator/Abacus_Emoji.png");
		setIconImage(img.getImage());
		setMinimumSize(new Dimension(330, 450));
		setPreferredSize(new Dimension(365, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLUE);
		
		//SetLayout(new GridLayout()) sets components to a grid layout.
		//setLayout(new GridLayout());
		
		//SetLayout(null) sets components absolutely to a specific position.
		setLayout(null);
		
		//Methods that produce the screen, buttons, functionality, and shape of the calculator.
		defScrPanel();
		defSpecOpsPanel();
		defNumPanel();
		defOpsPanel();
		
		pack();
		setVisible(true);
	}
	
	//Sets the screen of the calculator so that users can view their inputs and solutions from button presses.
	private void defScrPanel() {
		//Sets the size, shape, and color of the container (JPanel) that holds the screen.
		screenPanel = new JPanel();
		screenPanel.setBackground(Color.DARK_GRAY);
		screenPanel.setBounds(0, 0, 350, 65);
		screenPanel.setLayout(new BorderLayout());
		screenPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//Sets the size, shape, and color of the screen.
		resultScreen = new JTextField();
		resultScreen.setBackground(Color.WHITE);
		resultScreen.setBounds(5, 5, 340, 55);
		resultScreen.setLayout(new BorderLayout());
		//resultScreen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//Could not find a built-in method for padding and margin. Pseudo-sets a margin/padding for the screen. 
		resultScreen.setBorder(
				BorderFactory.createCompoundBorder(
						resultScreen.getBorder(), BorderFactory.createEmptyBorder(5,5,5,5)
						)
				);
				
		//setEditable(false) does not allow users to type in the screen of the calculator with a keyboard.
		resultScreen.setEditable(false);
		
		//Adds the screen and container of the screen to the calculator (JFrame).
		add(resultScreen);
		add(screenPanel);
	}
	
	//Sets the main number pad buttons for the calculator.
	private void defNumPanel() {
		//Sets the size, shape, and color of the container (JPanel) for the number pad buttons.
		numberPanel = new JPanel();
		numberPanel.setBackground(new Color(174, 233, 255));
		numberPanel.setBounds(0, 140, 262, 325);
		numberPanel.setLayout(new GridLayout(4, 3));
		numberPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		//Adds the container for the number pad buttons to the calculator (JFrame).
		add(numberPanel);
		
		//Creates the buttons 1-9 for the calculator in descending order.
		for(int i = 9; i > 0; i--) {
			//numBtns = new JButton("" + i);
			numBtns = new JButton();
			numBtns.setText("" + i);
			
			String numBtnsTxt = numBtns.getText();
			
			//Sets the number text for the buttons.
			numBtns.setFont(numberFont);
			
			//Sets the buttons to be transparent in color.
			numBtns.setContentAreaFilled(false);
			
			//Enables button functionality so that the screen of the calculator
			//can display a number 1-9 when the number pad button(s) are pressed.
			numBtns.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							resultScreen.setText(resultScreen.getText() + numBtnsTxt);
							resultScreen.setFont(screenFont);
							resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
						}
					}
				);
			
			//Adds number pad buttons to the calculator (JFrame).
			numberPanel.add(numBtns);
		}
		
		//Creates a button that displays the number 0 when pressed.
		zeroBtn = new JButton("0");
		zeroBtn.setFont(numberFont);
		zeroBtn.setContentAreaFilled(false);
		
		String zeroBtnTxt = zeroBtn.getText();
		
		//Enables the functionality of the zero button
		//Appends 0 to the calculator screen.
		zeroBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						resultScreen.setText(resultScreen.getText() + zeroBtnTxt);
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
					}
				}
			);
		
		//Adds zero button to the calculator (JFrame).
		numberPanel.add(zeroBtn);
		
		//Creates a button that displays a decimal when pressed.
		decimalBtn = new JButton(".");
		decimalBtn.setFont(numberFont);
		decimalBtn.setContentAreaFilled(false);
		
		String decimalBtnTxt = decimalBtn.getText();
		
		//Enables functionality for the decimal button
		//Appends a decimal to the calculator screen
		decimalBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Displays and appends a decimal to the the calculator screen.
						resultScreen.setText(resultScreen.getText() + decimalBtnTxt);
						
						//Bottom two lines of code are used for all buttons.
						//Makes the calculator screen display a certain font
						//and sets the horizontal text alignment to be at the right.
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
						
					}
				}
			);
		
		//Adds the decimal button to the calculator (JFrame).
		numberPanel.add(decimalBtn);
		
		//A button that swaps the sign of the number in the calculator screen.
		//The number becomes negative when pressed for the first time and 
		//The number becomes positive when pressed for the second time.
		swapSignsBtn = new JButton("+/-");
		swapSignsBtn.setFont(numberFont);
		swapSignsBtn.setContentAreaFilled(false);
		
		//Enables button functionality to swapSignsBtn that makes a negative sign
		//appear or disappear in front of a number on the calculator screen when pressed.
		swapSignsBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						boolean isNegative = resultScreen.getText().contains("-");
						
						if(!isNegative) {
							resultScreen.setText("-" + resultScreen.getText());
						} else {
							resultScreen.setText(resultScreen.getText().replace("-", ""));
						}
						
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
						
					}
				}
			);
		
		//Adds the swapeSignsBtn button to the calculator (JFrame).
		numberPanel.add(swapSignsBtn);
	}
	
	//A method that sets the operator buttons that allow a calculator to compute equations.
	private void defOpsPanel() {
		//Sets a container to hold the operator buttons (JPanel) for the calculator.
		operatorPanel = new JPanel();
		operatorPanel.setBackground(new Color(131, 205, 255));
		operatorPanel.setBounds(262, 140, 87, 325);
		operatorPanel.setLayout(new GridLayout(6, 1));
		operatorPanel.setBorder(BorderFactory.createEmptyBorder());
		
		//Adds the operator buttons container to the calculator (JFrame).
		add(operatorPanel);
		
		//A delete button to delete a single character from the calculator screen when pressed.
		deleteBtn = new JButton("DELETE");
		deleteBtn.setFont(operatorFont);
		deleteBtn.setContentAreaFilled(false);
		
		//Enables functionality to the delete button to be able to delete text from the calculator screen.
		deleteBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) throws StringIndexOutOfBoundsException {
						
						//Throws an exception and outputs an error message
						//when there are no characters to delete from the calculator screen.
						//Else, deletes a character, at the end of the String, from the calculator screen.
						if(resultScreen.getText().length() <= 0) {
							resultScreen.setText("No Input To Delete");
							
							resultScreen.setFont(screenFont);
							resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
							
							throw new StringIndexOutOfBoundsException("No characters to delete from resultScreen.");
						} else {
							resultScreen.setText(
									"" + resultScreen.getText().substring(0, resultScreen.getText().length()-1)
									);
						}
						
						//If the is a negative sign present and calculator screen length has two characters
						//including the negative sign, delete both the negative sign and the character next to it.
						//Condition for when a number like -1 exists.
						if(resultScreen.getText().contains("-") && resultScreen.getText().length() == 1) {
							resultScreen.setText("");
						}
						
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
					}
				}
			);
		
		//Adds the delete button to the calculator (JFrame).
		operatorPanel.add(deleteBtn);
		
		//Creates the add button for the calculator to add numbers together.
		addBtn = new JButton("+");
		addBtn.setFont(operatorFont);
		addBtn.setContentAreaFilled(false);
		
		//Enables functionality for add button.
		addBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Makes sure that only one plus (+) symbol that is appended to the calculator screen.
						
						boolean isNums = resultScreen.getText().contains(resultScreen.getText());
						boolean isPlus = resultScreen.getText().contains("+");
						boolean isMinus = resultScreen.getText().contains("−");
						boolean isMultiply = resultScreen.getText().contains("*");
						boolean isDivide = resultScreen.getText().contains("/");
						boolean isModule = resultScreen.getText().contains("%");
						
						if(
								isNums &&
								!isPlus && !isMinus && !isMultiply && !isDivide && !isModule &&
								!resultScreen.getText().isEmpty()
								) {
							resultScreen.setText(resultScreen.getText() + " + ");
						} else {
							resultScreen.setText(resultScreen.getText());
						}
						
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
						
						//Creates a new CalcEquations instance that gets the calculator screen text.
						new CalcEquations(resultScreen.getText());
					}
				}
			);
		
		
		//Adds the add button to the calculator (JFrame).
		operatorPanel.add(addBtn);
		
		//Creates the subtract button for the calculator to be able to subtract numbers.
		subtractBtn = new JButton("−");
		subtractBtn.setFont(operatorFont);
		subtractBtn.setContentAreaFilled(false);
		
		//Enables functionality to the subtract button.
		subtractBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Makes sure that there is only one minus (−) symbol that is appended to the calculator screen.
						
						boolean isNums = resultScreen.getText().contains(resultScreen.getText());
						boolean isPlus = resultScreen.getText().contains("+");
						boolean isMinus = resultScreen.getText().contains("−");
						boolean isMultiply = resultScreen.getText().contains("*");
						boolean isDivide = resultScreen.getText().contains("/");
						boolean isModule = resultScreen.getText().contains("%");
						
						if(
								isNums &&
								!isPlus && !isMinus && !isMultiply && !isDivide && !isModule &&
								!resultScreen.getText().isEmpty()
								) {
							resultScreen.setText(resultScreen.getText() + " − ");
						} else {
							resultScreen.setText(resultScreen.getText());
						}
						
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
						
						//Creates a new CalcEquations instance that gets the calculator screen text.
						new CalcEquations(resultScreen.getText());
					}
				}
			);
		
		//Adds the subtract button to the calculator (JFrame).
		operatorPanel.add(subtractBtn);
		
		//Creates the multiply button for the calculator to be able to multiply numbers together.
		multiplyBtn = new JButton("*");
		multiplyBtn.setFont(operatorFont);
		multiplyBtn.setContentAreaFilled(false);
		
		//Enables functionality to the multiply button.
		multiplyBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Makes sure that there is only one multiply (*) symbol
						//that is appended to the calculator screen.
						
						boolean isNums = resultScreen.getText().contains(resultScreen.getText());
						boolean isPlus = resultScreen.getText().contains("+");
						boolean isMinus = resultScreen.getText().contains("−");
						boolean isMultiply = resultScreen.getText().contains("*");
						boolean isDivide = resultScreen.getText().contains("/");
						boolean isModule = resultScreen.getText().contains("%");
						
						if(
								isNums &&
								!isPlus && !isMinus && !isMultiply && !isDivide && !isModule &&
								!resultScreen.getText().isEmpty()
								) {
							resultScreen.setText(resultScreen.getText() + " * ");
						} else {
							resultScreen.setText(resultScreen.getText());
						}
						
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
						
						//Creates a new CalcEquations instance that gets the calculator screen text.
						new CalcEquations(resultScreen.getText());
					}
				}
			);
		
		//Adds the multiply button to the calculator (JFrame).
		operatorPanel.add(multiplyBtn);
		
		//Creates the divide button for the calculator so that numbers can be divided.
		divideBtn = new JButton("/");
		divideBtn.setFont(operatorFont);
		divideBtn.setContentAreaFilled(false);
		
		//Enables functionality for the divide button.
		divideBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Makes sure that there is only one divide (/) symbol appended to the calculator screen.
						
						boolean isNums = resultScreen.getText().contains(resultScreen.getText());
						boolean isPlus = resultScreen.getText().contains("+");
						boolean isMinus = resultScreen.getText().contains("−");
						boolean isMultiply = resultScreen.getText().contains("*");
						boolean isDivide = resultScreen.getText().contains("/");
						boolean isModule = resultScreen.getText().contains("%");
						
						if(
								isNums &&
								!isPlus && !isMinus && !isMultiply && !isDivide && !isModule &&
								!resultScreen.getText().isEmpty()
								) {
							resultScreen.setText(resultScreen.getText() + " / ");
						} else {
							resultScreen.setText(resultScreen.getText());
						}
						
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
						
						//Creates a new CalcEquations instance that gets the calculator screen text.
						new CalcEquations(resultScreen.getText());
					}
				}
			);
		
		//Adds the divide button to the calculator (JFrame).
		operatorPanel.add(divideBtn);
		
		//Creates the equals button so that the solution can be calculated and displayed on the 
		//calculator screen.
		equalsBtn = new JButton("=");
		equalsBtn.setFont(operatorFont);
		equalsBtn.setContentAreaFilled(false);
		
		//Enables button functionality for the equals button.
		equalsBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Creates a new instance of CalcEquatinos that gets the calculator screen text.
						CalcEquations equations = new CalcEquations(resultScreen.getText());
						
						//Sets the solution of the equation to the calculator screen once equals button is pressed.
						resultScreen.setText(equations.equals());
						
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
					}
				}
			);
		
		//Adds the equals button to the calculator (JFrame).
		operatorPanel.add(equalsBtn);
		
	}
	
	//Method that sets special operator buttons for special calculations within the calculator.
	private void defSpecOpsPanel() {
		//Sets a container that holds the special operator buttons
		//with a specified color, size, and shape.
		specOperatorPanel = new JPanel();
		specOperatorPanel.setBackground(new Color(131, 205, 255));
		specOperatorPanel.setBounds(0, 65, 350, 75);
		specOperatorPanel.setLayout(new GridLayout(1, 4));
		specOperatorPanel.setBorder(BorderFactory.createEmptyBorder());
		
		//Adds the container for the special operator buttons to the calculator (JFrame).
		add(specOperatorPanel);
		
		//Creates a squaring button that multiplies a number by itself and displays that result.
		sqrBtn = new JButton("Sqr (x^2)");
		sqrBtn.setFont(operatorFont);
		sqrBtn.setContentAreaFilled(false);
		
		//Enables button functionality to the square button.
		sqrBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Makes sure that no regular operator signs are present.
						//Does not square a number when an operator sign/symbol is present.
						
						boolean isNums = resultScreen.getText().contains(resultScreen.getText());
						boolean isPlus = resultScreen.getText().contains("+");
						boolean isMinus = resultScreen.getText().contains("−");
						boolean isMultiply = resultScreen.getText().contains("*");
						boolean isDivide = resultScreen.getText().contains("/");
						boolean isModule = resultScreen.getText().contains("%");
						
						//Instantiates a new CalcEquations object that gets the calculator screen text.
						CalcEquations equations = new CalcEquations(resultScreen.getText());
						
						if(
								isNums &&
								!isPlus && !isMinus && !isMultiply && !isDivide && !isModule
								) {
							//Number is square if there is a number present and no regular operators exist.
							resultScreen.setText(equations.squared());
						} else {
							//Else number is not squared.
							resultScreen.setText(resultScreen.getText());
						}
						
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
					}
				}
			);
		
		//Adds a squaring button to the calculator (JFrame).
		specOperatorPanel.add(sqrBtn);
		
		//Creates a square root button that calculates the square root of a number.
		sqrtBtn = new JButton("Sqrt (√x)");
		sqrtBtn.setFont(operatorFont);
		sqrtBtn.setContentAreaFilled(false);
		
		//Enables button functionality to the square root button.
		sqrtBtn.addActionListener(
				new ActionListener() { //JTextField can produce sqrt sign, Eclipse console cannot.
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Makes sure that no regular operators are present on the calculator screen.
						
						boolean isNums = resultScreen.getText().contains(resultScreen.getText());
						boolean isPlus = resultScreen.getText().contains("+");
						boolean isMinus = resultScreen.getText().contains("−");
						boolean isMultiply = resultScreen.getText().contains("*");
						boolean isDivide = resultScreen.getText().contains("/");
						boolean isModule = resultScreen.getText().contains("%");
						
						//Instantiates a new CalcEquations object that gets the calculator screen text.
						CalcEquations equations = new CalcEquations(resultScreen.getText());
						
						if(
								isNums &&
								!isPlus && !isMinus && !isMultiply && !isDivide && !isModule
								) {
							//The square root of the number is performed if there exist a number and not an operator.
							resultScreen.setText(equations.squareRoot());
						} else {
							//Else, the sqaure root of the number is not calculated.
							resultScreen.setText(resultScreen.getText());
						}
						
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
					}
				}
			);
		
		//Adds a square root button to the calculator (JFrame).
		specOperatorPanel.add(sqrtBtn);
		
		//Creates a module button that finds the remainder of two numbers that were divided with one another.
		modBtn = new JButton("Mod (%)");
		modBtn.setFont(operatorFont);
		modBtn.setContentAreaFilled(false);
		
		//Enables button functionality to the module button.
		modBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Makes sure that there is only the module (%) symbol present in the calculator screen.
						
						boolean isNums = resultScreen.getText().contains(resultScreen.getText());
						boolean isPlus = resultScreen.getText().contains("+");
						boolean isMinus = resultScreen.getText().contains("−");
						boolean isMultiply = resultScreen.getText().contains("*");
						boolean isDivide = resultScreen.getText().contains("/");
						boolean isModule = resultScreen.getText().contains("%");
						
						if(
								isNums &&
								!isPlus && !isMinus && !isMultiply && !isDivide && !isModule &&
								!resultScreen.getText().isEmpty()
								) {
							//Appends the module symbol if only the module symbol is present
							//and there exists a number on the calculator screen.
							resultScreen.setText(resultScreen.getText() + " % ");
						} else {
							//Else, sets the calculator screen text to be the same before pressing the module button.
							resultScreen.setText(resultScreen.getText());
						}
						
						resultScreen.setFont(screenFont);
						resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
						
						//Creates a new CalcEquations instance that gets the calculator screen text.
						new CalcEquations(resultScreen.getText());
					}
				}
			);
		
		//Adds a module button to the calculator (JFrame).
		specOperatorPanel.add(modBtn);
		
		//Creates a clear button to clear all text and numbers from the calculator screen.
		clearBtn = new JButton("CLEAR");
		clearBtn.setFont(operatorFont);
		clearBtn.setContentAreaFilled(false);
		
		//Enables button functionality for the clear button.
		clearBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//Sets the calculator screen to an empty String.
						resultScreen.setText("");
					}
				}
			);
		
		//Adds the clear button to the calculator (JFrame).
		specOperatorPanel.add(clearBtn);
	}

}
