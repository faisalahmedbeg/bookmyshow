package com.bookmyshow.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmyshow.dbconnect.CompareUser;
import com.bookmyshow.dbo.BookingUser;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUser() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reg_username, reg_password, reg_repassword, reg_fullname;
		int reg_age, reg_phonenumber;
		@SuppressWarnings("unused")
		boolean result = false;
		reg_username = request.getParameter("reg_username");
		reg_password = request.getParameter("reg_password");
		reg_repassword = request.getParameter("reg_repassword");
		reg_fullname = request.getParameter("reg_fullname");
		reg_age = Integer.parseInt(request.getParameter("reg_age"));
		reg_phonenumber = Integer.parseInt(request.getParameter("reg_phonenumber"));
		if (!reg_password.equals(reg_repassword)) {
			request.setAttribute("reg_message", "Passwords are not matching!!");
		} else if (CompareUser.isUserExists(reg_username)) {
			request.setAttribute("reg_message", "UserName already exists !!");
		} else if (CompareUser.enterUserDetails(
				new BookingUser(reg_username, reg_fullname, reg_password, reg_age, reg_phonenumber))) {
			request.setAttribute("reg_message", "User has been created !!");
		}
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
