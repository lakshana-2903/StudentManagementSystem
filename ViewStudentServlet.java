package com.school.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.school.dao.StudentDAO;
import com.school.dao.StudentDAOImpl;
import com.school.model.Student;
@WebServlet("/viewStudents")
public class ViewStudentServlet extends HttpServlet {
 @Override	
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDAO dao = new StudentDAOImpl();
        List<Student> studentList = dao.getAllStudents();
        request.setAttribute("students", studentList);
        request.getRequestDispatcher("/view/view_students.jsp")
               .forward(request, response);
    }
}
