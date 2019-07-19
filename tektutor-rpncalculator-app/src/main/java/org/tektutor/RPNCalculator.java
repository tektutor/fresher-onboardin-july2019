package org.tektutor;

import java.util.Stack;

public class RPNCalculator {
	
	private Stack<Double> numberStack;
	private double firstNumber, secondNumber, result;
	
	public RPNCalculator() {
		numberStack = new Stack<Double>();
		firstNumber = secondNumber = result = 0.0;
	}

	public double evaluate(String rpnMathExpression) {
		
		String[] rpnTokens = rpnMathExpression.split(" ");
		
		IMathOperation mathOperation = null;
		
		for ( String token : rpnTokens ) {
			
			if ( isMathOperator( token ) ) {
				extractInputs();
				mathOperation = MathFactory.getObject( token );
				result = mathOperation.evaluate ( firstNumber, secondNumber );
				numberStack.push( result );
			}
			else
				numberStack.push ( Double.parseDouble(token) );
			
		}
		
		return numberStack.pop();
	}

	private boolean isMathOperator(String token) {
		String mathOperations = "+-*/";
		return mathOperations.contains(token);
	}

	private void divide() {
		extractInputs();
		result = firstNumber / secondNumber;
		numberStack.push(result);
	}

	private void multiply() {
		extractInputs();
		result = firstNumber * secondNumber;
		numberStack.push(result);
	}

	private void subtract() {
		extractInputs();
		result = firstNumber - secondNumber;
		numberStack.push(result);
	}

	private void add() {
		extractInputs();
		result = firstNumber + secondNumber;
		numberStack.push(result);
	}

	private void extractInputs() {
		secondNumber = numberStack.pop();
		firstNumber = numberStack.pop();
	}

}
