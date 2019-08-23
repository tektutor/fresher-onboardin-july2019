Feature: Develop a RESTful Hello API.

	Scenario: Should be able to invoke REST API
		Given the REST API is deployed at "http://localhost:8080/hello"
		When I invoke the REST API
		Then I expect the response as "Hello REST API!"