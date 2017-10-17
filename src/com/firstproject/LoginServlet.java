package com.firstproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    		PrintWriter out= response.getWriter();
    		HttpSession session= request.getSession();
    		String uname=request.getParameter("user");
    		String pwd=request.getParameter("pass");
       		response.setContentType("text/html");
    		try {
    			Connection con=Dbutil.getConnection();	
    			Statement st= con.createStatement();
    		    ResultSet rs=st.executeQuery("select * from Login where USERNAME='"+uname+"' and PASSWORD='"+pwd+"'");
    		    if(rs.next()){
    		    	out.println("Welcome\t\t"+uname);
    		    	RequestDispatcher rd=request.getRequestDispatcher("Questions.jsp");
    		    	rd.include(request,response);
    		    	session.setAttribute("Username",uname);
    		    	
    		    }
    		    else{
    		    	RequestDispatcher rd=request.getRequestDispatcher("Login.html");
    		    	rd.include(request,response);
    		    	out.println("Invalid Credentials Try again");
    		    }
    
	
	}
    	catch (SQLException e) {
		e.printStackTrace();
	}	
 }

}
