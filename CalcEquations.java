package Calculator;

/**
 * 
 * @author Wei Jian Zhen
 * 
 * 
 * CalcEquations is the class that computes the calculations
 * for the calculator so that users can have a solution
 * when they press the equals, square root, or square button.
 */

public class CalcEquations extends CalcFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resultScreenTxt;
	
	//Constructor that gets the calculator screen text.
	CalcEquations(String resultScreenTxt) {
		this.resultScreenTxt = resultScreenTxt;
	}
	
	//Method that computes equations given by the user when pressed by the equals button.
	public String equals() throws NumberFormatException {
		
		Double solution = 0.0;
		String errorMessage = "";
		
		try {
			
			//If the calculator screen text is empty, return the calculator screen text.
			if(
					!resultScreenTxt.contains("+") && !resultScreenTxt.contains("-") &&
					!resultScreenTxt.contains("*") && !resultScreenTxt.contains("/") &&
					!resultScreenTxt.contains("%") && resultScreenTxt.isEmpty()
					) {
				return resultScreen.getText();
			}
			
			//Else, if there is an equation with an operator present,
			//determine the solution for the equation.
			
			if(resultScreenTxt.contains("+")) {
				solution = add(resultScreenTxt);
			}
			
			if(resultScreenTxt.contains("−")) {
				solution = subtract(resultScreenTxt);
			}
			
			if(resultScreenTxt.contains("*")) {
				solution = multiply(resultScreenTxt);
			}
			
			if(resultScreenTxt.contains("/")) {
				solution = divide(resultScreenTxt);
			}
			
			if(resultScreenTxt.contains("%")) {
				solution = module(resultScreenTxt);
			}
			
			//Return the String value of the solution that was originally a double value.
			return String.valueOf(solution);
			
		} catch(NumberFormatException f) {
			errorMessage = "Invalid Input";
			System.out.println(f.toString());
		} catch(Exception f) {
			errorMessage = "Undefined";
			System.out.println(f.toString());
		}
		
		//Returns an error message if the calculator could not compute the equation.
		return errorMessage;
	}
	
	//Method that calculates equations that contain an add (+) symbol.
	public double add(String resultScreenTxt) throws NumberFormatException, StringIndexOutOfBoundsException{
		
		double num1 = Double.parseDouble(
				resultScreenTxt.substring(0, resultScreenTxt.indexOf("+"))
				);
		double num2 = Double.parseDouble(
				resultScreenTxt.substring(resultScreenTxt.indexOf("+") + 1, resultScreenTxt.length())
				);
		
		return num1 + num2;
	}
	
	//Method that calculates equations that contain a minus (−) symbol.
	public double subtract(String resultScreenTxt) throws NumberFormatException, StringIndexOutOfBoundsException {
		
		double num1 = Double.parseDouble(
				resultScreenTxt.substring(0, resultScreenTxt.indexOf("−"))
				);
		double num2 = Double.parseDouble(
				resultScreenTxt.substring(resultScreenTxt.indexOf("−") + 1, resultScreenTxt.length())
				);
		
		return num1 - num2;
	}
	
	//Method that calculates equations that contain a multiply (*) symbol.
	public double multiply(String resultScreenTxt) throws NumberFormatException, StringIndexOutOfBoundsException {
		
		double num1 = Double.parseDouble(
				resultScreenTxt.substring(0, resultScreenTxt.indexOf("*"))
				);
		double num2 = Double.parseDouble(
				resultScreenTxt.substring(resultScreenTxt.indexOf("*") + 1, resultScreenTxt.length())
				);
		
		return num1 * num2;
	}
	
	//Method that calculates equations that contain a divide (/) symbol.
	public double divide(String resultScreenTxt) throws NumberFormatException, StringIndexOutOfBoundsException {
		
		double num1 = Double.parseDouble(
				resultScreenTxt.substring(0, resultScreenTxt.indexOf("/"))
				);
		double num2 = Double.parseDouble(
				resultScreenTxt.substring(resultScreenTxt.indexOf("/") + 1, resultScreenTxt.length())
				);
		
		return num1 / num2;
	}
	
	//Method that calculates equations the contain a module (%) symbol.
	public double module(String resultScreenTxt) throws NumberFormatException, StringIndexOutOfBoundsException {
		
		double num1 = Double.parseDouble(
				resultScreenTxt.substring(0, resultScreenTxt.indexOf("%"))
				);
		double num2 = Double.parseDouble(
				resultScreenTxt.substring(resultScreenTxt.indexOf("%") + 1, resultScreenTxt.length())
				);
		
		return num1 % num2;
	}
	
	//Method that computes the square of a number and returns the solution to the calculator screen.
	public String squared() throws NumberFormatException, StringIndexOutOfBoundsException {
		
		Double result = 0.0;
		
		if(
				(
						!resultScreenTxt.contains("+") || !resultScreenTxt.contains("−") || 
						!resultScreenTxt.contains("*") || !resultScreenTxt.contains("/")
				) &&
				(
						!resultScreenTxt.isEmpty()
				)
			) {
			result = Math.pow(Integer.valueOf(resultScreenTxt), 2);
		}
		
		if(resultScreenTxt.contains("+")) {
			result = Math.pow(add(resultScreenTxt), 2);
		}
		
		if(resultScreenTxt.contains("−")) {
			result = Math.pow(subtract(resultScreenTxt), 2);
		}
		
		if(resultScreenTxt.contains("*")) {
			result = Math.pow(multiply(resultScreenTxt), 2);
		}
		
		if(resultScreenTxt.contains("/")) {
			result = Math.pow(divide(resultScreenTxt), 2);
		}
		
		return String.valueOf(result);
	}
	
	//Method that computes the square root of a number and returns the solution to the calculator screen.
	public String squareRoot() throws NumberFormatException, StringIndexOutOfBoundsException {
		
		Double result = 0.0;
		
		if(
				(
						!resultScreenTxt.contains("+") || !resultScreenTxt.contains("−") || 
						!resultScreenTxt.contains("*") || !resultScreenTxt.contains("/")
				) &&
				(
						!resultScreenTxt.isEmpty()
				)
			) {
			result = Math.sqrt(Integer.valueOf(resultScreenTxt));
		}
		
		if(resultScreenTxt.contains("+")) {
			result = Math.sqrt(add(resultScreenTxt));
		}
		
		if(resultScreenTxt.contains("−")) {
			result = Math.sqrt(subtract(resultScreenTxt));
		}
		
		if(resultScreenTxt.contains("*")) {
			result = Math.sqrt(multiply(resultScreenTxt));
		}
		
		if(resultScreenTxt.contains("/")) {
			result = Math.sqrt(divide(resultScreenTxt));
		}
		
		return String.valueOf(result);
	}

}
