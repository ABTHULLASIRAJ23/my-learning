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

@WebServlet("/AddTenantServlet")
public class AddTenantServlet extends HttpServlet {
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request. getParameter("role");
        String phone = request.getParameter("phone");
        String unit = request.getParameter("unit");
        String rent = request.getParameter("rent");
      String propertyId = request.getParameter("propertyId");

        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users(name, email, password, role) VALUES(?,?,?,?)");
            PreparedStatement ps1 = con.prepareStatement("insert into tenants( phone, unit, rent) values(?,?,?) ");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, role);
            ps1.setString(1, phone);
            ps1.setInt(2, Integer.parseInt(propertyId));
            ps1.setString(2, unit);
            ps1.setBigDecimal(3, new java.math.BigDecimal(rent));
            ps1.executeUpdate();
            response.sendRedirect("addTenant.jsp?success=1");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("addTenant.jsp?error=1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("addTenant.jsp");
    }
}
