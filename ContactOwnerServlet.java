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

@WebServlet("/ContactOwnerServlet")
public class ContactOwnerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/dynpro";
        String username = "root";
        String Password = "abu123";
        return DriverManager.getConnection(url, username, Password);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenantName = request.getParameter("tenantName");
        String tenantEmail = request.getParameter("tenantEmail");
        String message = request.getParameter("message");
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO contacts(tenantName, tenantEmail, message) VALUES(?,?,?)");
            ps.setString(1, tenantName);
            ps.setString(2, tenantEmail);
            ps.setString(3, message);
            ps.executeUpdate();
            response.sendRedirect("contactOwner.jsp?success=1");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("contactOwner.jsp?error=1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("contactOwner.jsp");
    }
}
