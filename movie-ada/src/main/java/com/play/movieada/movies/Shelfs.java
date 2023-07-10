package com.play.movieada.movies;

import java.util.List;

public class Shelfs {

	private Integer shelfId;
	private List<Movie> shelfMoviesList;
	private String shelfTitle;
	
	public Shelfs() { }

	public Shelfs(Integer shelfId, List<Movie> shelfMoviesList, String shelfTitle) {
		super();
		this.shelfId = shelfId;
		this.shelfMoviesList = shelfMoviesList;
		this.shelfTitle = shelfTitle;
	}

	public Integer getShelfId() {
		return shelfId;
	}

	public void setShelfId(Integer shelfId) {
		this.shelfId = shelfId;
	}

	public List<Movie> getShelfMoviesList() {
		return shelfMoviesList;
	}

	public void setShelfMoviesList(List<Movie> shelfMoviesList) {
		this.shelfMoviesList = shelfMoviesList;
	}

	public String getShelfTitle() {
		return shelfTitle;
	}

	public void setShelfTitle(String shelfTitle) {
		this.shelfTitle = shelfTitle;
	}

	@Override
	public String toString() {
		return "[shelfId=" + shelfId + ", shelfMoviesList=" + shelfMoviesList + ", shelfTitle=" + shelfTitle+"]";
	}
	
	
}
