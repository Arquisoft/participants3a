package participants.web;

import java.sql.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitizenInformationController {

	@RequestMapping(method = RequestMethod.POST, value = "/citizenInfo")
	
	public ResponseEntity<CitizenInformation> citizenInformation(Long id, String firstName, 
			String lastName, Date birthday, String email) {

		CitizenInformation citizen = new CitizenInformation(id, firstName, lastName, birthday, email);

		return ResponseEntity.ok(citizen);
	}
}
