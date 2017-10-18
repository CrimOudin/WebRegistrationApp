package com.webregistrationapp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebRegistrationApp
 */
@WebServlet("/Register")
public class WebRegistrationApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebRegistrationApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletParam = request.getParameter("servletParam");
		if(servletParam == null)
		{
			Object fName = request.getParameter("first_name");
			Object lName = request.getParameter("last_name");
			Object address1 = request.getParameter("address1");
			Object address2 = request.getParameter("address2");
			Object city = request.getParameter("city");
			Object state = request.getParameter("state");
			Object zip = request.getParameter("zip");
			Object country = request.getParameter("country");
			Date date = new Date();
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd hh:mm:ss");        
	        
	        if(request.getParameter("submit") != null)
	        {
	        	UserInfo userInfo = null;
	    		try {
	    			userInfo = new UserInfo(fName.toString(), lName.toString(), address1.toString(), address2.toString(),
	    					city.toString(), state.toString(), zip.toString(), country.toString(), ft.format(date));
	    			if (userInfo.validate() == null) {
	    				//everything is correct submit info to database
	    				Controller.submitDatabaseInfo(userInfo);
	    				RequestDispatcher RequestsDispatcherObj = request.getRequestDispatcher("/ThankYou.jsp");
	    		        RequestsDispatcherObj.forward(request, response);    
	    			}
	    			else if(userInfo.validate() == "firstName")
	    			{
	    				//((Object) fName).focus();
	    			}
	    		} catch (Exception e) {

	    		}
	        }
	        else
	        {
	        	
		        RequestDispatcher RequestsDispatcherObj = request.getRequestDispatcher("/Register.jsp");
		        RequestsDispatcherObj.forward(request, response); 
	        }
		}
		
		
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
