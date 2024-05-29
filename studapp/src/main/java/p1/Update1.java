
package p1;

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

@WebServlet("/update1")
public class Update1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("eid");
        String name = request.getParameter("uname");
        String marks = request.getParameter("marks");
        int id1 = Integer.parseInt(id);
        double marks1 = Double.parseDouble(marks);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studtech", "root", "root");

            String sql = "update student set marks=? where name=? and id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, marks1);
            ps.setString(2, name);
            ps.setInt(3, id1);

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
            out.print("alert('Record updated successfully: ' + popupText);");
            out.print("window.location.href = 'index.html';"); // Redirect to index.html
            out.print("}");
            out.print("</script>");
            out.print("</head>");
            out.print("<body>");

            if (i > 0) {
                out.print("<h1 id='popupText' style='display:none;'>RECORD UPDATED SUCCESSFULLY !!!</h1>");
                out.print("<script>showPopup();</script>");
            }

            out.print("</body>");
            out.print("</html>");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
