<%@page import="com.firstproject.Dbutil"%>
<%@page import="java.sql.*"%>

<table>
<%
//String question=request.getParameter("Q");


String question=(String)session.getAttribute("question");

Connection con=Dbutil.getConnection();	
Statement s=con.createStatement();
ResultSet rs=s.executeQuery("select * from Question where QUESTIONNAME='"+question+"'");
%>
 <tr>
    <th><%=(String)session.getAttribute("question")%></th>
    <th><%=(String)session.getAttribute("Username") %></th>
  </tr>
 <% 
while(rs.next()){
  %>
  <tr>
    <td><%=rs.getString("ANSWER") %></td>
    
	<td><%=rs.getString("USENAME") %></td>
	      
      </tr>
               
<%
}
%>
</table>

<form action="ConversationServlet">

<table>
<tr>
<td><textarea rows = "4" cols="100" name="aname">Enter your ideas</textarea></td>
</tr>
<tr>
<td>
<input type = "submit" value = "Submit"/>
</td>
</tr>
</table>

</form>

