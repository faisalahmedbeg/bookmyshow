package com.bookmyshow.dbo;

public class MovieShow {
	private String id;
	private String movieName;
	private String showName;
	private int fare;

	public MovieShow(String id, String movieName, String showName, int fare) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.showName = showName;
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "MovieShow [movieName=" + movieName + ", showName=" + showName + ", fare=" + fare + "]";
	}

	public String getId() {
		return id;
	}

}
