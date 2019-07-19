package org.tektutor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

class DummyCamera extends Camera {
	
	public boolean on() {
		return true;
	}
}


public class MobileTest {

	@Test
	public void testStartCameraAppWhenCameraFunctionsNormally() {
		
		//Mocking
		Camera mockedCamera = Mockito.mock( Camera.class );
		
		//Stubbing - hard coding the response of dependent method
		Mockito.when(mockedCamera.on()).thenReturn(true);
		
		//Camera mockedCamera = new DummyCamera();
		
		Mobile mobile = new Mobile(mockedCamera);
		
		boolean actualStatus = mobile.startCameraApp();
		boolean expectedStatus = true;
		
		assertEquals ( expectedStatus, actualStatus );
		
		Mockito.verify(mockedCamera, Mockito.times(1)).on();
		
	}
	
	@Test
	public void testStartCameraAppWhenCameraFunctionsAbnormally() {
		
		//Mocking
		Camera mockedCamera = Mockito.mock( Camera.class );
		
		//Stubbing - hard coding the response of dependent method
		Mockito.when(mockedCamera.on()).thenReturn(false);
		
		//Camera mockedCamera = new DummyCamera();
		
		Mobile mobile = new Mobile(mockedCamera);
		
		boolean actualStatus = mobile.startCameraApp();
		boolean expectedStatus = false;
		
		assertEquals ( expectedStatus, actualStatus );
		
	}	
	
}
