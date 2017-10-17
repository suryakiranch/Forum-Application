package com.firstproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		String Address=request.getParameter("address");
		String hobbies=request.getParameter("hobbies");
		String qualification=request.getParameter("qualification");
		
		try {
			Connection con=Dbutil.getConnection();	
			PreparedStatement ps= con.prepareStatement("insert into forum values(?,?,?,?,?,?,?)");
		    PreparedStatement ps1=con.prepareStatement("insert into Login values(?,?)");
		    ps1.setString(1,username);
		    ps1.setString(2,password);
		    int s1=ps1.executeUpdate();
		    System.out.println(s1);
		    ps.setString(1,username);
		    ps.setString(2,password);
		    ps.setString(3,email);
		    ps.setString(4,sex);
		    ps.setString(5,Address);
		    ps.setString(6,hobbies);
		    ps.setString(7,qualification);
		    int s=ps.executeUpdate();
		    
		    if(s!=0){
		    
		    	RequestDispatcher rd=request.getRequestDispatcher("Login.html");
		    	rd.include(request,response);
		           }
		    else
		    {
		    	
		    	out.println("Please try again");
		    }
		    
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
}
