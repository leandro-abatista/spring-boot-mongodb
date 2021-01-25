package br.com.arfaxtec.sbm.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.arfaxtec.sbm.domain.Post;
import br.com.arfaxtec.sbm.domain.User;
import br.com.arfaxtec.sbm.dto.AuthorDTO;
import br.com.arfaxtec.sbm.dto.CommentDTO;
import br.com.arfaxtec.sbm.repository.PostRepository;
import br.com.arfaxtec.sbm.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("2018/03/21"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("2018/03/23"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Comentário teste 1", sdf.parse("2021/01/25"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Comentário teste 2", sdf.parse("2021/01/25"), new AuthorDTO(alex));
		CommentDTO c3 = new CommentDTO("Comentário teste 3", sdf.parse("2021/01/25"), new AuthorDTO(maria));
		CommentDTO c4 = new CommentDTO("Comentário teste 4", sdf.parse("2021/01/25"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3, c4));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		/*incluiu a lista de post na entidade maria*/
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		
	}

}
