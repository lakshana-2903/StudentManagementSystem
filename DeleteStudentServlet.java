package com.school.servlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.school.dao.StudentDAO;
import com.school.dao.StudentDAOImpl;
@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDAO dao = new StudentDAOImpl();
        dao.deleteStudent(id);
        response.sendRedirect("viewStudents");
    }
}
