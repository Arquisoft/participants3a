package participants.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interfaz para trabajar con la base de datos de usuarios
 * (CRUD)
 * 
 * @author UO246008
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * Busca un usuario dados su login y contraseña
	 * 
	 * @param login login del usuario
	 * @param password contraseña
	 * @return usuario con ese login y contraseña
	 */
	@Query("select u from User u where u.email = ?1 and u.password = ?2")
	User findByEmailAndPassword(String email, String password);
}
