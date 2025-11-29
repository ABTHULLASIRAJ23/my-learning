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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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

		

		//Register r = new Register()

		String name = request.getParameter("name");

		String email = request.getParameter("email");

		String password = request.getParameter("password");
		
		String role = request.getParameter("role");

		

		

		String url = "jdbc:mysql://localhost:3306/dynpro";

		String username = "root";

		String Password = "abu123";

		

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url,username,Password);

			PreparedStatement st = con.prepareStatement("insert into users(name,email,password,role) values (?,?,?,?)");

			

			st.setString(1, name);

			st.setString(2, email);

			st.setString(3, password);
			
			st.setString(4, role);

			

			int r = st.executeUpdate();

			

			if(r>0) {

				response.sendRedirect("login.jsp");

			}else {

				System.out.println("");

			}

		}catch (Exception e) {

			

		}

		doGet(request, response);
	}

}
