package org.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AgreementServlet")
public class AgreementServlet extends HttpServlet {
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
        String property = request.getParameter("property");
        String tenant = request.getParameter("tenant");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String agreement = request.getParameter("agreement");
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO agreements(property, tenant, startDate, endDate, agreement) VALUES(?,?,?,?,?)");
            ps.setString(1, property);
            ps.setString(2, tenant);
            ps.setDate(3, Date.valueOf(startDate));
            ps.setDate(4, Date.valueOf(endDate));
            ps.setString(5, agreement);
            ps.executeUpdate();
            response.sendRedirect("Uagreement.jsp?success=1");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Uagreement.jsp?error=1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Uagreement.jsp");
    }
}
