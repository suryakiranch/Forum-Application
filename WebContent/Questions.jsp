<%@page import="com.firstproject.Dbutil"%>
<%@page import="java.sql.*"%>
<a href="Main.html">Add Question?</a><br>
<%
Connection con=Dbutil.getConnection();	
Statement s=con.createStatement();
ResultSet rs=s.executeQuery("select distinct questionname,usename from Question");

while(rs.next()){
%>
<a href='conversations.jsp?Q=<%=rs.getString(1)%>' > <%=rs.getString(1)%> </a> <%=rs.getString(2)%> <br/><br/>
<%
}
%>

