package com.play.movieada.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.play.movieada.dataparser.MovieDataParser;
import com.play.movieada.movies.Movie;
import com.play.movieada.movies.Shelfs;
import com.play.movieada.servcie.CollectMovieData;

@Controller
public class MovieController {
	private CollectMovieData movieData;
	private MovieDataParser movieDataParser;

	public MovieController(CollectMovieData movieData, MovieDataParser movieDataParser) {
		super();
		this.movieData = movieData;
		this.movieDataParser = movieDataParser;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String displayMovieAda(Model model) {
		
		List<Movie> upComingMovies = movieDataParser.getRelatedContent("upcoming");
		model.addAttribute("WatchNext",upComingMovies);
		
		List<Shelfs> shelfData = movieDataParser.getAllCategoriesMovies();
		shelfData.sort((shelfData1, shelfData2)-> shelfData1.getShelfId().compareTo(shelfData2.getShelfId()));

		model.addAttribute("ShelfData", shelfData);

		return "movieAda";
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public RedirectView displaySearchResultsFromMovieAda(@RequestParam String searchQuery) {
		return new RedirectView("/movies/"+searchQuery);
	}
	
	@GetMapping("/{MovieId}")
	public String displayMovie(@PathVariable String MovieId, Model model) {
		
		String MovieData = movieData.getMovie(MovieId);
		JSONParser parser = new JSONParser();
		JSONObject movieDataJson = null;
		try {
			movieDataJson = (JSONObject) parser.parse(MovieData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.addAttribute("Movie", movieDataJson);
		
		// search related movies
		
		String searchKey = (String) movieDataJson.get("title");
		
		String relatedMovies = movieData.getSearchResults(searchKey);
		JSONObject relatedMoviesJson = null;
		try {
			relatedMoviesJson = (JSONObject) parser.parse(relatedMovies);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("Movies", relatedMoviesJson.get("results"));
		
		return "movie";
	}
	
	@GetMapping("/movies/{searchKey}")
	public String searchMovies(@PathVariable String searchKey,Model model) {
		String searchResults = movieData.getSearchResults(searchKey);
		JSONParser parser = new JSONParser();
		JSONObject searchResultsJson = null;
		try {
			searchResultsJson = (JSONObject) parser.parse(searchResults);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(searchResultsJson.get("results").toString().length() <= 2) {
			return "errorhandling";
		}
		
		model.addAttribute("Movies", searchResultsJson.get("results"));
		
		return "search";
	}
	
	@PostMapping("/movies/{searchKey}")
	public RedirectView displaySearchResultsFromSearchPage(@RequestParam String searchQuery) {
		return new RedirectView("/movies/"+searchQuery);
	}
	
	@PostMapping("/{MovieId}")
	public RedirectView displaySearchMovieResultsFromMoviePage(@RequestParam String searchQuery) {
		return new RedirectView("/movies/"+searchQuery);
	}

}
