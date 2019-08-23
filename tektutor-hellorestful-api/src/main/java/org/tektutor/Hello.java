package org.tektutor;

import org.springframework.stereotype.Service;

@Service
public class Hello {

	public Hello() {
		
	}
	
	public String sayHello() {
		return "Hello REST API 2.0!";
	}
	
}
