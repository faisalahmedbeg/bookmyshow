package com.bookmyshow.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmyshow.dbconnect.FetchMovieShow;

/**
 * Servlet implementation class DeleteTicket
 */
public class DeleteTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ticketId = Integer.parseInt(request.getParameter("deleted"));
		System.out.println("ticket id = " + ticketId);
		boolean result = FetchMovieShow.deleteTicket(ticketId);
		if (result) {
			request.setAttribute("deleted_message", "Booking Deleted!!");
			request.getRequestDispatcher("MovieShows.jsp").forward(request, response);
		} else {
			request.setAttribute("deleted_message", "Booking could not be deleted!!");
			response.sendRedirect("MovieShows.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
