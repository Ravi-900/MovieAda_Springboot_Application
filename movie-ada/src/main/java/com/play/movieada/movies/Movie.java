package com.play.movieada.movies;

import java.util.List;

public class Movie {
	
	private Long id; //id
	private String title; //title or original_title
	private String background; //backdrop_path
	private List<Integer> genre; //genre_ids = [14,28,12]
	private String summary; //overview
	private String poster; //poster_path
	private String releaseDate; //release_date
	private float ratings; //vote_average
	private boolean adult; //adult
	private String videoKey; //key
	
	public Movie() {}

	public Movie(Long id, String title, String background, List<Integer> genre, String summary, String poster,
			String releaseDate, float ratings, boolean adult, String videoKey) {
		super();
		this.id = id;
		this.title = title;
		this.background = background;
		this.genre = genre;
		this.summary = summary;
		this.poster = poster;
		this.releaseDate = releaseDate;
		this.ratings = ratings;
		this.adult = adult;
		this.videoKey = videoKey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public List<Integer> getGenre() {
		return genre;
	}

	public void setGenre(List<Integer> genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public String getVideoKey() {
		return videoKey;
	}

	public void setVideoKey(String videoKey) {
		this.videoKey = videoKey;
	}

	@Override
	public String toString() {
		return "id=" + id + ", title=" + title + ", background=" + background + ", genre=" + genre + ", summary="
				+ summary + ", poster=" + poster + ", releaseDate=" + releaseDate + ", ratings=" + ratings + ", adult="
				+ adult + ", videoKey=" + videoKey;
	}
	
}
