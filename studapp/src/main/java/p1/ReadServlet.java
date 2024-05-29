package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studtech", "root", "root");
            String sql = "select * from student";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.print("<title>Student Records</title>");
            out.print("<style>");
            out.print("body {");
            out.print("background: black;");
            out.print("overflow-x: hidden;");  // Add overflow-x: hidden to hide horizontal scrollbar
            out.print("}");

            out.print("@keyframes fireEffect {");
            out.print("0% {");
            out.print("background-color: #e74c3c;");
            out.print("}");
            out.print("50% {");
            out.print("background-color: #ffbe76;");
            out.print("}");
            out.print("100% {");
            out.print("background-color: #e74c3c;");
            out.print("}");
            out.print("}");

            out.print("h1 {");
            out.print("position: fixed;");
            out.print("top: 50%;");
            out.print("left: 50%;");
            out.print("transform: translate(-50%, -50%);");
            out.print("font-size: 3em;");
            out.print("color: rgba(255, 255, 255, 0.5);");
            out.print("z-index: -1;");
            out.print("}");

            out.print("h2 {");
            out.print("color: #2ecc71;");
            out.print("text-align: center;");
            out.print("margin-top: 30px;");
            out.print("}");

            out.print("table {");
            out.print("width: 100%;");
            out.print("border-collapse: collapse;");
            out.print("margin-top: 20px;");
            out.print("box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
            out.print("transform: translateZ(0);");
            out.print("transition: transform 0.2s ease;");
            out.print("}");

            out.print("table:hover {");
            out.print("transform: scale(1.02);");
            out.print("}");

            out.print("th, td {");
            out.print("border: 1px solid #ddd;");
            out.print("padding: 12px;");
            out.print("text-align: left;");
            out.print("background-color: #fff;"); // Set background color to white
            out.print("}");

            out.print("th {");
            out.print("background-color: #3498db;");
            out.print("color: #fff;");
            out.print("}");

            out.print("tr:hover {");
            out.print("background-color: #e74c3c;");
            out.print("box-shadow: 0 12px 16px rgba(0, 0, 0, 0.2);");
            out.print("}");

            out.print(".center {");
            out.print("text-align: center;");
            out.print("margin-top: 20px;");
            out.print("color: black;"); // Set text color to black
            out.print("}");

            out.print(".btn {");
            out.print("padding: 10px 20px;");
            out.print("font-size: 16px;");
            out.print("color: #fff;");
            out.print("border: none;");
            out.print("border-radius: 5px;");
            out.print("cursor: pointer;");
            out.print("transition: box-shadow 0.3s ease;");
            out.print("}");

            out.print(".btn-update {");
            out.print("background-color: #2ecc71;"); // Green color for update button
            out.print("}");

            out.print(".btn-delete {");
            out.print("background-color: #e74c3c;"); // Red color for delete button
            out.print("}");

            out.print(".btn:hover {");
            out.print("box-shadow: 0 0 10px black; /* Black Box Shadow on Hover */");
            out.print("}");

            out.print(".btn-home {");
            out.print("color: black;"); // Set text color to black
            out.print("}");

            out.print(".btn-home:hover {");
            out.print("background-color: #2980b9;");
            out.print("box-shadow: 0 0 10px black; /* Black Box Shadow on Hover */");
            out.print("}");

            out.print(".footer {");
            out.print("text-align: center;");
            out.print("padding: 10px;");
            out.print("background-color: rgba(0, 0, 0, 0.7);");
            out.print("position: absolute;");
            out.print("bottom: 0;");
            out.print("width: 100%;");
            out.print("color: #fff;");
            out.print("}");

            out.print(".footer p {");
            out.print("margin: 0;");
            out.print("}");

            out.print(".instagram-icon {");
            out.print("width: 30px;");
            out.print("height: 30px;");
            out.print("border-radius: 50%;");
            out.print("cursor: pointer;");
            out.print("transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out;");
            out.print("}");

            out.print(".instagram-icon:hover {");
            out.print("transform: rotate(360deg);");
            out.print("box-shadow: 0 0 10px #8b0000; /* Dark Red Box Shadow */");
            out.print("}");

            out.print("@media only screen and (max-width: 600px) {");
            out.print("table {");
            out.print("width: 100%;"); // Adjusted table width for small screens
            out.print("}");

            out.print("h1 {");
            out.print("font-size: 2em;");
            out.print("}");

            out.print(".center {");
            out.print("margin-top: 10px;");
            out.print("}");

            out.print(".btn {");
            out.print("font-size: 14px;");
            out.print("}");

            out.print(".footer p {");
            out.print("font-size: 12px;");
            out.print("}");
            out.print("}");

            out.print("</style>");
            out.print("</head>");
            out.print("<body>");

            out.print("<h1 id='crudName'></h1>");

            out.print("<h2>Student Records</h2>");

            out.print("<table>");
            out.print("<tr>");
            out.print("<th>ID </th>");
            out.print("<th>Name </th>");
            out.print("<th>Marks </th>");
            out.print("<th>Actions </th>"); // New column for actions
            out.print("</tr>");

            while (rs.next()) {
                out.print("<tr>");
                out.print("<td>" + rs.getInt(1) + "</td>");
                out.print("<td>" + rs.getString(2) + "</td>");
                out.print("<td>" + rs.getDouble(3) + "</td>");
                // Actions column with hyperlinks
                out.print("<td>");
                out.print("<a href='update.html"  + "' class='btn btn-update'>Update</a>");
                out.print("<a href='delete.html" +  "' class='btn btn-delete'>Delete</a>");
                out.print("</td>");
                out.print("</tr>");
            }

            out.print("</table>");

            // Button to redirect to index.html
            out.print("<div class='center'>");
            out.print("<form action='index.html'>");
            out.print("<input type='submit' class='btn btn-home' value='Go to Home' style='color:black'>");
            out.print("</form>");
            out.print("</div>");

            out.print("<div class='footer'>");
            out.print("<p>&#169; Tanmay Kapse | Tanmay CRUD Application</p>");
            out.print("<a href='https://www.instagram.com/tanmay_kapse_patil/?igshid=ZDdkNTZiNTM%3D' target='_blank'>");
            out.print("<img class='instagram-icon' src='insta.jpg' alt='Instagram'>");
            out.print("</a>");
            out.print("</div>");

            out.print("</body>");
            out.print("</html>");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
