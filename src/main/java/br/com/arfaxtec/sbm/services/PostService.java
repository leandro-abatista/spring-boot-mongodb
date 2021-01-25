package br.com.arfaxtec.sbm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arfaxtec.sbm.domain.Post;
import br.com.arfaxtec.sbm.repository.PostRepository;
import br.com.arfaxtec.sbm.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
		

		/*
		 * if (user == null) { throw new
		 * ObjectNoSuchElementException("No value present!/Nenhum valor presente!"); }
		 * 
		 * User u = new User(); u.setId(user.get().getId());
		 * u.setName(user.get().getName()); u.setEmail(user.get().getEmail()); return u;
		 */
	}

}
