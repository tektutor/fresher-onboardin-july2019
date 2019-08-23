package org.tektutor;

import static org.junit.Assert.assertEquals;

import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	private RestTemplate restTemplate;
	private String restEndPointURL;
	private String actualResponse;

	@Given("the REST API is deployed at {string}")
	public void setRESTEndpointURL(String endpointURL) {
		restTemplate = new RestTemplate();
		restEndPointURL = endpointURL;
	}

	@When("I invoke the REST API")
	public void i_invoke_the_REST_API() {
		actualResponse 
		   = restTemplate.getForObject("http://localhost:8080/hello", String.class );
	}

	@Then("I expect the response as {string}")
	public void i_expect_the_response_as(String expectedResponse) {
		assertEquals ( expectedResponse, actualResponse );
	}

}
