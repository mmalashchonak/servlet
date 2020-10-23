import bo.Person;
import db.DBFactory;
import db.DBTypes;
import db.impl.Database;
import db.impl.MySQLDB;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        request.getRequestDispatcher("index.jsp").include(request, response);
        out.close();
    }
}