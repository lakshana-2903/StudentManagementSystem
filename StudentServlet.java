package com.school.servlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.school.dao.StudentDAO;
import com.school.dao.StudentDAOImpl;
import com.school.model.Student;
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/add-student.jsp")
               .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("AddStudentServlet doPost called");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        float gpa = Float.parseFloat(request.getParameter("gpa"));
        Student student = new Student(name, email, course, gpa);
        StudentDAO dao = new StudentDAOImpl();
        dao.addStudent(student);
        response.sendRedirect("viewStudents");
    }
}
