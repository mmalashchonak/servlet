import bo.Person;
import db.DBFactory;
import db.DBTypes;
import db.impl.MySQLDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("name");
        String password=request.getParameter("password");

        Person person = new Person(name, password, id);

        MySQLDB.update(person);
                    response.sendRedirect("ViewServlet");
    }

}  