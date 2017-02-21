package participants.service;

import java.util.List;

import participants.model.Ciudadano;

/**
 * Punto de entrada a los servicios de 
 * persistencia de los usuarios
 * 
 * @author UO246008
 *
 */
public interface CitizenService {
	/**
	 * Consulta todos los usuarios registrados
	 * en el sistema
	 * 
	 * @return usuarios del sistema
	 */
	List<Ciudadano> findCitizens();
	/**
	 * Registra un usuario en el sistema
	 * 
	 * @param user usuario a registrar
	 */
	void saveCitizen(Ciudadano ciudadano);
}
