package com.school.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.school.dao.StudentDAO;
import com.school.dao.StudentDAOImpl;
import com.school.model.Student;
@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
    StudentDAO dao = new StudentDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Student> list = dao.getAllStudents();
        for (Student s : list) {
            if (s.getId() == id) {
                request.setAttribute("student", s);
                break;
            }
        }
        request.getRequestDispatcher("view/update_student.jsp")
               .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        float gpa = Float.parseFloat(request.getParameter("gpa"));
        Student student = new Student(id, name, email, course, gpa);
        dao.updateStudent(student);
        response.sendRedirect("viewStudents");
    }
}
