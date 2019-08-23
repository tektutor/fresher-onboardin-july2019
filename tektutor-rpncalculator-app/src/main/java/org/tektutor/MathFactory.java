package org.tektutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Properties;

public class MathFactory {

	private static HashMap<String,String> classNameMap;

	static {
		classNameMap = new HashMap<String,String>();

		try {
			FileInputStream file 
				= new FileInputStream("src/main/resources/config.properties");
			
			Properties properties = new Properties();
			properties.load( file );
			
			properties.forEach( (key,value) -> {
				classNameMap.put( (String)key, (String)value);
				System.out.println("key = " + key + " value = " + value);
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static IMathOperation getObject(String mathOperator) {
		IMathOperation mathOperation = null;
		
		String className = classNameMap.get(mathOperator);
		try {
			mathOperation 
				= (IMathOperation) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return mathOperation;
	}

}
