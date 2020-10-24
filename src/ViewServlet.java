import bo.Person;
import db.impl.MySQLDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<a href='index.jsp'>Add New Person</a>");
        out.println("<h1>Persons List</h1>");

        List<Person> list = MySQLDB.getAll();

        out.print("<table border='1'");
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");
        for (Person e : list) {
            out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getPassword() + "</td>" +
                    "<td><a href='EditServlet?id=" + e.getId() + "'>edit</a></td>" +
                    "<td><a href='DeleteServlet?id=" + e.getId() + "'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();
    }
}  