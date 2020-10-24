import bo.Person;
import db.impl.MySQLDB;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SaveServlet")
public class SaveServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Person person = new Person(name, password);

        MySQLDB.putIntoDB(person);
        out.print("<p>Record saved successfully!</p>");
        request.getRequestDispatcher("web/index.jsp").include(request, response);
        out.close();
    }
}