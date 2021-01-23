package br.com.arfaxtec.sbm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.arfaxtec.sbm.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{


}
