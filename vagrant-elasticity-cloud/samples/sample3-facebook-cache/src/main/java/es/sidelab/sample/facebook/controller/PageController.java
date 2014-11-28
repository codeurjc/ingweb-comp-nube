package es.sidelab.sample.facebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.sidelab.sample.facebook.model.Page;
import es.sidelab.sample.facebook.service.FacebookLookupService;

@RestController
public class PageController {

	@Autowired
	private FacebookLookupService service;
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public Page addComment(
			@RequestParam String name) {

		return service.findPage(name);
		
	}
	
}
