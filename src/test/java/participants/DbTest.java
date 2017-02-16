package participants;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import participants.Application;
import participants.model.User;
import participants.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class DbTest {

    @Autowired
    private UserService userService;

	@Test
	public void testSaveUser() throws Exception {
		int previousSize = userService.findUsers().size();
		userService.saveUser(new User("", "", "", new Date(), "", "", "", ""));
		assertEquals(previousSize + 1, userService.findUsers().size());
		userService.saveUser(new User("", "", "", new Date(), "", "", "", ""));
		assertEquals(previousSize + 2, userService.findUsers().size());
	}
	
	@Test
	public void testFindByLoginPassword() throws Exception {
		User user = new User("a@a.com", "A", "A", new Date(), "Casa", "ESP", "12345678A", "ab");
		userService.saveUser(user);
		assertEquals(user, userService.findByEmailAndPassword("a@a.com", "ab"));
	}
}