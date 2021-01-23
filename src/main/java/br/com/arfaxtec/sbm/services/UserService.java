package br.com.arfaxtec.sbm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arfaxtec.sbm.domain.User;
import br.com.arfaxtec.sbm.dto.UserDTO;
import br.com.arfaxtec.sbm.repository.UserRepository;
import br.com.arfaxtec.sbm.services.exception.ObjectNoSuchElementException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		// retorna uma lista de objetos do tipo User
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);

		if (user == null) {
			throw new ObjectNoSuchElementException("No value present!/Nenhum valor presente!");
		} 
		
		User u = new User();
		u.setId(user.get().getId());
		u.setName(user.get().getName());
		u.setEmail(user.get().getEmail());
		return u;

	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

}
