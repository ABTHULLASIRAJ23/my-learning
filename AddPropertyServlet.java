package org.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddPropertyServlet")
public class AddPropertyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/dynpro";
        String username = "root";
        String Password = "12345678";
        return DriverManager.getConnection(url, username, Password);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String rent = request.getParameter("rent");
        String status = request.getParameter("status");
        String ownerId = request.getParameter("ownerId");
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO properties(name, address, rent, status, ownerId) VALUES(?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setBigDecimal(3, new java.math.BigDecimal(rent));
            ps.setString(4, status);
            ps.setInt(5, Integer.parseInt(ownerId));
            ps.executeUpdate();
            response.sendRedirect("addProperty.jsp?success=1");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("addProperty.jsp?error=1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("addProperty.jsp");
    }
}
