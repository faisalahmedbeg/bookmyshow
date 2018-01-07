package com.bookmyshow.dbconnect;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmyshow.dbo.CurrentBooking;
import com.bookmyshow.dbo.MovieShow;

public class FetchMovieShow {

	public static List<MovieShow> fetchMovieShows() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<MovieShow> showList = new ArrayList<MovieShow>();
		Connection con;

		try {
			con = DBUtil.getConnection();

			String SQL = "SELECT Id,MovieName,ShowName,Fare FROM Movies M,ShowTimings ST, Shows S "
					+ "WHERE M.MovieId=ST.MovieId AND ST.ShowId=S.ShowId";
			stmt = con.prepareStatement(SQL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				showList.add(new MovieShow(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return showList;
	}

	public static List<CurrentBooking> fetchBooking(String userName) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<CurrentBooking> bookingList = new ArrayList<CurrentBooking>();
		Connection con;

		try {
			con = DBUtil.getConnection();

			String SQL = "SELECT TicketId,MovieName,ShowName,Count FROM MovieTicket mt, Shows s, Movies m, ShowTimings st, BookingUser b "
					+ "WHERE s.ShowId=st.ShowId AND m.MovieId = st.MovieId AND mt.ShowTimingId = st.Id AND b.UserName = ? ";
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
			while (rs.next()) {
				bookingList.add(new CurrentBooking(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookingList;
	}

	public static boolean enterTicketDetails(String showTimingId, String username, int countPerson) {
		PreparedStatement stmt = null;
		int count = 0;
		Connection con;
		try {
			con = DBUtil.getConnection();
			String SQL = "INSERT INTO MovieTicket VALUES(?,?,?)";
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, showTimingId);
			stmt.setString(3, username);
			stmt.setInt(2, countPerson);
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count == 0)
			return false;
		else
			return true;
	}

	public static boolean deleteTicket(int ticketId) {
		PreparedStatement stmt = null;
		int count = 0;
		Connection con;
		try {
			con = DBUtil.getConnection();
			String SQL = "DELETE FROM MovieTicket WHERE TicketId = ?";
			stmt = con.prepareStatement(SQL);
			stmt.setInt(1, ticketId);
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count == 0)
			return false;
		else
			return true;
	}
}
