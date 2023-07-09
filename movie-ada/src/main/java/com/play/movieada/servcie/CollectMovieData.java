package com.play.movieada.servcie;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CollectMovieData {
	
	private Environment env;
	
	public CollectMovieData(Environment env) {
		super();
		this.env = env;
	}

	public String getMovie(String movieId) {
		String uri = env.getProperty("base_url")+movieId+"?api_key="+env.getProperty("api_key");
		
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri,String.class);
	}

	public String getSearchResults(String searchKey) {
		String uri = env.getProperty("search_base_url")+"query="+searchKey+"&api_key="+env.getProperty("api_key");
		
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri,String.class);
	}
}