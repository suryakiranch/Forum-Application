package com.firstproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ConversationServlet")
public class ConversationServlet extends HttpServlet {
		
	private static final long serialVersionUID = 1L;

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		String ques=(String)session.getAttribute("question");
		String user=(String)session.getAttribute("Username");
		String ans=request.getParameter("aname");
		
		
		try {
			Connection con=Dbutil.getConnection();	
			PreparedStatement ps= con.prepareStatement("insert into Question values(?,?,?)");
	
			ps.setString(1,user);

			ps.setString(2,ques);
		    
			ps.setString(3,ans);
			
		    int i=ps.executeUpdate();
		    
		    if(i==1){
		    	RequestDispatcher rd=request.getRequestDispatcher("conversations1.jsp");
		    	rd.include(request,response);	    	
		    }
		    
		} 
			catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
