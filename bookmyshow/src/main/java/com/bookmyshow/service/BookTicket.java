package com.bookmyshow.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyshow.dbconnect.FetchMovieShow;

/**
 * Servlet implementation class BookTicket
 */
public class BookTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String showTimingId, username;
		int count;
		boolean result;
		username = (String) session.getAttribute("savedUserName");
		count = Integer.parseInt(request.getParameter("count"));
		showTimingId = request.getParameter("shows");
		result = FetchMovieShow.enterTicketDetails(showTimingId, username, count);
		if (result) {
			request.setAttribute("booking_message", "Booking succesful!!");
			request.getRequestDispatcher("MovieShows.jsp").forward(request, response);
		} else {
			request.setAttribute("existing_booking_msg", "No Booking found!!");
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
