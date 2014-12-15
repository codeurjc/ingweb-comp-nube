package es.sidelab.sample.blog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.sidelab.sample.blog.model.BlogEntry;

public interface BlogEntryRepository extends MongoRepository<BlogEntry, String> {

	List<BlogEntry> findByAuthor(String author);
	
}
