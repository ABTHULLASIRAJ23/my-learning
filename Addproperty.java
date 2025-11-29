package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addproperty
 */
@WebServlet("/Addproperty")
public class Addproperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addproperty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");

		PrintWriter writer = response.getWriter();
		
		String name = request.getParameter("name");
        String address = request.getParameter("address");
        String rent = request.getParameter("rent");
        String status = request.getParameter("status");
        String ownerId = request.getParameter("ownerId");
        
        
        String url = "jdbc:mysql://localhost:3306/dynpro";

		String username = "root";

		String Password = "abu123";

		

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url,username,Password);

			PreparedStatement st = con.prepareStatement("INSERT INTO properties(name, address, rent, status, ownerId) VALUES(?,?,?,?,?)");
            st.setString(1, name);
            st.setString(2, address);
            st.setBigDecimal(3, new java.math.BigDecimal(rent));
            st.setString(4, status);
            st.setInt(5, Integer.parseInt(ownerId));
            
             int r = st.executeUpdate();

			

			if(r>0) {

				response.sendRedirect("viewProperties.jsp");

			}else {

				System.out.println("");

			}

		}catch (Exception e) {

			

		}
        
		doGet(request, response);
		}

}

