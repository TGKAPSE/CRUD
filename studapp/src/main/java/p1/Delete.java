package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
@WebServlet("/delete1")
public class Delete extends HttpServlet {

    public Delete() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("did");

        int id1 = Integer.parseInt(id);

        // DATABASE
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studtech", "root", "root");

            String sql = "delete from student where id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id1);

            int i = ps.executeUpdate();

            out.print("<html>");
            out.print("<head>");
            out.print("<script>");
            out.print("function showPopup() {");
            out.print("var popupText = document.getElementById('popupText').textContent;");
            out.print("alert(popupText);");
            out.print("window.location.href = 'index.html';"); // Redirect to index.html
            out.print("}");
            out.print("</script>");
            out.print("</head>");
            out.print("<body>");

            if (i > 0) {
                out.print("<div id='popupText' style='display:none;'>RECORD DELETED SUCCESS !!!</div>");
                out.print("<script>showPopup();</script>");
            }

            out.print("</body>");
            out.print("</html>");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
