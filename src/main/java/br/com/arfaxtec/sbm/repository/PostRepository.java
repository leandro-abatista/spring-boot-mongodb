package br.com.arfaxtec.sbm.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.arfaxtec.sbm.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
}
