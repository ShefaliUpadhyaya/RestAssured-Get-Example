package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.fault.Fault;
import pojo.weather.Weather;

public class RestAssuredGETTest {
	
	Gson gson = new Gson();
	Weather weather;
	Fault fault;
	
	private Response fetchResponse(String name) {
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 RequestSpecification httpRequest = RestAssured.given();
		 return httpRequest.request(Method.GET, name);
	}
	
	  private int fetchStatusCode(Response response) {
		  String responseBody = response.getBody().asString();
		  System.out.println("Response Body is -->  " + responseBody);
		  return response.getStatusCode();
	  }
	
	  @Test(priority = 1)
	  public void verifyStatusCodeForACity() {
		  Response response = fetchResponse("/Chennai");
		  int statusCode = fetchStatusCode(response);
		  assertEquals(statusCode, 200, "Found correct status code");
	  }
	  
	  @Test(priority = 2)
	  public void verifyStatusCodeForInvalidCity() {
		  Response response = fetchResponse("/78789798798");
		  int statusCode = fetchStatusCode(response);
		  assertEquals(statusCode, 400, "Found correct status code");
	  }
	  
	  @Test(priority = 3) 
	  public void verifyFaultMessageForInvalidCity() {
		  Response response = fetchResponse("/djfbdfshbfh");
		  String bodyAsString = response.getBody().asString();
		  fault = gson.fromJson(bodyAsString, Fault.class);
		  assertEquals(fault.getFaultId(), "FAULT_INTERNAL");
		  assertEquals(fault.getFault(), "An internal error occured while servicing the request");
	  }
	  
	  @Test(priority = 4)
	  public void getWeatherStatusLine() {
		  Response response = fetchResponse("/Hyderabad");
	  	  String statusLine = response.getStatusLine();
	  	  assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status code returned");
	  }
	  
	  @Test(priority = 5)
	  public void getWeatherHeaders() {	
		  Response response = fetchResponse("/Mumbai");
	  	  String contentType = response.header("Content-Type");
	  	  String serverType =  response.header("Server");
	  	  String contentEncoding = response.header("Content-Encoding");
	  	  assertEquals(contentType, "application/json");
	  	  assertEquals(serverType, "nginx/1.12.2");
	  	  assertEquals(contentEncoding, "gzip");
	  }
	  
	  @Test(priority = 6)
	  public void verifyCityInWeatherMessageBodyUsingGson() {
		  Response response = fetchResponse("/Hyderabad");
	  	  String bodyAsString = response.getBody().asString();
	  	  System.out.println("Body: " + bodyAsString);
	  	  weather = gson.fromJson(bodyAsString, Weather.class);
	  	  System.out.println(weather);
	  	  assertEquals(weather.getCity(), "Hyderabad");
	  }
	  
	  @Test(priority = 7)
	  public void verifyCityInJsonResponseUsingJsonPath() {
		  Response response = fetchResponse("/Delhi");
	  	  JsonPath jsonPathEvaluator = response.jsonPath();
	  	  String city = jsonPathEvaluator.get("City");
	  	  assertEquals(city, "Delhi", "Correct city name received in the Response");
	  }
	  
	 /* @SuppressWarnings("unchecked")
	@Test(priority = 8)
	  public void verifySuccessfulRegistrationInCreatingACustomer() {		
	  	RestAssured.baseURI ="http://restapi.demoqa.com/customer";
	  	RequestSpecification request = RestAssured.given();
	  	JSONObject requestParams = new JSONObject();
	  	requestParams.put("FirstName", "ABC"); 
	  	requestParams.put("LastName", "DEF");
	  	requestParams.put("UserName", "abcdef");
	  	requestParams.put("Password", "abcdef");
	  	requestParams.put("Email",  "abcdef@gmail.com");
	  	request.body(requestParams.toJSONString());
	  	Response response = request.post("/register");
	  	int statusCode = response.getStatusCode();
	  	assertEquals(statusCode, 201);
	  }*/
}
