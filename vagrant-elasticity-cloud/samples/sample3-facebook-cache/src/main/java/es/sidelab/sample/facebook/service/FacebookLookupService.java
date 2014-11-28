package es.sidelab.sample.facebook.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.sidelab.sample.facebook.model.Page;

@Service
public class FacebookLookupService {

    RestTemplate restTemplate = new RestTemplate();

    @Cacheable("pages")
    public Page findPage(String page) {
        return restTemplate.getForObject("http://graph.facebook.com/" + page, Page.class);
    }

}
