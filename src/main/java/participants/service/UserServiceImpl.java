package participants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import participants.model.User;
import participants.model.UserRepository;

/**
 * Implementación de los servicios de 
 * gestión de persistencia de usuarios
 * 
 * @author UO246008
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findUsers() {
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}
}
