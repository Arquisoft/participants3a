package participants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import participants.model.Ciudadano;
import participants.model.Usuario;
import participants.service.CitizenService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
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
		
		//Comprobamos que todos los campos se guardan correctamente
		citizenService.saveCitizen(new Ciudadano("Rodrigo", 
				"Fernández Sánchez",
				"rodrigofers@correo.es", 
				new Date(), 
				"Alicante", 
				"ESP", 
				"20212223B", 
				new Usuario("rodrigofers", "1234")));
		
		Ciudadano citizen = citizenService.findByEmailAndPassword("rodrigofers@correo.es", "1234");
		assertNotNull(citizen);
		assertEquals("Rodrigo", citizen.getNombre());
		assertEquals("Fernández Sánchez", citizen.getApellidos());
		assertEquals("rodrigofers@correo.es", citizen.getEmail());
		assertNotNull(citizen.getFechaNacimiento());
		assertEquals("Alicante", citizen.getResidencia());
		assertEquals("ESP", citizen.getNacionalidad());
		assertEquals("20212223B", citizen.getDni());
		assertNotNull(citizen.getUsuario());
		assertEquals("rodrigofers", citizen.getUsuario().getUsuario());
		assertEquals("1234", citizen.getUsuario().getContraseña());
	}
	
	@Test
	public void testFindByLoginPassword() throws Exception {
		Ciudadano citizen = new Ciudadano("A", "A", "a@a.com", new Date(), "Casa", "ESP", "12345678A", new Usuario("", "ab"));
		citizenService.saveCitizen(citizen);
		assertEquals(citizen, citizenService.findByEmailAndPassword("a@a.com", "ab"));
		
		//Buscamos uno de los usuarios registrados por defecto
		assertNotNull(citizenService.findByEmailAndPassword("pperez@prueba.com", "7110eda4d09e062aa5e4a390b0a572ac0d2c0220"));
		
		//Si el nombre de usuario o la contraseña son incorrectos devuelve null
		assertNull(citizenService.findByEmailAndPassword("pparez@prueba.com", "7110eda4d09e062aa5e4a390b0a572ac0d2c0220"));
		assertNull(citizenService.findByEmailAndPassword("pperez@prueba.com", "1235"));
		assertNull(citizenService.findByEmailAndPassword("pparez@prueba.com", "1235"));
	}
	
	@Test
	public void testRemoveCitizen() throws Exception {
		Ciudadano citizen = new Ciudadano("B", "B", "y@y.com", new Date(), "Casa", "ESP", "22345678A", new Usuario("az", "ae"));
		citizenService.saveCitizen(citizen);
		assertNotNull(citizenService.findByEmailAndPassword("y@y.com", "ae"));
		citizenService.removeCitizen(citizen);
		assertNull(citizenService.findByEmailAndPassword("y@y.com", "ae"));
	}
	
	@Test
	public void testUpdateCitizen() throws Exception {
		Ciudadano citizen = new Ciudadano("Fernando", "Garcia Alvarez", "fergaral@am.com", new Date(), "Casa", "ESP", "22341218A", new Usuario("fergaral", "ae"));
		citizenService.saveCitizen(citizen);
		citizen = citizenService.findByEmailAndPassword("fergaral@am.com", "ae");
		assertNotNull(citizen);
		assertEquals("Fernando", citizen.getNombre());
		citizen.setNombre("Otronombre");
		citizenService.saveCitizen(citizen);
		citizen = citizenService.findByEmailAndPassword("fergaral@am.com", "ae");
		assertNotNull(citizen);
		assertEquals("Otronombre", citizen.getNombre());
	}
}
