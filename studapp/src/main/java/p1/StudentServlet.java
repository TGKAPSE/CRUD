package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

    public StudentServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String name = request.getParameter("uname");
        String marks = request.getParameter("marks");

        int id1 = Integer.parseInt(id);
        double marks1 = Double.parseDouble(marks);

        // DATABASE
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studtech", "root", "root");
            String sql = "insert into student values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id1);
            ps.setString(2, name);
            ps.setDouble(3, marks1);
            int i = ps.executeUpdate();

            out.print("<html>");
            out.print("<head>");
            out.print("<style>");
            out.print("h1 {");
            out.print("color: #27ae60;"); // Green color
            out.print("}");
            out.print("</style>");
            out.print("<script>");
            out.print("function showPopup() {");
            out.print("var popupText = document.getElementById('popupText').innerText;");
            out.print("alert('Record inserted successfully: ' + popupText);");
            out.print("window.location.href = 'index.html';"); // Redirect to index.html
            out.print("}");
            out.print("</script>");
            out.print("</head>");
            out.print("<body>");

            if (i > 0) {
                out.print("<h1 id='popupText' style='display:none;'>RECORD INSERTED SUCCESSFULLY !!!</h1>");
                out.print("<script>showPopup();</script>");
            }

            out.print("</body>");
            out.print("</html>");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
