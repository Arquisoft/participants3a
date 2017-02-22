package participants.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import participants.model.Ciudadano;
import participants.model.CitizenRepository;
import participants.web.ErrorResponse;

@Controller
public class MainController {

	@Autowired
	private CitizenRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLoginHtml(Model model) {
		return "login";
	}

	@RequestMapping(value = "/validacion", method = RequestMethod.POST)
	public String postUserHtml(@RequestBody String parametros, Model model) {
		String[] parametro = parametros.split("&");

		// if(parametro[0].split("=").length<=1)
		// Deberia lanzar un error de se requiere EMAIL

		// if(parametro[1].split("=").length<=1)
		// Deberia lanzar un error de se requiere EMAIL

		String email = parametro[0].split("=")[1].replace("%40", "@");
		String contraseña = parametro[1].split("=")[1];

		Ciudadano user = null;// Obtener el user como sea;

		model.addAttribute("email", user.getEmail());
		model.addAttribute("name", user.getNombre() + user.getApellidos());
		model.addAttribute("nif", user.getDni());
		model.addAttribute("address", user.getResidencia());
		model.addAttribute("nationality", user.getNacionalidad());

		return "datos";
	}

	@ExceptionHandler(ErrorResponse.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleErrorResponseNotFound(ErrorResponse excep, Model model) {
		model.addAttribute("error", excep.getMessageStringFormat());

		return "error";
	}
}