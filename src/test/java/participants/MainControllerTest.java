package participants;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import participants.Application;
import participants.UserInfo;
import participants.service.CitizenService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class MainControllerTest {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private CitizenService userService;
    
    private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = new TestRestTemplate();
	}

	@Test
	public void getLanding() throws Exception {
		String userURI = base.toString() + "/user";  
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertThat(response.getBody(), containsString("Login"));
		assertThat(response.getBody(), containsString("Password"));
	}
	
	@Test
	public void getUser() throws Exception {
		String userURI = base.toString() + "/user";  
		ResponseEntity<String> response = template.getForEntity(userURI, String.class);
		UserInfo expected = new UserInfo("pepe",0);
	}
	
	@Test
	public void getDatosCitizen() {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		String userURI = base.toString() + "/validarse";
		
		
		response = template.postForEntity(userURI, new PeticionServicioWeb("pperez@prueba.com", "1234"), String.class);
		assertThat(response.getBody(), containsString("Email: pperez@prueba.com"));
		assertThat(response.getBody(), containsString("Address: Uría, 3 Oviedo Asturias"));
		assertThat(response.getBody(), containsString("Nationality: ESP"));
	}
	
	
	public class PeticionServicioWeb
	{
		private String email;
		private String password;
		
		
		public PeticionServicioWeb() {}
		
		public PeticionServicioWeb(String email, String password)
		{
			this.email = email;
			this.password = password;
		}
		
		
		public String getEmail()
		{
			return email;
		}
		
		public void setEmail(String email)
		{
			this.email = email;
		}
		
		public String getPassword()
		{
			return password;
		}
		
		public void setPassword(String password)
		{
			this.password = password;
		}
	}
}

