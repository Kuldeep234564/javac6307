package bsc.Cs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet(name = "BScCS", urlPatterns = {"/BScCS"})
/**
 *  implementation class BScCS
 */
public class BScCS extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user_registration";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "Kuld7458#";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BScCS() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (!password.equals(confirmPassword)) {
            out.println("<html><body>");
            out.println("<h2>Passwords do not match!</h2>");
            out.println("<a href='register.jsp'>Try Again</a>");
            out.println("</body></html>");
            return;
        }

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection to the database
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            
            // Prepare SQL statement for inserting data into the users table
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            
            // Execute the statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("login.jsp");
            } else {
                out.println("<html><body>");
                out.println("<h2>Registration Failed</h2>");
                out.println("<a href='register.jsp'>Try Again</a>");
                out.println("</body></html>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("<html><body>");
            out.println("<h2>Database Connection Error: " + e.getMessage() + "</h2>");
            out.println("<a href='register.jsp'>Try Again</a>");
            out.println("</body></html>");
        } finally {
            try {
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
