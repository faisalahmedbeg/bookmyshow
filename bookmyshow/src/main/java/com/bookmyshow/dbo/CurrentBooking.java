package com.bookmyshow.dbo;

public class CurrentBooking {
	int ticketId;
	String movieName;
	String showName;
	int Count;

	public CurrentBooking(int ticketId, String movieName, String showName, int count) {
		super();
		this.movieName = movieName;
		this.showName = showName;
		Count = count;
	}

	public int getTicketId() {
		return ticketId;
	}

	@Override
	public String toString() {
		return "Movie=" + movieName + ", Show=" + showName + ", Persons=" + Count;
	}
}
