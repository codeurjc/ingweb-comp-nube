package es.sidelab.sample.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.sidelab.sample.blog.model.BlogEntry;
import es.sidelab.sample.blog.model.Comment;
import es.sidelab.sample.blog.repository.BlogEntryRepository;

@RestController
public class BlogController {
	
	@Autowired
	private BlogEntryRepository repository;
	
	@RequestMapping(value="/blog/{id}/comment", method=RequestMethod.PUT)
	public BlogEntry addComment(
			@PathVariable String blogEntryId, 
			@RequestBody Comment comment) {
		
		BlogEntry blogEntry = repository.findOne(blogEntryId);
		blogEntry.getComments().add(comment);
		return repository.save(blogEntry);
		
	}
	
	@RequestMapping(value="/blogbyauthor", method=RequestMethod.GET)
	public List<BlogEntry> findByAuthor(@RequestParam String author) {
		return repository.findByAuthor(author);
	}
	
	@RequestMapping(value="/blog", method=RequestMethod.PUT)
	public BlogEntry addBlogEntry(@RequestBody BlogEntry blogEntry) {
		
		return repository.save(blogEntry);
		
	}
	
	@RequestMapping(value="/blogs", method=RequestMethod.GET)
	public List<BlogEntry> getAllBlogs(
			@RequestParam(value="page", defaultValue="0") int page, 
			@RequestParam(value="size", defaultValue="10") int size) {
		
		Pageable pageable = new PageRequest(page, size);
		Page<BlogEntry> pageResult = repository.findAll(pageable);
		
		return pageResult.getContent();
	}

	@RequestMapping(value="/blog/{id}", method=RequestMethod.GET)
	public BlogEntry getBlogEntryById(@PathVariable String id) {
		return repository.findOne(id);
	}
}
