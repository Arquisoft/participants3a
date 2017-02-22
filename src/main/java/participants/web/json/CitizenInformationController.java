package participants.web.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import participants.model.Ciudadano;
import participants.service.CitizenService;

/**
 * Representa la información que irá en el JSON cuando se 
 * envíen sus datos al usuario
 * 
 * @author UO247242
 * 
 */
@RestController
public class CitizenInformationController {
	
	@Autowired 
	CitizenService citizenService;

	/**
	 * Respuesta HTTP. Incluye información sobre el ciudadano
	 * si existe, sino devuelve error 404
	 * 
	 * @author UO247242
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/citizenInfo")	
	public ResponseEntity<CitizenInformationResponse> citizenInformation(CitizenInformationRequest form) {
		
		String email = form.getLogin();
		String password = form.getPassword();

		Ciudadano ciudadano = citizenService.findByEmailAndPassword(email, password);		
		
		if (ciudadano != null) {
			CitizenInformationResponse citizen = new CitizenInformationResponse(ciudadano);

		return ResponseEntity.ok(citizen);
		}
		
		else
			return new ResponseEntity<CitizenInformationResponse>(HttpStatus.NOT_FOUND);
	}	
}
