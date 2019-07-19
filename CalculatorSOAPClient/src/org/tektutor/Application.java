package org.tektutor;

import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

public class Application {

	public static void main(String[] args) {

		System.setProperty( "java.net.useSystemProxies", "true" );
		
		Calculator calculator = new Calculator();
		
		CalculatorSoap calculatorSoap = calculator.getCalculatorSoap();
		int result = calculatorSoap.add(100, 200);
		
		System.out.println( "The sum is " + result );
	}

}
