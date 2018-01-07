package com.bookmyshow.service;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyshow.dbconnect.CompareUser;
import com.bookmyshow.dbo.BookingUser;

/**
 * Servlet implementation class AuthenticateUser
 */
public class AuthenticateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticateUser() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username, password;
		boolean result = false;
		username = request.getParameter("username");
		// logger.info("Login Attempt by user " + userId);
		password = request.getParameter("password");
		CompareUser cu = new CompareUser();
		try {
			result = cu.checkUser(new BookingUser(username, null, password, 0, 0));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!result) {
			request.setAttribute("login_message", "Username or Password not correct");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			session.setAttribute("savedUserName", username);
			response.sendRedirect("MovieShows.jsp");
		}
	}
}
