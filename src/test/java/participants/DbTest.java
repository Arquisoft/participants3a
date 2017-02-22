package participants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import participants.model.Ciudadano;
import participants.model.Usuario;
import participants.service.CitizenService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class DbTest {

    @Autowired
    private CitizenService citizenService;

	@Test
	public void testSaveCitizen() throws Exception {
		int previousSize = citizenService.findCitizens().size();
		citizenService.saveCitizen(new Ciudadano("", "", "", new Date(), "", "", "", new Usuario("", "")));
		assertEquals(previousSize + 1, citizenService.findCitizens().size());
		assertNotNull(citizenService.findCitizens().get(0).getUsuario());
		citizenService.saveCitizen(new Ciudadano("", "", "", new Date(), "", "", "", new Usuario("", "")));
		assertEquals(previousSize + 2, citizenService.findCitizens().size());
		assertNotNull(citizenService.findCitizens().get(0).getUsuario());
	}
	
	@Test
	public void testFindByLoginPassword() throws Exception {
		Ciudadano citizen = new Ciudadano("A", "A", "a@a.com", new Date(), "Casa", "ESP", "12345678A", new Usuario("", "ab"));
		citizenService.saveCitizen(citizen);
		assertEquals(citizen, citizenService.findByEmailAndPassword("a@a.com", "ab"));
	}
}
