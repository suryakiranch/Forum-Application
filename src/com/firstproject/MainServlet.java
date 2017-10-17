package com.firstproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session	=request.getSession();
		
		String uname=(String)session.getAttribute("Username");	
	
		String questionname=request.getParameter("qname");
			
		PrintWriter out= response.getWriter();
		
		response.setContentType("text/html");
		
		try {
				Connection con=Dbutil.getConnection();	
				PreparedStatement ps= con.prepareStatement("insert into Question values(?,?,?)");
			    ps.setString(1,uname);
				ps.setString(2,questionname);
				ps.setString(3,"");
				int s=ps.executeUpdate();
				if(s==1){
					RequestDispatcher rd=request.getRequestDispatcher("Questions.jsp");
					rd.forward(request,response);
					out.println(uname);
					out.println(questionname);		
				}
							
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
