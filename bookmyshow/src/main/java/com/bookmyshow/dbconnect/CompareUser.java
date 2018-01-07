package com.bookmyshow.dbconnect;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmyshow.dbo.BookingUser;

public class CompareUser {
	public static boolean checkUser(BookingUser usr) throws ClassNotFoundException, IOException, PropertyVetoException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		@SuppressWarnings("unused")
		List<BookingUser> userList = new ArrayList<BookingUser>();
		int count = 0;
		Connection con;

		try {
			con = DBUtil.getConnection();
			String SQL = "SELECT COUNT(*) FROM BookingUser WHERE UserName=? AND Passwd=?";
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, usr.getUserName());
			stmt.setString(2, usr.getPassword());
			rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count == 0)
			return false;
		else
			return true;
	}

	public static boolean isUserExists(String userId) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		Connection con;
		try {
			con = DBUtil.getConnection();
			String SQL = "SELECT COUNT(*) FROM BookingUser WHERE UserName=?";
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, userId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
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
		if (count == 0)
			return false;
		else
			return true;
	}

	public static boolean enterUserDetails(BookingUser usr) {
		PreparedStatement stmt = null;
		int count = 0;
		Connection con;
		try {
			con = DBUtil.getConnection();
			String SQL = "INSERT INTO BookingUser VALUES(?,?,?,?,?)";
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, usr.getUserName());
			stmt.setString(2, usr.getFullName());
			stmt.setString(3, usr.getPassword());
			stmt.setInt(4, usr.getAge());
			stmt.setInt(5, usr.getPhoneNumber());
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
