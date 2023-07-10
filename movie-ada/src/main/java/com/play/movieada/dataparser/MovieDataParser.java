package com.play.movieada.dataparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.play.movieada.movies.Movie;
import com.play.movieada.movies.Shelfs;

@Service
public class MovieDataParser {

	public MovieDataParser() {}

	public List<Movie> getRelatedContent(String contentType) {
		String uri = "https://api.themoviedb.org/3/movie/"+contentType+"?api_key=fe9b5fc91811c100d2052381163e3cc3";

		RestTemplate restTemplate = new RestTemplate();
		String relatedContents = restTemplate.getForObject(uri,String.class);

		return jsonDataParser(relatedContents);
	}
	
	public List<Shelfs> getAllCategoriesMovies() {
		List<Shelfs> shelfsData = new ArrayList<>();

		Arrays.asList("now_playing","popular","top_rated").parallelStream().forEach((relatedMovies) -> {
			Shelfs shelf = new Shelfs();
			switch(relatedMovies) {
				case "now_playing" :
					shelf.setShelfId(1);
					shelf.setShelfTitle("Now Playing");
				break;
				case "popular" :
					shelf.setShelfId(2);
					shelf.setShelfTitle("Popular");
				break;
				case "top_rated" :
					shelf.setShelfId(3);
					shelf.setShelfTitle("Top Rated");
				break;
			}
			shelf.setShelfMoviesList(getRelatedContent(relatedMovies));
			shelfsData.add(shelf);
	    });

		Arrays.asList(27,12,16,35,80,99,18,10751,14,28,36,10402,9648,10749,878,10770,53,10752,37).parallelStream().forEach((genre)->{
			Shelfs shelf = new Shelfs();

			shelf.setShelfId(genre);
			shelf.setShelfTitle(getShelfGenreTitle(genre));
			shelf.setShelfMoviesList(getMoviesByGenre(genre));
			shelfsData.add(shelf);
		});

		return shelfsData;
	}
	
	private String getShelfGenreTitle(Integer genre) {

		switch(genre) {
			case 27: return "Horror";
			case 12: return "Adventure";
			case 16: return "Animation";
			case 35: return "Comedy";
			case 80: return "Crime";
			case 99: return "Documentary";
			case 18: return "Drama";
			case 10751: return "Family";
			case 14: return "Fantasy";
			case 28: return "Action";
			case 36: return "History";
			case 10402: return "Music";
			case 9648: return "Mystery";
			case 10749: return "Romance";
			case 878: return "Science Fiction";
			case 10770: return "TV Movie";
			case 53: return "Thriller";
			case 10752: return "War";
			case 37: return "Western";
		}
		return null;
	}

	public List<Movie> getMoviesByGenre(int genreId){
		String uri = "https://api.themoviedb.org/3/discover/movie?with_genres="+genreId+"&api_key=fe9b5fc91811c100d2052381163e3cc3";
		
		RestTemplate restTemplate = new RestTemplate();
		String relatedContents = restTemplate.getForObject(uri,String.class);

		return jsonDataParser(relatedContents);
	}
	
	public List<Movie> jsonDataParser(String relatedContents){
		
		List<Movie> relatedMovies = new ArrayList<>();
		
		try {
			JSONObject jsonRelatedContent = new JSONObject(relatedContents);
			if(jsonRelatedContent.has("results")) { 
				JSONArray results = jsonRelatedContent.getJSONArray("results");

				for(int i=0;i<results.length();i++) {
					JSONObject movieDetails= (JSONObject) results.get(i);
					
					Movie movie = new Movie();
					
					movie.setId(Long.parseLong(movieDetails.get("id").toString()));
					movie.setTitle(movieDetails.get("title").toString());
					movie.setBackground(movieDetails.get("backdrop_path").toString());
					
					List<Integer> genres = new ArrayList<>();
					JSONArray movieGenre = movieDetails.getJSONArray("genre_ids");
					
					for(int j=0;j<movieGenre.length();j++) {
						genres.add(movieGenre.getInt(j));
					}
					movie.setGenre(genres);
					
					movie.setSummary(movieDetails.get("overview").toString());
					movie.setPoster(movieDetails.get("poster_path").toString());
					movie.setReleaseDate(movieDetails.get("release_date").toString());
					movie.setRatings(Float.parseFloat(movieDetails.get("vote_average").toString()));
					movie.setAdult(Boolean.parseBoolean(movieDetails.get("adult").toString()));
					movie.setVideoKey(getMovieVideoUrl(Long.parseLong(movieDetails.get("id").toString())));
					
					relatedMovies.add(movie);
				}
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return relatedMovies;
	}
	
	public String getMovieVideoUrl(Long movieId) {
		String uri = "https://api.themoviedb.org/3/movie/"+movieId+"/videos?api_key=fe9b5fc91811c100d2052381163e3cc3";
		
		RestTemplate restTemplate = new RestTemplate();
		String videoContent = restTemplate.getForObject(uri,String.class);
		
		JSONObject jsonVideoContent;
		String videoUrl=null;
		try {
			jsonVideoContent = new JSONObject(videoContent);
			if(jsonVideoContent.has("results")) {
				JSONArray results = jsonVideoContent.getJSONArray("results");
				if(results.length()>0) {
					JSONObject videoDetails= (JSONObject) results.get(0);
					videoUrl = videoDetails.get("key").toString();
				}
				else videoUrl="8kooIgKESYE";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		return videoUrl;
	}
}
