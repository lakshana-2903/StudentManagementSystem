<%@ page import="java.util.*, com.school.model.Student" %>
<h2>All Students</h2>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
        <th>GPA</th>
    </tr>
<%
    List<Student> list = (List<Student>) request.getAttribute("students");
    if (list != null && !list.isEmpty()) {
        for (Student s : list) {
%>
    <tr>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getCourse() %></td>
        <td><%= s.getGpa() %></td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="4">No students found</td>
    </tr>
<%
    }
%>
</table>
