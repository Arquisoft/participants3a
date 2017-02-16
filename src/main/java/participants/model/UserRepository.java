package participants.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz para trabajar con la base de datos de usuarios
 * (CRUD)
 * 
 * @author UO246008
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
}
