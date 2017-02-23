package json_rest_test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import participants.Application;
import participants.information.citizen.CitizenInformationRequest;
import participants.information.citizen.CitizenInformationResponse;


@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class CitizenInformationControllerTest {

	//Test RestTemplate to invoke the APIs.
	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testRESTSuccesful() throws JsonProcessingException{

		//Building the Request body data
		//Creating http entity object
		CitizenInformationRequest request = new CitizenInformationRequest("pperez@prueba.com", "1234");		
			

		//Invoking the API
		ResponseEntity<CitizenInformationResponse> restResponse = 
				restTemplate.postForEntity("http://localhost:8080/user", request, 
						CitizenInformationResponse.class);

		assertNotNull(restResponse);
	
		assertEquals(new Long(1), restResponse.getBody().getId());
		assertEquals("Pedro", restResponse.getBody().getFirstName());
		assertEquals("Pérez González", restResponse.getBody().getLastName());
		assertEquals(49, restResponse.getBody().getAge());
		assertEquals("pperez@prueba.com", restResponse.getBody().getEmail());
		
		//Testing another Citizen		
		request = new CitizenInformationRequest("agolmay@goomail.com", "1234");	
		
		restResponse = 
				restTemplate.postForEntity("http://localhost:8080/user", request, 
						CitizenInformationResponse.class);

		assertNotNull(restResponse);
	
		assertEquals(new Long(6), restResponse.getBody().getId());
		assertEquals("Aniceto", restResponse.getBody().getFirstName());
		assertEquals("Gol Mayordomo", restResponse.getBody().getLastName());
		assertEquals(29, restResponse.getBody().getAge());
		assertEquals("agolmay@goomail.com", restResponse.getBody().getEmail());
		
		//Testing another Citizen
		request = new CitizenInformationRequest("isalopez@yourmail.com", "1234");		
		restResponse = 
				restTemplate.postForEntity("http://localhost:8080/user", request, 
						CitizenInformationResponse.class);

		assertNotNull(restResponse);
	
		assertEquals(new Long(10), restResponse.getBody().getId());
		assertEquals("Isabel", restResponse.getBody().getFirstName());
		assertEquals("López Pérez", restResponse.getBody().getLastName());
		assertEquals(58, restResponse.getBody().getAge());
		assertEquals("isalopez@yourmail.com", restResponse.getBody().getEmail());	
	}	
}

