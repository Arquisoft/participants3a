package participants.service;

import java.util.List;

import participants.model.User;

/**
 * Punto de entrada a los servicios de 
 * persistencia de los usuarios
 * 
 * @author UO246008
 *
 */
public interface UserService {
	/**
	 * Consulta todos los usuarios registrados
	 * en el sistema
	 * 
	 * @return usuarios del sistema
	 */
	List<User> findUsers();
	/**
	 * Registra un usuario en el sistema
	 * 
	 * @param user usuario a registrar
	 */
	void saveUser(User user);
	
	User findByEmailAndPassword(String email, String password);
}
