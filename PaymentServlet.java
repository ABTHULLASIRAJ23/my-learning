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

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
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
        String month = request.getParameter("month");
        String amount = request.getParameter("amount");
        String method = request.getParameter("method");
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO payments(month, amount, method) VALUES(?,?,?)");
            ps.setString(1, month);
            ps.setBigDecimal(2, new java.math.BigDecimal(amount));
            ps.setString(3, method);
            ps.executeUpdate();
            response.sendRedirect("payment.jsp?success=1");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("payment.jsp?error=1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("payment.jsp");
    }
}
