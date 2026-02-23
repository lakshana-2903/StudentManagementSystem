<%@ page import="com.school.model.Student" %>
<%
    Student s = (Student) request.getAttribute("student");
%>	
<h2>Update Student</h2>
<form action="../updateStudent" method="post">
    <input type="hidden" name="id" value="<%= s.getId() %>">
    Name: <input type="text" name="name" value="<%= s.getName() %>"><br><br>
    Email: <input type="text" name="email" value="<%= s.getEmail() %>"><br><br>
    Course: <input type="text" name="course" value="<%= s.getCourse() %>"><br><br>
    GPA: <input type="text" name="gpa" value="<%= s.getGpa() %>"><br><br>
    <input type="submit" value="Update">
</form>
