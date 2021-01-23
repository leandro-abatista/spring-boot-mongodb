package br.com.arfaxtec.sbm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arfaxtec.sbm.domain.User;
import br.com.arfaxtec.sbm.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		//retorna uma lista de objetos do tipo User
		return repository.findAll();
	}

}
