package br.com.arfaxtec.sbm.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.arfaxtec.sbm.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User obj1 = new User("1", "Maria Silva", "maria@gmail.com");
		User obj2 = new User("2", "Alex Martilio", "alex@gmail.com");
		User obj3 = new User("3", "Cassilda Merentina", "cacilda@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(obj1, obj2, obj3));
		return ResponseEntity.ok().body(list);
	}

}
