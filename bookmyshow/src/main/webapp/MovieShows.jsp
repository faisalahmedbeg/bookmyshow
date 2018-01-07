<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bookmyshow.dbconnect.FetchMovieShow" %>
<%@ page import="com.bookmyshow.dbo.MovieShow" %>
<%@ page import="com.bookmyshow.dbo.CurrentBooking" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.DriverManager" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Shows</title>
</head>
<body>
<%
String msg1 = (String)request.getAttribute("booking_message");
String msg2 = (String)request.getAttribute("existing_booking_msgs");
String msg3 = (String)request.getAttribute("deleted_message");
String userName = (String)session.getAttribute("savedUserName");
%>
<h1>Movie Shows</h1>
<br>
<h2>Welcome <%=userName %></h2>
<h4>Choose the Show to Book</h4>
<%
List<MovieShow> shows = FetchMovieShow.fetchMovieShows();
for(MovieShow ms:shows) {
%>
<br>
<form method="get" action="BookTicket">
<INPUT TYPE="radio" name="shows" value="<%= ms.getId() %>"/>
<%=ms.toString() %>
<%
}
%>
<br>Count: <input type="text" name="count" />
<br><INPUT TYPE="submit" VALUE="Book" />
</form>
<%
if (msg1!= null) 
out.println(msg1);
%>
<h4>Select from existing Booking to Delete</h4>
<%
List<CurrentBooking> bookings = FetchMovieShow.fetchBooking(userName);
if (!bookings.isEmpty()) {
for(CurrentBooking cb:bookings) {
%>
<br>
<form method="get" action="DeleteTicket">
<INPUT TYPE="radio" name="deleted" value="<%= Integer.toString(cb.getTicketId()) %>"/>
<%=cb.toString() %>
<%
}
%>
<br><INPUT TYPE="submit" VALUE="Delete" />
</form>
<%
}
if (msg2!= null) 
out.println(msg2);
if (msg3!= null) 
out.println(msg3);
%>
</body>
</html>